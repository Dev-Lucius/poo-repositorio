package associacao;

/**
 * Representa um Paciente no contexto de Associação.
 *
 * CONCEITO — ASSOCIAÇÃO:
 * O Paciente existe de forma completamente independente.
 * Ele não precisa de um Médico ou de uma Consulta para existir.
 * A relação só é estabelecida quando uma Consulta é criada.
 */
public class Paciente {

    // Nome do paciente — imutável após a criação
    private final String nome;

    /**
     * Construtor do Paciente.
     *
     * @param nome Nome do paciente. Não pode ser nulo ou vazio.
     * @throws IllegalArgumentException se o nome for inválido.
     */
    public Paciente(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do paciente inválido: não pode ser nulo ou vazio.");
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
     * @return o nome do paciente.
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
        return "Paciente: " + nome;
    }
}