package functionalTests;
import org.junit.Test;
import Enum.TipoIngresso;
import Model.Ingresso;
import Model.Lote;
import Model.Show;

import static org.junit.Assert.assertEquals;

public class FunctionalTests {
   
    @Test
    public void TesteQtdIngressos() {
        Ingresso[] ingressos = {
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
        Lote lote = new Lote("456def", ingressos, 10);
        Ingresso [] ingressosVip;
        Ingresso [] ingressosNormal;
        Ingresso [] ingressosMeia;

        ingressosVip = lote.getIngressosVip();
        ingressosNormal = lote.getIngressosNormal();
        ingressosMeia = lote.getIngressosMeia();


        assertEquals(2, ingressosVip.length);
        assertEquals(7, ingressosNormal.length);
        assertEquals(1, ingressosMeia.length);
    }    

    @Test
    public void TesteQtdIngressosInvalido() {
        Ingresso[] ingressos = {
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
        Lote lote = new Lote("456def", ingressos, 10);

        assertEquals(false, lote.isQtdIngressosValidos());
    }    

    @Test
    public void TesteLoteComDesconto() {
        Ingresso[] ingressos = {
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
        Lote lote = new Lote("456def", ingressos, 10);
        assertEquals(true, lote.setDesconto(0));
        assertEquals(true, lote.setDesconto(25));
        assertEquals(false, lote.setDesconto(26));
    }   

    @SuppressWarnings("deprecation")
    @Test
    public void TesteIngressoComDesconto() {
        Ingresso[] ingressos = {
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
        Lote lote = new Lote("456def", ingressos, 10);

        Ingresso [] ingressosMeia = lote.getIngressosMeia();
        assertEquals(0, ingressosMeia[0].getValor());
        Ingresso [] ingressosVip = lote.getIngressosVip();
        assertEquals(10, ingressosVip[0].getValor());
        Ingresso [] ingressosNormal = lote.getIngressosNormal();
        assertEquals(10, ingressosNormal[0].getValor());
    }   

        @Test
    public void TesteLucroPrejuizo() {
        Ingresso[] ingressos = {
            new Ingresso("123abc", TipoIngresso.VIP, true, 30),
            new Ingresso("789ghi", TipoIngresso.NORMAL, true, 20),
            new Ingresso("091efg", TipoIngresso.MEIA_ENTRADA, false, 10),
            };
        Ingresso[] ingressoLote2 = {
            new Ingresso("qwe", TipoIngresso.VIP, true, 100),
            new Ingresso("asd", TipoIngresso.NORMAL, false, 50),
            new Ingresso("zxc", TipoIngresso.MEIA_ENTRADA, false, 25),
            };
        Lote[] lotes = {
            new Lote("456def", ingressos, 10),
            new Lote("arttyu", ingressoLote2, 5),
            };

    
        Show show3 = new Show("16/12/2024", "Fubica", 50, 50, lotes, false);
        Show show4 = new Show("16/12/2024", "Fubica", 51, 50, lotes, false);
        Show show5 = new Show("16/12/2024", "Fubica", 49, 50, lotes, false);

        assertEquals("ESTAVEL", show3.getStatus());
        assertEquals("LUCRO", show4.getStatus());
        assertEquals("PREJUIZO", show5.getStatus());
    }

}