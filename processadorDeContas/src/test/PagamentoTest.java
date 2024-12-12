package test;

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


}
