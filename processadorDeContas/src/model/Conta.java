package model;
import Enum.TipoPagamento;

public class Conta {

    private String codigoDaConta;
    private String data;
    private double valorPago;
    private TipoPagamento tipoPagamento;


    public Conta(String codigoDaConta, String data, double valorPago, TipoPagamento tipoPagamento) {
        this.codigoDaConta = codigoDaConta;
        this.data = data;
        this.valorPago = valorPago;
        this.tipoPagamento = tipoPagamento;
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

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }
    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

}
