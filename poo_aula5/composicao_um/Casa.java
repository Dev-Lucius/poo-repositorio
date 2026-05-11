package composicao_um;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Representa uma Casa que é composta por Cômodos.
 *
 * CONCEITO — COMPOSIÇÃO:
 * A Casa é dona do ciclo de vida dos Cômodos. Diferente da Agregação,
 * aqui os Cômodos NÃO existem de forma independente — eles só fazem
 * sentido dentro de uma Casa. Se a Casa for destruída, os Cômodos
 * também deixam de existir junto com ela.
 *
 * CONCEITO — INNER CLASS (Classe Interna):
 * Comodo é declarada como uma classe interna e privada de Casa.
 * Isso reforça o conceito de Composição: o Cômodo pertence
 * exclusivamente à Casa e não pode ser usado por nenhuma outra classe.
 *
 * CONCEITO — ENCAPSULAMENTO:
 * Todos os atributos são privados e o acesso à lista de cômodos
 * é controlado por métodos públicos da classe.
 */
public class Casa {

    /**
     * Classe interna que representa um Cômodo da Casa.
     *
     * CONCEITO — INNER CLASS PRIVADA:
     * Ao declarar esta classe como "private", garantimos que ela
     * só pode ser instanciada e utilizada dentro da própria classe Casa.
     * Nenhuma classe externa tem acesso a Comodo — o que é exatamente
     * o comportamento esperado em uma Composição forte.
     */
    private class Comodo {

        // Atributo do cômodo — seu nome (ex: "quarto", "cozinha")
        private final String nome;

        /**
         * Construtor do Cômodo.
         *
         * @param nome Nome do cômodo. Não pode ser nulo ou vazio.
         * @throws IllegalArgumentException se o nome for inválido.
         */
        public Comodo(String nome) {
            // Validação: garante que nenhum cômodo seja criado sem nome
            if (nome == null || nome.trim().isEmpty()) {
                throw new IllegalArgumentException("Nome do cômodo inválido: não pode ser nulo ou vazio.");
            }
            this.nome = nome;
        }

        /**
         * Sobrescrita do toString() do Cômodo.
         *
         * CONCEITO — @Override:
         * Permite que o nome do cômodo seja exibido diretamente ao
         * iterar a lista ou ao usar System.out.println(comodo).
         *
         * @return representação textual do Cômodo.
         */
        @Override
        public String toString() {
            return nome;
        }
    }

    // Lista privada de cômodos — só acessível dentro de Casa
    // "final" garante que a referência à lista nunca será trocada por outra
    private final List<Comodo> comodos;

    /**
     * Construtor da Casa.
     *
     * CONCEITO — COMPOSIÇÃO NO CONSTRUTOR:
     * Os Cômodos são criados DENTRO do construtor da Casa, reforçando
     * que eles nascem junto com a Casa e não existem antes dela.
     * Isso é a essência da Composição: o "todo" controla a criação
     * e destruição das suas "partes".
     */
    
    public Casa() {
        // Inicializa a lista de cômodos — ArrayList permite tamanho dinâmico
        this.comodos = new ArrayList<>();

        // Os cômodos são criados aqui e pertencem exclusivamente a esta Casa
        // Nota: "new Comodo(...)" só é possível aqui dentro pois Comodo é private
        comodos.add(new Comodo("Banheiro"));
        comodos.add(new Comodo("Cozinha"));
        comodos.add(new Comodo("Quarto"));
    }

    /**
     * Exibe no console todos os cômodos da Casa.
     *
     * CONCEITO — FOR-EACH:
     * O loop "for (Comodo comodo : comodos)" percorre cada elemento
     * da lista automaticamente, sem precisar de índice manual.
     * A cada iteração, "comodo" representa o elemento atual da lista.
     * O System.out.println() chama automaticamente o toString() de cada Comodo.
     */
    public void mostrarComodos() {
        System.out.println("=== CASA ===");

        // Para cada cômodo na lista, imprime sua representação (toString)
        for (Comodo comodo : comodos) {
            System.out.println("- " + comodo);
        }
    }

    /**
     * Retorna a lista de cômodos de forma protegida.
     *
     * CONCEITO — DEFENSIVE COPY (Cópia Defensiva):
     * Retornar diretamente "this.comodos" permitiria que código externo
     * modificasse a lista sem o controle da Casa, quebrando a Composição.
     * Collections.unmodifiableList() retorna uma visão somente-leitura,
     * impedindo adições ou remoções externas.
     *
     * @return lista imutável de cômodos (como String para não expor a inner class).
     */
    public List<String> getComodos() {
        // Converte para String pois Comodo é uma classe privada —
        // não seria possível retornar List<Comodo> para quem está fora da classe
        List<String> nomesComodos = new ArrayList<>();
        for (Comodo comodo : comodos) {
            nomesComodos.add(comodo.toString());
        }
        return Collections.unmodifiableList(nomesComodos);
    }
}