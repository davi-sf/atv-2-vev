package test;

import Enum.TipoIngresso;
import Model.Ingresso;
import Model.Lote;
import Model.Show;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class ShowTest {
    
    @Test
    public void ShowTestes() {
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

        Show show = new Show("16/12/2024", "Fubica", 20, 50, lotes, false);
        String relatorio = "VIP: 2; NORMAL: 1; MEIA_ENTRADA: 0; Receita: 70,00; Status: LUCRO";
        Show show2 = new Show("16/12/2024", "Fubica", 20000000, 50, lotes, false);
        String relatorio2 = "VIP: 2; NORMAL: 1; MEIA_ENTRADA: 0; Receita: -19999910,00; Status: PREJUIZO";

        assertEquals(relatorio, show.getRelatorio());
        assertEquals(relatorio2, show2.getRelatorio());

    }
}
