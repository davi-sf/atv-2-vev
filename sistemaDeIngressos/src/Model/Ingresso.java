package Model;

import Enum.TipoIngresso;

public class Ingresso {
    
    private String idIngresso;
    private TipoIngresso tipoIngresso;
    private boolean status;
    private float valor;
    
    
        public Ingresso(String idIngresso, TipoIngresso tipoIngresso, boolean status, float valor) {
            this.idIngresso = idIngresso;
            this.status = status;
            this.tipoIngresso = tipoIngresso;
            this.valor = valor;
    }

    public boolean getStatus() {
        return status;
    }

    public TipoIngresso getTipo() {
        return tipoIngresso;
    }

    
    public String getId() {
        return idIngresso;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public float getValor() {
       return this.valor;
    }

}
