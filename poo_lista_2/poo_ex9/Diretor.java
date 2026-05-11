package poo_ex9;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe Diretor.java pode ser responsável por UM ou VÁRIOS filmes
 * 
 * Associação Bidirecional:
 * Diretor e Filme se conhecem mutuamente:
 *  - O diretor guarda uma lista dos seus filmes
 *  - O filme guarda uma referência ao seu Diretor
 * Isso é denominado Associação Bidirecional -> ambos os lados são mantidos sincronizados pelo método adicionarFilme()
 */

public class Diretor {
    
    /**
     * Encapsulamento
     * Todos os atributos são privados, isto é, seu acesso e sua modificação
     * ocorre por meio de Getters e Setters, o qual também válida os dados e 
     * trata seus erros e exceções
     */
    private int id;
    private String nome;

    // Um Diretor Pode ter 1 ou Vários Filmes
    /**
     * Dentro do Construtor, a lista é inicializada com "new ArrayList<>()", a fim de
     * garantir que ela nunca será null.
     * 
     * Isso evita o erro de NullPointerException ao chamar filmes.add() ou filmes.isEmpty()
     * antes de quaisquer edições
     */
    private List<Filme> filmes;

    /**
     * Construtor
     * Ao invés de validarmos os dados diretamente aqui, o construtor chama os setters diretamente.
     * 
     * Isso evita duplicação da lógica:
     *  - Se a validação mudar no setter, o construtor "adere" tal mudança de maneira automática
     * @param id -> Identificador Único: Deve ser maior do que zero
     * @param nome -> Nome> Não deve nulo ou vazio
     */
    public Diretor(int id, String nome){
        setIdDiretor(id);
        setNomeDiretor(nome);
        // Lista inicialmente vazia --> Irá receber os filmes via métodos --> adicionarFilme()
        this.filmes = new ArrayList<>();
    }

    public int getIdDiretor() {
        return id;
    }

    public String getNomeDiretor() {
        return nome;
    }

    /**
     * Defensive Copy
     * 
     * Ao retornar diretamente "this.filmes" permitiria que o código externo
     * chamasse filmes.add sem passar pelo método adicionarFilme(), o que burlaria as 
     * regras de validação e a sincronização bidirecional.
     * 
     * Nesse sentido, Collections.unmodifiableList() nos retorna uma visão
     * somente-leitura da lista, o que previne possíveis modificações externas
     * @return -> lista imutável de filmes do diretor
     */
    public List<Filme> getListFilmes(){
        return Collections.unmodifiableList(filmes);
    }

    public void setIdDiretor(int id){
        if(id <= 0){
            throw new IllegalArgumentException("Id inválido");
        } else {
            this.id = id;
        }
    }

    public void setNomeDiretor(String nome){
        if(nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("Nome inválido");
        } else {
            this.nome = nome;
        }
    }

    /**
     * Método criado para adicionar um Filme à lista deste Diretor e sincronização a relação
     * no lado do Filme (associação bidirecional)
     * 
     * A fim de manter a consistência, ao adicionar um Filme ao Diretor, o próprio filme também
     * se atualiza para referenciar este Diretor através de filme.setDiretorFilme().
     * 
     * Sem isso, o Diretor Conheceria o Filme, porém, o Filme não Conheceria o Diretor 
     * @param filme
     * @throws IllegalArgumentException
     */
    public void adicionarFilme(Filme filme){
        if(filme == null){
            throw new IllegalArgumentException("Filme inválido");
        } 
        // Um filme só será adicionado quando ele não estiver na lista -> Evitar Duplicatas
        if(!filmes.contains(filme)) {
            filmes.add(filme);
            // Sincroniza o lado do Filme com este Diretor
            // Garantindo que a associação seja consistente em ambos os lados
            filme.setDiretorFilme(this);
        }
    }

    /**
     * Método criado para exibir os dados completos do Diretor e seus filmes
     * 
     * Loop For-Each
     * Este loop percorre cada elemento da lista automaticamente. A cada iteração, "f" simboliza
     * o filme atual.
     * 
     * Por sua vez, System.out.println() chama automaticamente o toString() de cada filme
     */
    public void acessarDados(){
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Filmes (" + filmes.size() + "): ");

        // Verifica se há filmes antes de iterar --> Exibe uma mensagem se a lista estiver vazia
        if(filmes.isEmpty()){
            System.out.println("Nenhum Filme foi Feito por este Diretor");
        } else {
            for (Filme f : filmes) {
                System.out.println(" - " + f);
            }
        }
    }
    /**
     * @Override toString()
     * 
     * Define a Representação textual resumida da classe Diretor.
     * Ela é chamada automaticamente quando chamamos System.out.println(d1); no Main
     */
    @Override
    public String toString(){
        return  "Diretor #" + id + "\n" + 
                "nome: " + nome + 
                "(" + filmes.size() + " Filme(s) Dirigido(s))";
    }
}
