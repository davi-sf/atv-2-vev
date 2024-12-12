package model;

public class Pagamento {

    private double valorPago;
    private String dataPagamento;
    private String tipoPagamento;

    public Pagamento(double valorPago, String dataPagamento, String tipoPagamento) {
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.tipoPagamento = tipoPagamento;

    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
}
