package Ex10;

import java.util.Random;

public class Arqueiro extends Unidade {
    private static final double CHANCE_CRITICO = 0.30; // 30% de chance
    private static final double MULTIPLICADOR_CRIT = 2.0; // dano dobrado no crítico

    private final Random random = new Random();

    public Arqueiro(String nome, int vida, int ataqueBase, int defesa) {
        super(nome, vida, ataqueBase, defesa);
    }

    @Override
    public void atacar(Unidade alvo) {
        boolean critico = random.nextDouble() < CHANCE_CRITICO;
        int danoBase = Math.max(1, ataqueBase - alvo.getDefesa());
        int danoFinal = critico ? (int) (danoBase * MULTIPLICADOR_CRIT) : danoBase;

        if (critico) {
            System.out.printf("  🏹 %s dispara uma flecha CRÍTICA em %s causando %d de dano! (2x)%n",
                    nome, alvo.getNome(), danoFinal);
        } else {
            System.out.printf("  🏹 %s dispara uma flecha em %s causando %d de dano.%n",
                    nome, alvo.getNome(), danoFinal);
        }
        alvo.receberDano(danoFinal);
    }
}
