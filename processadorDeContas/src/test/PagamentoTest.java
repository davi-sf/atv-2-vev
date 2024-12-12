package test;

import model.Conta;
import model.Fatura;
import model.Pagamento;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PagamentoTest {

    @Test
    public void testCriarPagamentoComDadosValidos() {
    Pagamento pagamento = new Pagamento(100.00, "12-12-2024", "BOLETO");

    double delta = 0.0001;


    assertEquals(100.00, pagamento.getValorPago(), delta);
    assertEquals("12-12-2024", pagamento.getDataPagamento());
    assertEquals("BOLETO", pagamento.getTipoPagamento());
}


    @Test
    public void testPagamentoBoletoSemAtraso() {
        Fatura fatura = new Fatura("12-12-2024", 150.00, "Cliente Teste");
        Conta conta = new Conta("12122024", "12-12-2024", 150.00);
        Pagamento pagamento = new Pagamento(150.00, "12-12-2024", TipoPagamento.BOLETO);
        double valorPagoComAjuste = pagamento.calcularValorPagoComAjustes(fatura, conta);
        assertEquals(150.00, valorPagoComAjuste, 0.0001);
    }

    @Test
    public void testPagamentoBoletoComAtraso() {
        Fatura fatura = new Fatura("12-12-2024", 150.00, "Cliente Teste");
        Conta conta = new Conta("12122024", "12-12-2024", 150.00);
        Pagamento pagamento = new Pagamento(150.00, "14-12-2024", TipoPagamento.BOLETO);
        double valorPagoComAjuste = pagamento.calcularValorPagoComAjustes(fatura, conta);
        assertEquals(165.00, valorPagoComAjuste, 0.0001);
    }


}
