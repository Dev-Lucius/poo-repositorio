package agregacao;

/**
 * Representa um Professor dentro do contexto de Associação e Agregação.
 *
 * CONCEITO — ASSOCIAÇÃO:
 * O Professor pode ser associado a uma Turma, mas existe de forma
 * completamente independente. Um Professor pode existir sem nenhuma
 * Turma, e pode ser associado a várias Turmas ao longo do tempo.
 *
 * CONCEITO — ENCAPSULAMENTO:
 * O atributo "nome" é privado (private), protegendo o dado de
 * acessos ou modificações diretas fora desta classe.
 */
public class Professor {

    // Atributo privado e imutável — o nome do professor não muda após a criação
    // "final" reforça a imutabilidade: uma vez atribuído, não pode ser reatribuído
    private final String nome;

    /**
     * Construtor da classe Professor.
     *
     * CONCEITO — CONSTRUTOR:
     * Método especial invocado automaticamente ao usar "new Professor(...)".
     * Responsável por inicializar os atributos com valores válidos.
     *
     * CONCEITO — VALIDAÇÃO NO CONSTRUTOR:
     * Assim como em Aluno, validar os dados na entrada garante que
     * nenhum objeto Professor seja criado em estado inválido.
     * Isso é chamado de "invariante de classe".
     *
     * @param nome Nome do professor. Não pode ser nulo ou vazio.
     * @throws IllegalArgumentException se o nome for inválido.
     */
    public Professor(String nome) {
        // Validação: impede a criação de um Professor sem nome válido
        // null         → referência que não aponta para nenhum objeto
        // trim()       → remove espaços em branco nas extremidades
        // isEmpty()    → verifica se a String resultante está vazia
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido: não pode ser nulo ou vazio.");
        }

        // "this.nome" → atributo da classe | "nome" → parâmetro do construtor
        this.nome = nome;
    }

    /**
     * Getter do atributo nome.
     *
     * CONCEITO — GETTER:
     * Permite que outras classes leiam o valor de um atributo privado
     * sem acessá-lo diretamente, preservando o encapsulamento.
     * Convenção em Java: get + NomeDoAtributo.
     *
     * @return o nome do professor.
     */
    public String getNomeProfessor() {
        return nome;
    }

    /**
     * Sobrescrita do método toString().
     *
     * CONCEITO — @Override:
     * Redefine o método toString() herdado da classe Object, que é
     * chamado automaticamente em System.out.println() e concatenações.
     * Sem essa sobrescrita, seria impresso algo como "agregacao.Professor@6d06d69c"
     * (endereço de memória), o que não é nada útil para leitura humana.
     *
     * @return representação textual do Professor.
     */
    @Override
    public String toString() {
        return "Prof. " + nome;
    }
}