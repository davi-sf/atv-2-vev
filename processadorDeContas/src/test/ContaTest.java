package test;

import model.Fatura;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContaTest {

    @Test
    public void testCriarContaComDadosValidos() {

        Conta conta = new Conta("12-12-2024", 150.00, "Cliente Teste");

        double delta = 0.0001;

        assertEquals("665544", conta.codigoDaConta());
        assertEquals("12-12-2024", conta.getData());
        assertEquals(150.00, conta.getValorPago(), delta);

    }

}
