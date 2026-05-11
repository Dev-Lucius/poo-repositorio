package poo_ex5;

// ItemPedido é uma classe que representa um item específico de um pedido
// na medida em que contêm informações sobre o nome do item, seu valor e a quantidade solicitada.
public class ItemPedido {

    // Construtor
    // Trata-se de uma forma de iniciar o objeto
    // passando parâmetros indicando COMO EU GOSTARIA QUE ELE FOSSE INICIADO
    
    // Ele possui 3 atributos privados: nome, valor e quantidade. 
    // O construtor recebe esses valores como parâmetros e os atribui aos atributos correspondentes da classe.
    /* 
        | Atributo     | Significado         |
        | ------------ | ------------------- |
        | `nome`       | nome do produto     |
        | `valor`      | preço unitário      |
        | `quantidade` | quantidade comprada |
    */
    private String nome;
    private double valor;
    private int quantidade;

    // Verificando se os parâmetros são válidos antes de atribuí-los aos atributos.
     // IllegalArgumentException é uma exceção do Java que indica que um argumento passado para um método é inválido.
    public ItemPedido(String nome, double valor, int quantidade) {
        if (nome == null) {
            throw new IllegalArgumentException("nome não pode ser vazio");
        }
        // Se o valor for negativo ou igual à zero, lança uma exceção indicando que o preço unitário deve ser maior que zero.
        if (valor <= 0) {
            throw new IllegalArgumentException("precoUnitario deve ser > 0");
        }
        // Se a quantidade for menor do que 1, lança uma exceção indicando que a quantidade deve ser maior ou igual a 1.
        if (quantidade < 1) {
            throw new IllegalArgumentException("quantidade deve ser >= 1");
        }

        // Pense nisso como um método que estrutura um novo objeto !
        // this remete a própria Instância
        // this.nome -> Atributo
        // nome -> apenas o parâmetro
        /* 
            | Palavra     | Significado             |
            | ----------- | ----------------------- |
            | `nome`      | parâmetro do construtor |
            | `this.nome` | atributo do objeto      |

            - Parâmetro recebido: nome = "Café"
            - Atributo do objeto: this.nome
            - Então ... this.nome = nome; -> this.nome = "Café";
        */
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    // Criação do Método subtotal()
    // Tal método é o responsável por calcular o valor total do item
    public double subtotal() {
        return Math.floor(valor * quantidade);
    }

    // Getters são métodos que permitem acessar os valores dos atributos privados de uma classe.
    // Ex..
    // public String getNome()
    // public double getValor()
    // public int getQuantidade()

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
