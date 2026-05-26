package Ex10;

public class Mago extends Unidade {

    private int manaAtual;
    private int manaMaxima;
    private static final int CUSTO_MANA = 20;
    private static final double BONUS_MAGICO = 2.5; // 150% a mais com mana

    public Mago(String nome, int vida, int ataqueBase, int defesa, int mana) {
        super(nome, vida, ataqueBase, defesa);
        this.manaMaxima = mana;
        this.manaAtual = mana;
    }

    @Override
    public void atacar(Unidade alvo) {
        if (manaAtual >= CUSTO_MANA) {
            // Ataque ampliado com mana
            manaAtual -= CUSTO_MANA;
            int danoMagico = (int) (ataqueBase * BONUS_MAGICO);
            System.out.printf("  ✨ %s conjura uma TEMPESTADE ARCANA em %s causando %d de dano! " +
                    "(mana restante: %d/%d)%n",
                    nome, alvo.getNome(), danoMagico, manaAtual, manaMaxima);
            alvo.receberDano(danoMagico);
        } else {
            // Ataque básico quando sem mana — ignora defesa (dano mágico)
            int danoBasico = Math.max(1, ataqueBase - alvo.getDefesa() / 2);
            System.out.printf("  🔮 %s lança um projétil mágico em %s causando %d de dano. " +
                    "(sem mana)%n",
                    nome, alvo.getNome(), danoBasico);
            alvo.receberDano(danoBasico);
        }
    }

    // Status com mana incluída
    @Override
    public String status() {
        return String.format("%-12s %s | Mana: %d/%d",
                nome, barraDeVida(), manaAtual, manaMaxima);
    }

    public int getManaAtual() {
        return manaAtual;
    }
}