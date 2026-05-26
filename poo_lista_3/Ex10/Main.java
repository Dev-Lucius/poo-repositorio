package Ex10;

public class Main {

    // Utilitário: título de seção
    static void titulo(String texto) {
        System.out.println("\n" + "◆".repeat(3) + " " + texto + " " + "◆".repeat(3));
    }

    public static void main(String[] args) {

        titulo("BATALHA 1 — Soldado vs Arqueiro");
        /*
         * Soldado: alta defesa, absorve dano físico (40% de redução + subtrai defesa)
         * Arqueiro: baixa defesa, mas 30% de chance de acerto crítico (2x dano)
         * Expectativa: resultado imprevisível — depende dos críticos do Arqueiro
         */
        Unidade soldado = new Soldado("Garen", 150, 35, 15);
        Unidade arqueiro = new Arqueiro("Caitlyn", 110, 40, 8);

        new Batalha(soldado, arqueiro).iniciar();

        titulo("BATALHA 2 — Mago vs Soldado");
        /*
         * Mago: começa forte com mana (ignora boa parte da defesa física),
         * enfraquece quando esgota a mana
         * Soldado: aguenta bem com defesa física, mas o dano mágico a ignora
         * Expectativa: Mago leva vantagem inicial, mas cai após esgotar mana
         */
        Unidade mago = new Mago("Lux", 120, 50, 5, 80);
        Unidade soldado2 = new Soldado("Darius", 160, 38, 18);

        new Batalha(mago, soldado2).iniciar();

        titulo("BATALHA 3 — Arqueiro vs Mago");
        /*
         * Arqueiro: dano físico com chance de crítico; mago tem defesa baixa
         * Mago: dano mágico alto no início; Arqueiro não tem redução mágica
         * Expectativa: duelo rápido — quem acertar crítico ou mago usar mana primeiro
         * decide
         */
        Unidade arqueiro2 = new Arqueiro("Ashe", 115, 42, 7);
        Unidade mago2 = new Mago("Syndra", 105, 52, 4, 60);

        new Batalha(arqueiro2, mago2).iniciar();
    }
}