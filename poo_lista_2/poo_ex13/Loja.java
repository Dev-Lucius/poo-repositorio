package poo_ex13;

public class Loja {

    private final String nome;

    public Loja(String nome) {
        this.nome = nome;
    }

    /**
     * Adiciona um Item a um Carrinho.
     *
     * CONCEITO — ASSOCIAÇÃO VIA PARÂMETRO:
     * A Loja não cria nem armazena o Carrinho.
     * Ela recebe o Carrinho como parâmetro e delega
     * a operação para o próprio objeto — os dois existem
     * de forma completamente independente.
     *
     * @param carrinho Carrinho que receberá o item.
     * @param item     Item a ser adicionado.
     */
    public void adicionarItem(Carrinho carrinho, Item item) {
        if (carrinho == null)
            throw new IllegalArgumentException("Carrinho inválido.");
        if (item == null)
            throw new IllegalArgumentException("Item inválido.");

        System.out.println("[" + nome + "] Adicionando item ao carrinho de "
                           + carrinho.getCliente() + "...");
        carrinho.adicionarItem(item); // delega ao Carrinho
    }
}