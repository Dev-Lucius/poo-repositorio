package ObjectValue;

public class Pessoa {
    
    private Nome nome;

    // PESSOAS SÓ EXISTEM COM NOME
    // ENTAO ESSE ATRIBUTO DEVE SER OBRIGATORIO NO CONSTRUTOR
    public Pessoa(String nome) {
        this.nome = new Nome(nome);
    }

    public String getNome() {
        return this.nome.getValue();
    }

}