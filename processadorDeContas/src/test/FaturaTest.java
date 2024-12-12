package test;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FaturaTest {


    @Test
    public void testCriarFaturaComDadosValidos() {

        Fatura fatura = new Fatura("2024-12-12", 150.00, "Cliente Exemplo");

        assertEquals("12-12-2024", fatura.getData());
        assertEquals(150.00, fatura.getValorTotal());
        assertEquals("Cliente Exemplo", fatura.getNomeCliente());

    }


}
