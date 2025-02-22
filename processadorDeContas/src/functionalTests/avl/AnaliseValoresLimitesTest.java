package functionalTests.avl;

import controller.ProcessadorDeContasController;
import model.Conta;
import model.Fatura;
import model.TipoPagamentoEnum;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnaliseValoresLimitesTest {

    @Test
    public void testValorMinimo() {
        Fatura fatura = new Fatura("20/02/2023", 0.01, "Cliente A");
        List<Conta> contas = Arrays.asList(
                new Conta("1", "20/02/2023", 0.01, TipoPagamentoEnum.BOLETO)
        );

        ProcessadorDeContasController processador = new ProcessadorDeContasController();
        processador.processarPagamento(fatura, contas);

        assertEquals(Fatura.StatusPagamento.PAGA, fatura.getStatus());
    }

    @Test
    public void testValorLogoAcimaDoMinimo() {
        Fatura fatura = new Fatura("20/02/2023", 0.02, "Cliente B");
        List<Conta> contas = Arrays.asList(
                new Conta("1", "20/02/2023", 0.02, TipoPagamentoEnum.BOLETO)
        );

        ProcessadorDeContasController processador = new ProcessadorDeContasController();
        processador.processarPagamento(fatura, contas);

        assertEquals(Fatura.StatusPagamento.PAGA, fatura.getStatus());
    }

    @Test
    public void testValorTipico() {
        Fatura fatura = new Fatura("20/02/2023", 1500.00, "Cliente C");
        List<Conta> contas = Arrays.asList(
                new Conta("1", "20/02/2023", 500.00, TipoPagamentoEnum.BOLETO),
                new Conta("2", "20/02/2023", 400.00, TipoPagamentoEnum.BOLETO),
                new Conta("3", "20/02/2023", 600.00, TipoPagamentoEnum.BOLETO)
        );

        ProcessadorDeContasController processador = new ProcessadorDeContasController();
        processador.processarPagamento(fatura, contas);

        assertEquals(Fatura.StatusPagamento.PAGA, fatura.getStatus());
    }

    @Test
    public void testValorMaximo() {
        Fatura fatura = new Fatura("19/02/2023", 10000.00, "Cliente D");
        List<Conta> contas = Arrays.asList(
                new Conta("1", "19/02/2023", 5000.00, TipoPagamentoEnum.BOLETO),
                new Conta("2", "19/02/2023", 5000.00, TipoPagamentoEnum.BOLETO)
        );

        ProcessadorDeContasController processador = new ProcessadorDeContasController();
        processador.processarPagamento(fatura, contas);

        assertEquals(Fatura.StatusPagamento.PAGA, fatura.getStatus());
    }

    @Test
    public void testValorLogoAbaixoDoMaximo() {
        Fatura fatura = new Fatura("19/02/2023", 9999.99, "Cliente E");
        List<Conta> contas = Arrays.asList(
                new Conta("1", "19/02/2023", 5000.00, TipoPagamentoEnum.BOLETO),
                new Conta("2", "19/02/2023", 4999.99, TipoPagamentoEnum.BOLETO)
        );

        ProcessadorDeContasController processador = new ProcessadorDeContasController();
        processador.processarPagamento(fatura, contas);

        assertEquals(Fatura.StatusPagamento.PAGA, fatura.getStatus());
    }
}