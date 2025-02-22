package functionalTests.avl;

import controller.ProcessadorDeContasController;
import model.Conta;
import model.Fatura;
import model.TipoPagamentoEnum;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesteRobustezTest {

    @Test
    public void testValorMinimoInvalido() {
        Fatura fatura = new Fatura("20/02/2023", -0.01, "Cliente F");
        List<Conta> contas = Arrays.asList(
                new Conta("1", "20/02/2023", 0.01, TipoPagamentoEnum.BOLETO)
        );

        ProcessadorDeContasController processador = new ProcessadorDeContasController();
        processador.processarPagamento(fatura, contas);

        assertEquals(Fatura.StatusPagamento.PENDENTE, fatura.getStatus());
    }

    @Test
    public void testValorMaximoInvalido() {
        Fatura fatura = new Fatura("19/02/2023", 10000.01, "Cliente G");
        List<Conta> contas = Arrays.asList(
                new Conta("1", "19/02/2023", 5000.00, TipoPagamentoEnum.BOLETO),
                new Conta("2", "19/02/2023", 5000.01, TipoPagamentoEnum.BOLETO)
        );

        ProcessadorDeContasController processador = new ProcessadorDeContasController();
        processador.processarPagamento(fatura, contas);

        assertEquals(Fatura.StatusPagamento.PENDENTE, fatura.getStatus());
    }
}