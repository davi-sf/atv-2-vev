package test;

import model.Conta;
import model.Fatura;
import model.Pagamento;
import controller.ProcessadorDeContasController;
import org.junit.Test;
import model.TipoPagamentoEnum;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PagamentoTest {

    @Test
    public void testCriarPagamentoComDadosValidos() {
    Pagamento pagamento = new Pagamento(100.00, "12-12-2024", TipoPagamentoEnum.BOLETO);

    double delta = 0.0001;


    assertEquals(100.00, pagamento.getValorPago(), delta);
    assertEquals("12-12-2024", pagamento.getDataPagamento());
    assertEquals(TipoPagamentoEnum.BOLETO, pagamento.getTipoPagamento());
}


    @Test
    public void testPagamentoBoletoSemAtraso() {
        Fatura fatura = new Fatura("12-12-2024", 150.00, "Cliente Teste");
        Conta conta = new Conta("12122024", "12-12-2024", 150.00, TipoPagamentoEnum.BOLETO);
        Pagamento pagamento = new Pagamento(150.00, "12-12-2024", TipoPagamentoEnum.BOLETO);
        double valorPagoComAjuste = pagamento.calcularValorPagoComAjustes(fatura, conta);
        assertEquals(150.00, valorPagoComAjuste, 0.0001);
    }

    @Test
    public void testPagamentoBoletoComAtraso() {
        Fatura fatura = new Fatura("12-12-2024", 150.00, "Cliente Teste");
        Conta conta = new Conta("12122024", "12-12-2024", 150.00, TipoPagamentoEnum.BOLETO);
        Pagamento pagamento = new Pagamento(150.00, "14-12-2024", TipoPagamentoEnum.BOLETO);
        double valorPagoComAjuste = pagamento.calcularValorPagoComAjustes(fatura, conta);
        assertEquals(165.00, valorPagoComAjuste, 0.0001);
    }


    @Test
    public void testPagamentoCartaoCreditoForaDoPeriodoPermitido() {
        Fatura fatura = new Fatura("20-02-2024", 1500.00, "Cliente Teste");


        Conta conta = new Conta("001", "15-02-2024", 700.00, TipoPagamentoEnum.CARTAO_CREDITO);
        List<Conta> contas = List.of(conta);

        ProcessadorDeContasController processador = new ProcessadorDeContasController();
        processador.processarPagamento(fatura, contas);


        assertEquals(Fatura.StatusPagamento.PENDENTE, fatura.getStatus());
    }

    @Test
    public void testPagamentoCartaoCreditoDentroDoPeriodoPermitido() {

        Fatura fatura = new Fatura("20-02-2024", 1500.00, "Cliente Teste");


        Conta conta = new Conta("001", "01-02-2024", 700.00, TipoPagamentoEnum.CARTAO_CREDITO);
        List<Conta> contas = List.of(conta);

        ProcessadorDeContasController processador = new ProcessadorDeContasController();
        processador.processarPagamento(fatura, contas);


        assertEquals(Fatura.StatusPagamento.PENDENTE, fatura.getStatus());
    }


}
