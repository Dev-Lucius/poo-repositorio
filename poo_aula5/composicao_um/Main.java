package composicao_um;

/**
 * Classe principal para demonstrar o conceito de COMPOSIÇÃO em POO.
 *
 * CONCEITO — COMPOSIÇÃO:
 * Na Composição, os objetos "parte" (Cômodos) só existem enquanto o
 * objeto "todo" (Casa) existir. Quando a Casa é destruída (c1 = null),
 * os Cômodos perdem sua referência e são eliminados junto pelo
 * Garbage Collector do Java.
 *
 * Compare com a Agregação (aula anterior): lá, os Alunos continuavam
 * existindo mesmo após a Turma ser removida. Aqui, o comportamento
 * é o oposto — os Cômodos não fazem sentido fora da Casa.
 */
public class Main {
    public static void main(String[] args) {

        // -------------------------------------------------------
        // CRIANDO O OBJETO — COMPOSIÇÃO EM AÇÃO
        // Ao instanciar Casa, os Cômodos já são criados internamente
        // no construtor de Casa. Eles nascem juntos com a Casa e
        // não existem antes ou fora dela — isso é Composição.
        // -------------------------------------------------------
        Casa c1 = new Casa();

        // Chama o método que exibe os cômodos pertencentes à Casa
        c1.mostrarComodos();

        System.out.println("CHEGUEI AQUI");

        // -------------------------------------------------------
        // DESTRUINDO O OBJETO — CICLO DE VIDA COMPARTILHADO
        // Ao atribuir null a c1, removemos a única referência que
        // apontava para o objeto Casa na memória.
        // O Garbage Collector do Java eventualmente eliminará a Casa
        // e, junto com ela, todos os seus Cômodos — pois eles são
        // uma inner class privada e não possuem nenhuma referência
        // externa que os mantenha "vivos".
        // Isso demonstra na prática o conceito de Composição:
        // o ciclo de vida das partes está atrelado ao do todo.
        // -------------------------------------------------------
        
        c1 = null;
    }
}