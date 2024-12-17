package test;
import org.junit.Test;
import Enum.TipoIngresso;
import Model.Ingresso;
import Model.Lote;

import static org.junit.Assert.assertEquals;

public class LoteTest {

    @Test
    public void LoteTestes() {
        Ingresso[] ingressos = {
        new Ingresso("123abc", TipoIngresso.VIP, false, 30),
        new Ingresso("789ghi", TipoIngresso.NORMAL, false, 20),
        new Ingresso("091efg", TipoIngresso.MEIA_ENTRADA, false, 10),
        };
        Lote lote = new Lote("456def", ingressos, 10);

        double delta = 0.0001;
        lote.setDesconto(30);
        assertEquals(10, lote.getDesconto(), delta);
        lote.setDesconto(22);
        assertEquals(22, lote.getDesconto(), delta);
    }    
}
