package functionalTests.avl;

import controller.ProcessadorDeContasController;
import model.Conta;
import model.Fatura;
import model.TipoPagamentoEnum;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestePiorCasoTest {

    @Test
    public void testPiorCaso1() {
        Fatura fatura = new Fatura("20/02/2023", 1500.00, "Cliente H");
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
    public void testPiorCaso2() {
        Fatura fatura = new Fatura("20/02/2023", 1500.00, "Cliente I");
        List<Conta> contas = Arrays.asList(
                new Conta("1", "06/02/2023", 700.00, TipoPagamentoEnum.CARTAO_CREDITO),
                new Conta("2", "17/02/2023", 800.00, TipoPagamentoEnum.TRANSFERENCIA_BANCARIA)
        );

        ProcessadorDeContasController processador = new ProcessadorDeContasController();
        processador.processarPagamento(fatura, contas);

        assertEquals(Fatura.StatusPagamento.PENDENTE, fatura.getStatus());
    }

    @Test
    public void testPiorCaso3() {
        Fatura fatura = new Fatura("19/02/2023", 10000.00, "Cliente J");
        List<Conta> contas = Arrays.asList(
                new Conta("1", "19/02/2023", 5000.00, TipoPagamentoEnum.BOLETO),
                new Conta("2", "19/02/2023", 5000.00, TipoPagamentoEnum.BOLETO)
        );

        ProcessadorDeContasController processador = new ProcessadorDeContasController();
        processador.processarPagamento(fatura, contas);

        assertEquals(Fatura.StatusPagamento.PAGA, fatura.getStatus());
    }

    @Test
    public void testPiorCaso4() {
        Fatura fatura = new Fatura("19/02/2023", 10000.00, "Cliente K");
        List<Conta> contas = Arrays.asList(
                new Conta("1", "19/02/2023", 5000.00, TipoPagamentoEnum.BOLETO),
                new Conta("2", "19/02/2023", 4999.99, TipoPagamentoEnum.BOLETO)
        );

        ProcessadorDeContasController processador = new ProcessadorDeContasController();
        processador.processarPagamento(fatura, contas);

        assertEquals(Fatura.StatusPagamento.PENDENTE, fatura.getStatus());
    }

    @Test
    public void testPiorCaso5() {
        Fatura fatura = new Fatura("20/02/2023", 1500.00, "Cliente L");
        List<Conta> contas = Arrays.asList(
                new Conta("1", "20/02/2023", 1500.00, TipoPagamentoEnum.TRANSFERENCIA_BANCARIA)
        );

        ProcessadorDeContasController processador = new ProcessadorDeContasController();
        processador.processarPagamento(fatura, contas);

        assertEquals(Fatura.StatusPagamento.PAGA, fatura.getStatus());
    }
}