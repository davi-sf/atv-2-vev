package functionalTests.particaoEquivalencia;
import model.Conta;
import model.Fatura;
import model.TipoPagamentoEnum;
import org.junit.jupiter.api.Test;
import controller.ProcessadorDeContasController;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParticoesEquivalenciaTest {

    @Test
    public void testParticaoValidaBoleto() {
        Fatura fatura = new Fatura("20/02/2023", 1000.00, "Cliente R");
        List<Conta> contas = Arrays.asList(
                new Conta("1", "20/02/2023", 500.00, TipoPagamentoEnum.BOLETO),
                new Conta("2", "20/02/2023", 500.00, TipoPagamentoEnum.BOLETO)
        );

        ProcessadorDeContasController processador = new ProcessadorDeContasController();
        processador.processarPagamento(fatura, contas);

        assertEquals(Fatura.StatusPagamento.PAGA, fatura.getStatus());
    }

    @Test
    public void testParticaoInvalidaBoletoAbaixoDoMinimo() {
        Fatura fatura = new Fatura("20/02/2023", 1500.00, "Cliente S");
        List<Conta> contas = Arrays.asList(
                new Conta("1", "20/02/2023", 0.00, TipoPagamentoEnum.BOLETO)
        );

        ProcessadorDeContasController processador = new ProcessadorDeContasController();
        processador.processarPagamento(fatura, contas);

        assertEquals(Fatura.StatusPagamento.PENDENTE, fatura.getStatus());
    }

    @Test
    public void testParticaoInvalidaBoletoAcimaDoMaximo() {
        Fatura fatura = new Fatura("19/02/2023", 1500.00, "Cliente T");
        List<Conta> contas = Arrays.asList(
                new Conta("1", "19/02/2023", 5001.00, TipoPagamentoEnum.BOLETO)
        );

        ProcessadorDeContasController processador = new ProcessadorDeContasController();
        processador.processarPagamento(fatura, contas);

        assertEquals(Fatura.StatusPagamento.PENDENTE, fatura.getStatus());
    }

    @Test
    public void testParticaoValidaCartaoCredito() {
        Fatura fatura = new Fatura("20/02/2023", 1500.00, "Cliente U");
        List<Conta> contas = Arrays.asList(
                new Conta("1", "05/02/2023", 700.00, TipoPagamentoEnum.CARTAO_CREDITO),
                new Conta("2", "17/02/2023", 800.00, TipoPagamentoEnum.TRANSFERENCIA_BANCARIA)
        );

        ProcessadorDeContasController processador = new ProcessadorDeContasController();
        processador.processarPagamento(fatura, contas);

        assertEquals(Fatura.StatusPagamento.PAGA, fatura.getStatus());
    }

    @Test
    public void testParticaoInvalidaCartaoCreditoForaDoPrazo() {
        Fatura fatura = new Fatura("20/02/2023", 1500.00, "Cliente V");
        List<Conta> contas = Arrays.asList(
                new Conta("1", "06/02/2023", 700.00, TipoPagamentoEnum.CARTAO_CREDITO),
                new Conta("2", "17/02/2023", 800.00, TipoPagamentoEnum.TRANSFERENCIA_BANCARIA)
        );

        ProcessadorDeContasController processador = new ProcessadorDeContasController();
        processador.processarPagamento(fatura, contas);

        assertEquals(Fatura.StatusPagamento.PENDENTE, fatura.getStatus());
    }

    @Test
    public void testParticaoValidaTransferenciaBancaria() {
        Fatura fatura = new Fatura("20/02/2023", 1500.00, "Cliente W");
        List<Conta> contas = Arrays.asList(
                new Conta("1", "20/02/2023", 1500.00, TipoPagamentoEnum.TRANSFERENCIA_BANCARIA)
        );

        ProcessadorDeContasController processador = new ProcessadorDeContasController();
        processador.processarPagamento(fatura, contas);

        assertEquals(Fatura.StatusPagamento.PAGA, fatura.getStatus());
    }

    @Test
    public void testParticaoInvalidaTransferenciaBancariaForaDoPrazo() {
        Fatura fatura = new Fatura("20/02/2023", 1500.00, "Cliente X");
        List<Conta> contas = Arrays.asList(
                new Conta("1", "21/02/2023", 1500.00, TipoPagamentoEnum.TRANSFERENCIA_BANCARIA)
        );

        ProcessadorDeContasController processador = new ProcessadorDeContasController();
        processador.processarPagamento(fatura, contas);

        assertEquals(Fatura.StatusPagamento.PENDENTE, fatura.getStatus());
    }

    @Test
    public void testParticaoValidaSomaPagamentosIgual() {
        Fatura fatura = new Fatura("20/02/2023", 1500.00, "Cliente Y");
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
    public void testParticaoInvalidaSomaPagamentosMenor() {
        Fatura fatura = new Fatura("20/02/2023", 1500.00, "Cliente Z");
        List<Conta> contas = Arrays.asList(
                new Conta("1", "20/02/2023", 700.00, TipoPagamentoEnum.BOLETO),
                new Conta("2", "20/02/2023", 600.00, TipoPagamentoEnum.BOLETO)
        );

        ProcessadorDeContasController processador = new ProcessadorDeContasController();
        processador.processarPagamento(fatura, contas);

        assertEquals(Fatura.StatusPagamento.PENDENTE, fatura.getStatus());
    }
}