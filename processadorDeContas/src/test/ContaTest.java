package test;

import model.Conta;
import model.Fatura;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContaTest {

    @Test
    public void testCriarContaComDadosValidos() {

        Conta conta = new Conta("12122024", "12-12-2024", 150);

        double delta = 0.0001;

        assertEquals("12122024", conta.getCodigoDaConta());
        assertEquals("12-12-2024", conta.getData());
        assertEquals(150.00, conta.getValorPago(), delta);

    }

}
