package Junit5Tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Enum.TipoIngresso;
import Model.Ingresso;
import Model.Lote;
import Model.Show;

public class Junit5Tests {

    private Ingresso[] ingressos;
    private Ingresso[] ingressosInvalidos;
    private Lote lote;
    private Lote loteInvalido;
    private Lote lote1;
    private Lote lote2;
    private Show showEstavel;
    private Show showLucro;
    private Show showPrejuizo;

    @BeforeEach
    void setup() {
        this.ingressos = new Ingresso[]{
            new Ingresso("123abc", TipoIngresso.VIP, false, 30),
            new Ingresso("123abc", TipoIngresso.VIP, false, 30),
            new Ingresso("789ghi", TipoIngresso.NORMAL, false, 20),
            new Ingresso("789ghi", TipoIngresso.NORMAL, false, 20),
            new Ingresso("789ghi", TipoIngresso.NORMAL, false, 20),
            new Ingresso("789ghi", TipoIngresso.NORMAL, false, 20),
            new Ingresso("789ghi", TipoIngresso.NORMAL, false, 20),
            new Ingresso("789ghi", TipoIngresso.NORMAL, false, 20),
            new Ingresso("789ghi", TipoIngresso.NORMAL, false, 20),
            new Ingresso("091efg", TipoIngresso.MEIA_ENTRADA, false, 10),
        };

        ingressosInvalidos = new Ingresso[]{
            new Ingresso("123abc", TipoIngresso.VIP, false, 30),
            new Ingresso("123abc", TipoIngresso.VIP, false, 30),
            new Ingresso("789ghi", TipoIngresso.VIP, false, 20),
            new Ingresso("789ghi", TipoIngresso.VIP, false, 20),
            new Ingresso("789ghi", TipoIngresso.NORMAL, false, 20),
            new Ingresso("789ghi", TipoIngresso.NORMAL, false, 20),
            new Ingresso("789ghi", TipoIngresso.NORMAL, false, 20),
            new Ingresso("789ghi", TipoIngresso.NORMAL, false, 20),
            new Ingresso("789ghi", TipoIngresso.NORMAL, false, 20),
            new Ingresso("091efg", TipoIngresso.MEIA_ENTRADA, false, 10),
        };

        lote = new Lote("456def", ingressos, 10);
        loteInvalido = new Lote("456def", ingressosInvalidos, 10);

        lote1 = new Lote("456def", new Ingresso[]{
            new Ingresso("123abc", TipoIngresso.VIP, true, 30),
            new Ingresso("789ghi", TipoIngresso.NORMAL, true, 20),
            new Ingresso("091efg", TipoIngresso.MEIA_ENTRADA, false, 10),
        }, 10);

        lote2 = new Lote("arttyu", new Ingresso[]{
            new Ingresso("qwe", TipoIngresso.VIP, true, 100),
            new Ingresso("asd", TipoIngresso.NORMAL, false, 50),
            new Ingresso("zxc", TipoIngresso.MEIA_ENTRADA, false, 25),
        }, 5);

        showEstavel = new Show("16/12/2024", "Fubica", 50, 50, new Lote[]{lote1, lote2}, false);
        showLucro = new Show("16/12/2024", "Fubica", 51, 50, new Lote[]{lote1, lote2}, false);
        showPrejuizo = new Show("16/12/2024", "Fubica", 49, 50, new Lote[]{lote1, lote2}, false);
    }

    @Test
    void testQtdIngressos() {
        assertAll(
            () -> assertEquals(2, lote.getIngressosVip().length, "Quantidade de ingressos VIP incorreta"),
            () -> assertEquals(7, lote.getIngressosNormal().length, "Quantidade de ingressos Normal incorreta"),
            () -> assertEquals(1, lote.getIngressosMeia().length, "Quantidade de ingressos Meia-Entrada incorreta")
        );
    }

    @Test
    void testQtdIngressosInvalido() {
        assertFalse(loteInvalido.isQtdIngressosValidos(), "Quantidade de ingressos não deveria ser válida");
    }

    @Test
    void testLoteComDesconto() {
        assertAll(
            () -> assertTrue(lote.setDesconto(0), "Desconto de 0% deveria ser válido"),
            () -> assertTrue(lote.setDesconto(25), "Desconto de 25% deveria ser válido"),
            () -> assertFalse(lote.setDesconto(26), "Desconto de 26% não deveria ser válido")
        );
    }

    @Test
    void testIngressoComDesconto() {
        lote.setValorIngresso(10);

        assertAll(
            () -> assertEquals(0, lote.getIngressosMeia()[0].getValor(), "Valor da Meia-Entrada incorreto"),
            () -> assertEquals(10, lote.getIngressosVip()[0].getValor(), "Valor do VIP incorreto"),
            () -> assertEquals(10, lote.getIngressosNormal()[0].getValor(), "Valor do Normal incorreto")
        );
    }

    @Test
    void testValorIngresso() {
        lote.setValorIngresso(10);

        assertAll(
            () -> assertEquals(20, lote.getValorIngressoVip(), "Valor VIP incorreto"),
            () -> assertEquals(10, lote.getValorIngressoNormal(), "Valor Normal incorreto"),
            () -> assertEquals(5, lote.getValorIngressoMeia(), "Valor Meia incorreto"),
            () -> assertNotEquals(6, lote.getValorIngressoMeia(), "Valor Meia não deveria ser 6"),
            () -> assertNotEquals(4, lote.getValorIngressoMeia(), "Valor Meia não deveria ser 4"),
            () -> assertNotEquals(10, lote.getValorIngressoMeia(), "Valor Meia não deveria ser 10")
        );
    }

    @Test
    void testLucroPrejuizo() {
        assertAll(
            () -> assertEquals("ESTAVEL", showEstavel.getStatus(), "Status deveria ser ESTAVEL"),
            () -> assertEquals("LUCRO", showLucro.getStatus(), "Status deveria ser LUCRO"),
            () -> assertEquals("PREJUIZO", showPrejuizo.getStatus(), "Status deveria ser PREJUIZO")
        );
    }

    @Test
    void testMudancaValorIngresso() {
        lote.setValorIngresso(15);
        assertAll(
            () -> assertEquals(30, lote.getValorIngressoVip(), "Valor VIP incorreto após mudança"),
            () -> assertEquals(15, lote.getValorIngressoNormal(), "Valor Normal incorreto após mudança"),
            () -> assertEquals(7.5, lote.getValorIngressoMeia(), "Valor Meia incorreto após mudança")
        );

        lote.setValorIngresso(20);
        assertAll(
            () -> assertEquals(40, lote.getValorIngressoVip(), "Valor VIP incorreto após segunda mudança"),
            () -> assertEquals(20, lote.getValorIngressoNormal(), "Valor Normal incorreto após segunda mudança"),
            () -> assertEquals(10, lote.getValorIngressoMeia(), "Valor Meia incorreto após segunda mudança")
        );
    }

    @Test
    void testMudancaStatusShow() {
        showEstavel.setIngressosVendidos(60);
        assertEquals("LUCRO", showEstavel.getStatus(), "Status deveria mudar para LUCRO após aumentar ingressos vendidos");

        showEstavel.setIngressosVendidos(40);
        assertEquals("PREJUIZO", showEstavel.getStatus(), "Status deveria mudar para PREJUIZO após reduzir ingressos vendidos");
    }
}
