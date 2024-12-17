package model;

public class Pagamento {

    private double valorPago;
    private String dataPagamento;
    private TipoPagamentoEnum tipoPagamentoEnum;



    public Pagamento(double valorPago, String dataPagamento, TipoPagamentoEnum tipoPagamentoEnum) {
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.tipoPagamentoEnum = tipoPagamentoEnum;
    }

    public double calcularValorPagoComAjustes(Fatura fatura, Conta conta) {
        if (this.tipoPagamentoEnum == TipoPagamentoEnum.BOLETO) {

            if (isPagamentoComAtraso(conta)) {
                return valorPago * 1.10;
            }

            if(valorPago < 0.01){
                System.out.println("pagamentos por boleto devem ter valores superiores a 0.001");
            }

            if(valorPago > 5000){
                System.out.println("pagamento por boletos devem ter valores inferiores a 5000");
            }
        }
        return valorPago;
    }

    private boolean isPagamentoComAtraso(Conta conta) {

        return this.dataPagamento.compareTo(conta.getData()) > 0;
    }

    public double getValorPago() {
        return valorPago;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public TipoPagamentoEnum getTipoPagamento() {
        return tipoPagamentoEnum;
    }
}
