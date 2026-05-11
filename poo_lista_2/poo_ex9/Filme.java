package poo_ex9;

public class Filme {

    /**
    * Todos os atributos são privados. O acesso e a modificação ocorrem
    * exclusivamente pelos getters e setters, que também validam os dados.
    */
    private int id;
    private String nome;

    /**
     * O Filme não cria o Diretor — apenas guarda uma referência
     * a um objeto Diretor que já existe. 
     * 
     * Ambos têm ciclos de vida independentes: o Filme pode existir sem Diretor (diretor = null)
     * e o Diretor pode existir sem nenhum Filme.
     *
     * Começa como null e é definido via setDiretorFilme(),
     * chamado automaticamente por Diretor.adicionarFilme().
     */
    private Diretor diretor;

    // CONSTRUTOR
    /**
     * Aqui construímos um Objeto parcialmente construído
     * 
     * Ou seja, tal construtor recebe apenas os atributos id e nome - o Diretor não é
     * obrigatório na criação.
     * 
     * Isso nos permite cadastrar o Filme antes de associá-lo a um Diretor
     * 
     * @param id -> Identificador único. Deve ser maior que zero.
     * @param nome -> Nome do filme. Não pode ser nulo ou vazio.
     */
    public Filme(int id, String nome){
        setIdFilme(id);
        setNomeFilme(nome);
        /**
        * Diretor começa Null --> Será definido via setDiretorFilme()
        * quando Diretor.adicionarFilme() for chamado 
        */
    }

    // GETTERS
    public int getIdFilme() {
        return id;
    }

    public String getNomeFilme() {
        return nome;
    }

    public void consultarDiretor(){
        if(diretor == null){
            System.out.println("O filme \"" + nome + "\" ainda não possui diretor associado.");
        } else {
            // toString do Diretor é chamado automaticamente
            System.out.println("Filme: " + nome);
            System.out.println("Diretor: " + diretor);
        }
    }

    // SETTERS
    public void setIdFilme(int id){
        if(id <= 0){
            throw new IllegalArgumentException("Id Inválido");
        } else {
            this.id = id;
        }
    }

    public void setNomeFilme(String nome){
        if(nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("Nome Inválido");
        } else {
            this.nome = nome;
        }
    }

    /**
     * Este setter é o "outro lado" da sincronização iniciada em
     * Diretor.adicionarFilme(). O mesmo não pode ser chamado diretamente
     * pelo código externo - Sua associação deve sempre ser feita via Diretor.adicionarFilme()
     * 
     * Isso assegura que ambos os lados fiquem atualizados ao mesmo tempo
     *  
     * @param diretor -->  Diretor a ser associado. Não pode ser nulo.
     * @throws IllegalArgumentException --> se o diretor for nulo.
     */
    public void setDiretorFilme(Diretor diretor) {
        if(diretor == null){
            throw new IllegalArgumentException("Diretor Inválido");
        } else {
            this.diretor = diretor;
        }
    }

    /**
     * ToString de Filme.
     * Chamado automaticamente em System.out.println(filme) e
     * quando o objeto é concatenado em uma String — como em
     * Diretor.acessarDados(), que imprime "  - " + f.
     */
    @Override
    public String toString(){
        return "Filme #" + id + " - " + nome;
    }
}
