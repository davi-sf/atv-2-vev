package Model;

public class Show {

    private boolean dataEspecial;
    private Lote[] lotes;
    private float despesas;
    private String artista;
    private String data;
    private float cache;
                                        
    public Show(String data, String artista, float cache, float despesas, Lote[] lotes, boolean dataEspecial) {
        this.data = data;
        this.artista = artista;
        this.cache = cache;
        this.despesas = despesas;
        this.lotes = lotes; 
        this.dataEspecial = dataEspecial;
    }

    public String getRelatorio() {
        int qtdVip = 0, qtdNormal = 0, qtdMeiaEntrada = 0;
        float receita = 0;
        for (Lote lote : lotes) {
            for (Ingresso ingresso : lote.getIngressos())
            switch (ingresso.getTipo()) {
                case VIP:
                    if(ingresso.getStatus()){
                        qtdVip += 1;
                        receita += ingresso.getValor()*(1-(lote.getDesconto()/100));
                        break;
                    }
                case NORMAL:
                    if(ingresso.getStatus()){
                        qtdNormal += 1;
                        receita += ingresso.getValor()*(1-(lote.getDesconto()/100));
                        break;
                    }
                case MEIA_ENTRADA:
                    if(ingresso.getStatus()){
                        qtdMeiaEntrada += 1;
                        receita += ingresso.getValor()*(1-(lote.getDesconto()/100));
                        break;
                    }
            }
        }

        if (dataEspecial) {
            receita *= 1.15;
        }
    
        receita = receita - (despesas + cache);
        String status = "PREJUIZO";
        if(receita>0){
            status = "LUCRO";
        }
        if(receita==0){
            status = "ESTAVEL";
        }
        return String.format("VIP: %d; NORMAL: %d; MEIA_ENTRADA: %d; Receita: %.2f; Status: %s", qtdVip, qtdNormal, qtdMeiaEntrada, receita, status);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getArtista() {
        return artista;
    }
}
