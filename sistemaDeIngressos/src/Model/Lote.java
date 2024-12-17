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

    public void setDesconto(float desconto) {
        if(desconto <= 25) {
        this.desconto = desconto;
        }
    }
}
