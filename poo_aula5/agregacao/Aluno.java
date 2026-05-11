package agregacao;

/**
 * Representa um Aluno dentro do contexto de Agregação.
 *
 * CONCEITO — AGREGAÇÃO:
 * Um Aluno pode pertencer a uma Turma, mas ele existe de forma
 * independente. Se a Turma for removida, o Aluno continua existindo.
 *
 * CONCEITO — ENCAPSULAMENTO:
 * O atributo "nome" é privado (private), ou seja, só pode ser
 * acessado ou modificado através dos métodos públicos desta classe.
 * Isso protege os dados de alterações indevidas.
 */

public class Aluno{

     // Atributo privado — só acessível dentro desta classe
    // "final" garante que o nome não pode ser alterado após a criação do objeto (imutabilidade)
    private final String nome;


    /**
     * Construtor da classe Aluno.
     *
     * CONCEITO — CONSTRUTOR:
     * É o método especial chamado automaticamente quando usamos "new Aluno(...)".
     * Ele é responsável por inicializar os atributos do objeto com valores válidos.
     *
     * CONCEITO — VALIDAÇÃO NO CONSTRUTOR:
     * Validar os dados na entrada garante que nunca existirá um objeto
     * em estado inválido. Isso é chamado de "invariante de classe".
     *
     * @param nome Nome do aluno. Não pode ser nulo ou vazio.
     * @throws IllegalArgumentException se o nome for inválido.
     */
    public Aluno(String nome){
        // Validação: garante que o objeto só é criado com dados válidos
        // null         → a variável não aponta para nenhum objeto
        // trim()       → remove espaços em branco nas extremidades da String
        // isEmpty()    → verifica se a String resultante está vazia
        if(nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("Nome Inválido");
        } else {
            // "this.nome" refere-se ao atributo da classe
            // "nome" refere-se ao parâmetro recebido no construtor
            this.nome = nome;
        }
    }

    /**
     * Getter do atributo nome.
     *
     * CONCEITO — GETTER:
     * Método público que permite ler o valor de um atributo privado
     * de fora da classe, sem expor o atributo diretamente.
     * Convenção de nomenclatura em Java: get + NomeDoAtributo.
     *
     * @return o nome do aluno.
     */
    public String getNomeAluno() {
        return nome;
    }


    /**
     * Sobrescrita do método toString().
     *
     * CONCEITO — @Override:
     * Todo objeto Java herda o método toString() da classe Object.
     * Ao sobrescrevê-lo com @Override, definimos como este objeto
     * deve ser representado como texto — útil em System.out.println()
     * e para facilitar a leitura durante depuração (debug).
     *
     * @return representação textual do Aluno.
     */
    @Override
    public String toString(){
        return "Aluno: " + nome;
    }
}