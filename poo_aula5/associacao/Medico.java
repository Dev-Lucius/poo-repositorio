package associacao;

/**
 * Representa um Médico no contexto de Associação.
 *
 * CONCEITO — ASSOCIAÇÃO:
 * O Médico existe de forma completamente independente.
 * Ele não precisa de um Paciente ou de uma Consulta para existir.
 * A relação só é estabelecida quando uma Consulta é criada.
 */
public class Medico {

    // Nome do médico — imutável após a criação
    private final String nome;

    /**
     * Construtor do Médico.
     *
     * @param nome Nome do médico. Não pode ser nulo ou vazio.
     * @throws IllegalArgumentException se o nome for inválido.
     */
    public Medico(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do médico inválido: não pode ser nulo ou vazio.");
        }
        this.nome = nome.trim();
    }

    /**
     * Getter do nome.
     *
     * CONCEITO — GETTER:
     * Permite acesso controlado ao atributo privado,
     * preservando o encapsulamento.
     *
     * @return o nome do médico.
     */
    public String getNome() {
        return nome;
    }

    /**
     * CONCEITO — @Override toString():
     * Define como o objeto é representado como texto.
     * Chamado automaticamente em System.out.println().
     */
    @Override
    public String toString() {
        return "Dr(a). " + nome;
    }
}