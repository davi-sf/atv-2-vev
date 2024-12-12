package model;

public class Fatura {

    private String data;
    private double valorTotal;
    private String nomeCliente;

    public Fatura(String data, double valorTotal, String nome) {
        this.data = data;
        this.valorTotal = valorTotal;
        this.nomeCliente = nome;
    }

    public String getData() {
        return data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }
}
