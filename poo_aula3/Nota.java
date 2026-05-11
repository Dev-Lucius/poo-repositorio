// PUBLIC --> Vísivel para Outras Classes
// Então elas conseguem Importar e Instanciar
public class Nota {

    // Atributo Privado --> Visível apenas dentro da própria classe Nota
    private float valor;

    // final --> Constante / Inalterável
    // String --> Tipo de Dado / Texto
    // public --> publicamente visível para outras classes / outras classes podem enxergar o atributo da instância
    public static final String descricao = "CLASSE VALUE OBJECT QUE DEFINE VALORES POSSIVEIS PARA A NOTA";

    // Exemplo de Setter
    public void setValor(float valor){
        if(valor < 0) {
            valor = 0;
            return;
        } else if(valor > 10){
            valor = 10;
            return; 
        }
        this.valor = valor;

        // this.valor = valor > 10 ? 10 : valor < 0 ? 0 : valor;

        
    }

    // Exemplo de Setter
    public float getValor(){
        return this.valor;
    }
}
