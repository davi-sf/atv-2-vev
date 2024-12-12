package model;

public class Conta {

    private String codigoDaConta;
    private String data;
    private double valorPago;


    public Conta(String codigoDaConta, String data, double valorPago) {
        this.codigoDaConta = codigoDaConta;
        this.data = data;
        this.valorPago = valorPago;
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

}
