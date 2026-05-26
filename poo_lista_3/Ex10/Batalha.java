package Ex10;

public class Batalha {

    private Unidade unidadeA;
    private Unidade unidadeB;

    public Batalha(Unidade a, Unidade b) {
        this.unidadeA = a;
        this.unidadeB = b;
    }

    // ── Exibe o estado atual das duas unidades ────────────────────────
    private void exibirStatus() {
        System.out.println("  " + unidadeA.status());
        System.out.println("  " + unidadeB.status());
    }

    // ── Linha divisória ───────────────────────────────────────────────
    private static void linha() {
        System.out.println("─".repeat(60));
    }

    // ── Loop principal da batalha ─────────────────────────────────────
    public void iniciar() {
        System.out.println("\n" + "═".repeat(60));
        System.out.printf("  ⚔  BATALHA: %s  VS  %s%n",
                unidadeA.getNome(), unidadeB.getNome());
        System.out.println("═".repeat(60));

        int turno = 1;

        // A batalha continua enquanto ambas estiverem vivas
        while (unidadeA.estaViva() && unidadeB.estaViva()) {

            System.out.println("\n┌─ TURNO " + turno + " " + "─".repeat(50 - String.valueOf(turno).length()) + "┐");

            // Turno da unidade A
            System.out.println("\n  [" + unidadeA.getNome() + " ataca]");
            unidadeA.atacar(unidadeB);

            // Verifica se B morreu após o ataque de A
            if (!unidadeB.estaViva())
                break;

            // Turno da unidade B
            System.out.println("\n  [" + unidadeB.getNome() + " ataca]");
            unidadeB.atacar(unidadeA);

            // Status ao final do turno
            System.out.println();
            linha();
            System.out.println("  Status ao fim do turno " + turno + ":");
            exibirStatus();
            linha();

            turno++;
        }

        // ── Resultado ─────────────────────────────────────────────────
        System.out.println("\n" + "═".repeat(60));
        Unidade vencedor = unidadeA.estaViva() ? unidadeA : unidadeB;
        Unidade derrotado = unidadeA.estaViva() ? unidadeB : unidadeA;

        System.out.printf("  🏆 %s venceu a batalha!%n", vencedor.getNome());
        System.out.printf("  💀 %s foi derrotado após %d turnos.%n", derrotado.getNome(), turno);
        System.out.printf("  Vida restante de %s: %d HP%n",
                vencedor.getNome(), vencedor.getVidaAtual());
        System.out.println("═".repeat(60) + "\n");
    }
}