package exemplo1;

public class RelatorioFinanceiro {
    
    private String setor;
    private String data;
    private float valor;

    public RelatorioFinanceiro(String setor, String data, float valor) {
        this.setor = setor;
        this.data = data;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "RelatorioFinanceiro [setor=" + setor + ", data=" + data + ", valor=" + valor + "]";
    }

    

}
