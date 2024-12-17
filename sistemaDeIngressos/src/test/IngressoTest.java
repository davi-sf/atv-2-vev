package test;
import org.junit.Test;
import Enum.TipoIngresso;
import Model.Ingresso;
import static org.junit.Assert.assertEquals;

public class IngressoTest {
   
    @Test
    public void testIngresso() {
        Boolean vendido = true;
        Ingresso ingresso = new Ingresso("123abc", TipoIngresso.MEIA_ENTRADA, vendido, 10);
        assertEquals(true, ingresso.getStatus());
        assertEquals("123abc", ingresso.getId());
        assertEquals(TipoIngresso.MEIA_ENTRADA, ingresso.getTipo());
        ingresso.setStatus(false);
        assertEquals(false, ingresso.getStatus());
    }

    @Test
    public void testVip() {
        Boolean vendido = true;
        Ingresso ingresso = new Ingresso("123abc", TipoIngresso.VIP, vendido, 30);
        assertEquals(TipoIngresso.VIP, ingresso.getTipo());
    }

    
}
