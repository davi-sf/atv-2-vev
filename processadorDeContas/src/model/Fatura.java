package model;

public class Fatura {
    private String data;
    private double valorTotal;
    private String nomeCliente;
    private StatusPagamento status;

    public enum StatusPagamento {
        PENDENTE,
        PAGA
    }

    public Fatura(String data, double valorTotal, String nomeCliente) {
        this.data = data;
        this.valorTotal = valorTotal;
        this.nomeCliente = nomeCliente;
        this.status = StatusPagamento.PENDENTE; // Inicialmente a fatura é PENDENTE
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public StatusPagamento getStatus() {
        return status;
    }

    public void setStatus(StatusPagamento status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }
}
