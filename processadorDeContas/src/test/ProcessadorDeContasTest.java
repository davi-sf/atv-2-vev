package test;

import model.Conta;
import model.Fatura;
import model.TipoPagamentoEnum;
import controller.ProcessadorDeContasController;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProcessadorDeContasTest {

    @Test
    public void testFaturaMarcadaComoPagaComContasPagasEmDia() {
        Fatura fatura = new Fatura("20-02-2023", 1500.00, "Cliente Teste");
        List<Conta> contas = List.of(
                new Conta("001", "20-02-2023", 500.00, TipoPagamentoEnum.BOLETO),
                new Conta("002", "20-02-2023", 400.00, TipoPagamentoEnum.BOLETO),
                new Conta("003", "20-02-2023", 600.00, TipoPagamentoEnum.BOLETO)
        );

        ProcessadorDeContasController processador = new ProcessadorDeContasController();
        processador.processarPagamento(fatura, contas);

        assertEquals(Fatura.StatusPagamento.PAGA, fatura.getStatus());
    }

    @Test
    public void testFaturaMarcadaComoPagaComTiposDePagamentoDiferentes() {
        Fatura fatura = new Fatura("20-02-2023", 1500.00, "Cliente Teste");
        List<Conta> contas = List.of(
                new Conta("004", "05-02-2023", 700.00, TipoPagamentoEnum.CARTAO_CREDITO),
                new Conta("005", "17-02-2023", 800.00, TipoPagamentoEnum.TRANSFERENCIA_BANCARIA)
        );

        ProcessadorDeContasController processador = new ProcessadorDeContasController();
        processador.processarPagamento(fatura, contas);

        assertEquals(Fatura.StatusPagamento.PAGA, fatura.getStatus());
    }

    @Test
    public void testFaturaMarcadaComoPendentePorContaCartaoForaDoPrazo() {
        Fatura fatura = new Fatura("20-02-2023", 1500.00, "Cliente Teste");
        List<Conta> contas = List.of(
                new Conta("006", "06-02-2023", 700.00, TipoPagamentoEnum.CARTAO_CREDITO),
                new Conta("007", "17-02-2023", 800.00, TipoPagamentoEnum.TRANSFERENCIA_BANCARIA)
        );

        ProcessadorDeContasController processador = new ProcessadorDeContasController();
        processador.processarPagamento(fatura, contas);

        assertEquals(Fatura.StatusPagamento.PAGA, fatura.getStatus());
    }


}
