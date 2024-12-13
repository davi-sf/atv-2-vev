package model;

import java.util.List;

public class ProcessadorDeContas {

    public void processarPagamento(Fatura fatura, List<Conta> contas) {
        double totalPago = 0.00;


        for (Conta conta : contas) {

            Pagamento pagamento = new Pagamento(conta.getValorPago(), conta.getData(), conta.getTipoPagamento());


            totalPago += pagamento.calcularValorPagoComAjustes(fatura, conta);
        }

        if (totalPago >= fatura.getValorTotal()) {
            fatura.setStatus(Fatura.StatusPagamento.PAGA);
        } else {
            fatura.setStatus(Fatura.StatusPagamento.PENDENTE);
        }
    }

}
