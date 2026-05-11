package agregacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Representa uma Turma, que agrega Alunos e se associa a um Professor.
 *
 * CONCEITO — AGREGAÇÃO (Turma x Alunos):
 * A Turma "agrega" objetos do tipo Aluno. Os alunos existem de forma
 * independente da Turma: se a Turma for removida, os objetos Aluno
 * continuam existindo na memória. A Turma apenas os referencia.
 *
 * CONCEITO — ASSOCIAÇÃO (Turma x Professor):
 * O Professor é associado à Turma, mas ambos existem de forma
 * independente. Um Professor pode existir sem Turma, e a Turma
 * pode existir sem Professor (professor = null inicialmente).
 *
 * CONCEITO — ENCAPSULAMENTO:
 * Todos os atributos são privados. O acesso e a modificação ocorrem
 * exclusivamente por meio de métodos públicos (getters e métodos de ação),
 * protegendo o estado interno do objeto.
 */
public class Turma {

    // Nome da turma — imutável após a criação (final)
    private final String nome;

    // Lista que agrega os alunos pertencentes a esta turma
    // Inicializada no construtor como ArrayList (implementação dinâmica de List)
    private final List<Aluno> alunos;

    // Professor associado à turma — pode ser nulo se ainda não houver associação
    private Professor professor;

    /**
     * Construtor da classe Turma.
     *
     * CONCEITO — INICIALIZAÇÃO DE COLEÇÕES NO CONSTRUTOR:
     * A lista de alunos é criada aqui com "new ArrayList<>()", garantindo
     * que o objeto Turma nunca tenha sua lista como null — evitando
     * NullPointerException ao tentar adicionar alunos depois.
     *
     * @param nome Nome da turma. Não pode ser nulo ou vazio.
     * @throws IllegalArgumentException se o nome for inválido.
     */
    public Turma(String nome) {
        // Validação: garante que a turma sempre terá um nome válido
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da turma inválido: não pode ser nulo ou vazio.");
        }

        this.nome = nome.trim();

        // Inicializa a lista vazia — ArrayList permite adicionar elementos dinamicamente
        // A notação "<>" (diamond operator) infere o tipo <Aluno> automaticamente
        this.alunos = new ArrayList<>();
    }

    /**
     * Associa um Professor a esta Turma.
     *
     * CONCEITO — ASSOCIAÇÃO:
     * Este método estabelece a relação entre Turma e Professor.
     * O parâmetro é renomeado para "professor" (em vez de "p1") para
     * deixar claro o papel do objeto recebido — boas práticas de nomenclatura.
     *
     * @param professor Professor a ser associado. Não pode ser nulo.
     * @throws IllegalArgumentException se o professor for nulo.
     */
    public void associarProfessor(Professor professor) {
        // Validação: evita associar um professor inválido à turma
        if (professor == null) {
            throw new IllegalArgumentException("Professor inválido: não pode ser nulo.");
        }
        this.professor = professor;
    }

    /**
     * Adiciona um Aluno à lista de alunos da Turma.
     *
     * CONCEITO — AGREGAÇÃO EM AÇÃO:
     * O objeto Aluno é criado fora da Turma e apenas referenciado aqui.
     * A Turma não controla o ciclo de vida do Aluno — apenas o "conhece".
     *
     * @param aluno Aluno a ser adicionado. Não pode ser nulo.
     * @throws IllegalArgumentException se o aluno for nulo.
     */
    public void addAluno(Aluno aluno) {
        // Validação: evita adicionar referências nulas à lista
        if (aluno == null) {
            throw new IllegalArgumentException("Aluno inválido: não pode ser nulo.");
        }
        this.alunos.add(aluno);
    }

    /**
     * Retorna a lista de alunos da turma de forma protegida.
     *
     * CONCEITO — DEFENSIVE COPY (Cópia Defensiva):
     * Retornar diretamente "this.alunos" permitiria que código externo
     * modificasse a lista sem passar pelo método addAluno(), quebrando
     * o encapsulamento. Collections.unmodifiableList() retorna uma
     * "visão" somente-leitura da lista original, protegendo o estado interno.
     *
     * @return lista imutável de alunos.
     */
    public List<Aluno> getAlunos() {
        return Collections.unmodifiableList(alunos);
    }

    /**
     * Retorna o Professor associado a esta Turma.
     *
     * CONCEITO — GETTER:
     * Permite acesso controlado ao atributo privado "professor".
     * Pode retornar null se nenhum professor tiver sido associado ainda.
     *
     * @return o Professor associado, ou null se não houver.
     */
    public Professor getProfessor() {
        return professor;
    }

    /**
     * Sobrescrita do toString() para exibição completa da Turma.
     *
     * CONCEITO — @Override + toString():
     * Ao concatenar a lista "alunos" diretamente na String, o Java
     * chama automaticamente o toString() de cada objeto Aluno dentro
     * da lista — por isso é importante que Aluno também sobrescreva
     * seu próprio toString().
     *
     * @return representação textual completa da Turma.
     */
    @Override
    public String toString() {
        return "Turma: "     + nome      + "\n" +
               "Professor: " + professor + "\n" +
               "Alunos: "    + alunos;
    }
}