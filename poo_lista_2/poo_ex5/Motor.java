package poo_ex5;

public class Motor {
    // Declarando os Atributos
    private String tipo;
    private int potencia;
    private int cilindradas;

    public void setTipo(String tipo){
        if(tipo == null || tipo.trim().isEmpty()){
            throw new IllegalArgumentException("Dado Inválido");
        } else {
            this.tipo = tipo;
        }
    }

    public void setPotencia(int potencia){
        if(potencia <= 0){
            throw new IllegalArgumentException("Dado Inválido");
        } else {
            this.potencia = potencia;
        }
    }

    public void setCilindradas(int cilindradas){
        if(cilindradas <= 0){
            throw new IllegalArgumentException("Dado Inválido");
        } else {
            this.cilindradas = cilindradas;
        }
    }

    // Construtor
    // -> É executado automaticamente quando criamos um objeto
    // -> Ele serve para inicializar os atributos da classe
    public Motor(String tipo, int potencia, int cilindradas){
        // Usando this refere-se ao objeto atual da classe
        // Sua função é diferenciar o atributo da classe do parâmetro recebido
        this.tipo = tipo;
        this.potencia = potencia;
        this.cilindradas = cilindradas;
    }

    // Método exibirDados()
    // É o responsável por mostrar os dados do montor no console
    // Métodos -> Expressa um comportamento do Objeto!!
    public void exibirDados(){
        System.out.println("Tipo do Motor:" + tipo);
        System.out.println("Potência" + potencia);
        System.out.println("Cilindradas" + cilindradas);
    }
}
