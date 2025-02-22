package functionalTests.avl;

import controller.ProcessadorDeContasController;
import model.Conta;
import model.Fatura;
import model.TipoPagamentoEnum;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestePiorCasoRobustoTest {

    @Test
    public void testPiorCasoRobusto1() {
        Fatura fatura = new Fatura("20/02/2023", -0.01, "Cliente M");
        List<Conta> contas = Arrays.asList(
                new Conta("1", "20/02/2023", 0.01, TipoPagamentoEnum.BOLETO)
        );

        ProcessadorDeContasController processador = new ProcessadorDeContasController();
        processador.processarPagamento(fatura, contas);

        assertEquals(Fatura.StatusPagamento.PENDENTE, fatura.getStatus());
    }

    @Test
    public void testPiorCasoRobusto2() {
        Fatura fatura = new Fatura("19/02/2023", 10000.01, "Cliente N");
        List<Conta> contas = Arrays.asList(
                new Conta("1", "19/02/2023", 5000.00, TipoPagamentoEnum.BOLETO),
                new Conta("2", "19/02/2023", 5000.01, TipoPagamentoEnum.BOLETO)
        );

        ProcessadorDeContasController processador = new ProcessadorDeContasController();
        processador.processarPagamento(fatura, contas);

        assertEquals(Fatura.StatusPagamento.PENDENTE, fatura.getStatus());
    }

    @Test
    public void testPiorCasoRobusto3() {
        Fatura fatura = new Fatura("20/02/2023", 1500.00, "Cliente O");
        List<Conta> contas = Arrays.asList(
                new Conta("1", "20/02/2023", 0.00, TipoPagamentoEnum.BOLETO)
        );

        ProcessadorDeContasController processador = new ProcessadorDeContasController();
        processador.processarPagamento(fatura, contas);

        assertEquals(Fatura.StatusPagamento.PENDENTE, fatura.getStatus());
    }

    @Test
    public void testPiorCasoRobusto4() {
        Fatura fatura = new Fatura("20/02/2023", 1500.00, "Cliente P");
        List<Conta> contas = Arrays.asList(
                new Conta("1", "20/02/2023", 5000.01, TipoPagamentoEnum.BOLETO)
        );

        ProcessadorDeContasController processador = new ProcessadorDeContasController();
        processador.processarPagamento(fatura, contas);

        assertEquals(Fatura.StatusPagamento.PENDENTE, fatura.getStatus());
    }

    @Test
    public void testPiorCasoRobusto5() {
        Fatura fatura = new Fatura("20/02/2023", 2000.00, "Cliente Q");
        List<Conta> contas = Arrays.asList(
                new Conta("1", "10/02/2023", 1000.00, TipoPagamentoEnum.CARTAO_CREDITO),
                new Conta("2", "20/02/2023", 1000.00, TipoPagamentoEnum.BOLETO)
        );

        ProcessadorDeContasController processador = new ProcessadorDeContasController();
        processador.processarPagamento(fatura, contas);

        assertEquals(Fatura.StatusPagamento.PENDENTE, fatura.getStatus());
    }
}