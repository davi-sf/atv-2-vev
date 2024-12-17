package model;

public class Conta {

    private String codigoDaConta;
    private String data;
    private double valorPago;
    private TipoPagamentoEnum tipoPagamentoEnum;


    public Conta(String codigoDaConta, String data, double valorPago, TipoPagamentoEnum tipoPagamentoEnum) {
        this.codigoDaConta = codigoDaConta;
        this.data = data;
        this.valorPago = valorPago;
        this.tipoPagamentoEnum = tipoPagamentoEnum;
    }

    public String getCodigoDaConta() {
        return codigoDaConta;
    }

    public void setCodigoDaConta(String codigoDaConta) {
        this.codigoDaConta = codigoDaConta;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public TipoPagamentoEnum getTipoPagamento() {
        return tipoPagamentoEnum;
    }
    public void setTipoPagamento(TipoPagamentoEnum tipoPagamentoEnum) {
        this.tipoPagamentoEnum = tipoPagamentoEnum;
    }

}
