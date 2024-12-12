package test;

import model.Fatura;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FaturaTest {


    @Test
    public void testCriarFaturaComDadosValidos() {

        Fatura fatura = new Fatura("12-12-2024", 150.00, "Cliente Teste");

        double delta = 0.0001;

        assertEquals("12-12-2024", fatura.getData());
        assertEquals(150.00, fatura.getValorTotal(), delta);
        assertEquals("Cliente Teste", fatura.getNomeCliente());

    }

}
