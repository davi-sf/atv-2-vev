package Model;

public class Lote {

    private String idLote;
    private Ingresso[] ingressos;
    private float desconto;


    public Lote(String idLote, Ingresso[] ingressos, float desconto) {
        this.idLote = idLote;
        this.desconto = desconto;
        this.ingressos = ingressos;
    }

    public float getDesconto() {
        return desconto;
    }

    public Ingresso[] getIngressos() {
        return ingressos;
    }

    
    public String getId() {
        return idLote;
    }

    public boolean setDesconto(float desconto) {
        if(desconto <= 25) {
        this.desconto = desconto;
        return true;
        }
        return false;
    }

    public Ingresso[] getIngressosVip() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIngressosVip'");
    }

    public Ingresso[] getIngressosNormal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIngressosNormal'");
    }

    public Ingresso[] getIngressosMeia() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIngressosMeia'");
    }

    public Object isQtdIngressosValidos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isQtdIngressosValidos'");
    }
}
