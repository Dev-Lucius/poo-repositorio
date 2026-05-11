package composicao_dois;

/**
 * Classe principal para demonstrar o conceito de COMPOSIÇÃO com
 * a hierarquia Matriz → Filiais.
 *
 * CONCEITO — COMPOSIÇÃO:
 * A Matriz "possui" as Filiais. O ciclo de vida das Filiais está
 * atrelado ao da Matriz: se a Matriz deixar de existir (matriz = null),
 * as Filiais perdem sua referência principal e serão coletadas
 * pelo Garbage Collector junto com ela.
 *
 * CONCEITO — REGRA DE NEGÓCIO PROTEGIDA POR EXCEÇÃO:
 * A classe Empresa protege sua regra ("filiais não podem ter filiais")
 * lançando uma Exception. Este Main demonstra exatamente essa proteção
 * sendo acionada na prática.
 */
public class Main {
    public static void main(String[] args) {

        // -------------------------------------------------------
        // CRIANDO A MATRIZ
        // Toda Empresa começa como Matriz (filial = false).
        // -------------------------------------------------------
        Empresa matriz = new Empresa("XPTO");
        System.out.println(matriz); // imprime: MATRIZ - XPTO

        // -------------------------------------------------------
        // TRY/CATCH — TRATAMENTO DE EXCEÇÃO VERIFICADA
        //
        // CONCEITO — CHECKED EXCEPTION:
        // O método addFilial() declara "throws Exception", o que
        // significa que o compilador OBRIGA o chamador a tratar
        // o erro. Sem o try/catch aqui, o código nem compilaria.
        //
        // O bloco "try"   → executa o código que pode lançar erro
        // O bloco "catch" → captura e trata o erro se ele ocorrer
        // -------------------------------------------------------
        try {

            // Adiciona a primeira filial à Matriz
            // addFilial() retorna a própria filial, permitindo
            // guardar a referência para uso posterior
            Empresa filial = matriz.addFilial(new Empresa("XPTOzin"));
            System.out.println(filial); // imprime: FILIAL - XPTOzin

            // Adiciona uma segunda filial à mesma Matriz
            Empresa filial2 = matriz.addFilial(new Empresa("Betazin"));
            System.out.println(filial2); // imprime: FILIAL - Betazin

            // -------------------------------------------------------
            // TESTANDO A REGRA DE NEGÓCIO — FILIAL DE FILIAL
            //
            // Esta linha tenta adicionar uma filial a outra filial,
            // o que viola a regra definida em Empresa.addFilial().
            // O método lança uma Exception com a mensagem de erro,
            // que é capturada pelo bloco catch abaixo.
            // -------------------------------------------------------
            filial.addFilial(new Empresa("filial da filial")); // ← dispara a Exception

        } catch (Exception exc) {
            // CONCEITO — System.err:
            // Diferente de System.out (saída padrão), System.err é a
            // saída de erro padrão — geralmente exibida em vermelho
            // no terminal. Usada para destacar mensagens de erro.
            System.err.println("Erro: " + exc.getMessage());
        }

        // -------------------------------------------------------
        // COMPOSIÇÃO NA PRÁTICA — CICLO DE VIDA
        //
        // Se descomentar as linhas abaixo:
        //
        //   matriz = null;
        //
        // A referência à Matriz seria removida. Como as Filiais foram
        // criadas com "new Empresa(...)" dentro de addFilial() e estão
        // armazenadas DENTRO da lista da Matriz, ao remover a Matriz
        // todas as Filiais perdem suas referências e o Garbage Collector
        // as elimina junto — demonstrando o ciclo de vida compartilhado
        // da Composição.
        //
        // Diferente da Agregação: lá, os Alunos existiam fora da Turma
        // e continuariam vivos mesmo após a Turma ser removida.
        // -------------------------------------------------------

        // matriz = null;
        // Se quiser verificar se filial ainda existe após matriz = null,
        // só é possível se você guardou a referência ANTES de nulificar
        // a matriz — mas a lista interna de filiais da Matriz teria sido
        // perdida junto com ela.
    }
}