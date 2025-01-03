package test;

import model.Conta;
import model.Fatura;
import controller.ProcessadorDeContasController;
import org.junit.Test;
import model.TipoPagamentoEnum;

import java.util.List;

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


    @Test
    public void testStatusFaturaComPagamentoInsuficiente() {
        Fatura fatura = new Fatura("12-12-2024", 150.00, "Cliente Teste");

        Conta conta1 = new Conta("001", "12-12-2024", 100.00, TipoPagamentoEnum.BOLETO);
        List<Conta> contas = List.of(conta1);


        ProcessadorDeContasController processador = new ProcessadorDeContasController();
        processador.processarPagamento(fatura, contas);


        assertEquals(Fatura.StatusPagamento.PENDENTE, fatura.getStatus());
    }


}
