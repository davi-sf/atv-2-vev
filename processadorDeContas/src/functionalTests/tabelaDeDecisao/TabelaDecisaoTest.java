package functionalTests.tabelaDeDecisao;

import controller.ProcessadorDeContasController;
import model.Conta;
import model.Fatura;
import model.TipoPagamentoEnum;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TabelaDecisaoTest {

    @Test
    public void testCaso1() {
        Fatura fatura = new Fatura("20/02/2023", 1500.00, "Cliente A");
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
    public void testCaso2() {
        Fatura fatura = new Fatura("20/02/2023", 1500.00, "Cliente B");
        List<Conta> contas = Arrays.asList(
                new Conta("1", "05/02/2023", 700.00, TipoPagamentoEnum.CARTAO_CREDITO),
                new Conta("2", "17/02/2023", 800.00, TipoPagamentoEnum.TRANSFERENCIA_BANCARIA)
        );

        ProcessadorDeContasController processador = new ProcessadorDeContasController();
        processador.processarPagamento(fatura, contas);

        assertEquals(Fatura.StatusPagamento.PAGA, fatura.getStatus());
    }

    @Test
    public void testCaso3() {
        Fatura fatura = new Fatura("20/02/2023", 1500.00, "Cliente C");
        List<Conta> contas = Arrays.asList(
                new Conta("1", "06/02/2023", 700.00, TipoPagamentoEnum.CARTAO_CREDITO),
                new Conta("2", "17/02/2023", 800.00, TipoPagamentoEnum.TRANSFERENCIA_BANCARIA)
        );

        ProcessadorDeContasController processador = new ProcessadorDeContasController();
        processador.processarPagamento(fatura, contas);

        assertEquals(Fatura.StatusPagamento.PENDENTE, fatura.getStatus());
    }

    @Test
    public void testCaso4() {
        Fatura fatura = new Fatura("20/02/2023", 2000.00, "Cliente D");
        List<Conta> contas = Arrays.asList(
                new Conta("1", "10/02/2023", 1000.00, TipoPagamentoEnum.CARTAO_CREDITO),
                new Conta("2", "20/02/2023", 1000.00, TipoPagamentoEnum.BOLETO)
        );

        ProcessadorDeContasController processador = new ProcessadorDeContasController();
        processador.processarPagamento(fatura, contas);

        assertEquals(Fatura.StatusPagamento.PENDENTE, fatura.getStatus());
    }

    @Test
    public void testCaso5() {
        Fatura fatura = new Fatura("20/02/2023", 1100.00, "Cliente E");
        List<Conta> contas = Arrays.asList(
                new Conta("1", "21/02/2023", 1000.00, TipoPagamentoEnum.BOLETO)
        );

        ProcessadorDeContasController processador = new ProcessadorDeContasController();
        processador.processarPagamento(fatura, contas);

        assertEquals(Fatura.StatusPagamento.PAGA, fatura.getStatus());
    }
}