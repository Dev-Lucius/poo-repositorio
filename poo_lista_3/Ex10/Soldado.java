package Ex10;

public class Soldado extends Unidade{
    // O Soldado usa sua defesa para absorver parte do dano recebido
    private static final double REDUCAO_FISICA = 0.40; // absorve 40% do dano

    public Soldado(String nome, int vida, int ataqueBase, int defesa) {
        super(nome, vida, ataqueBase, defesa);
    }

    @Override
    public void atacar(Unidade alvo) {
        // Ataque físico direto: ataqueBase menos a defesa do alvo
        int dano = Math.max(1, ataqueBase - alvo.getDefesa());
        System.out.printf("  ⚔  %s golpeia %s causando %d de dano!%n",
                nome, alvo.getNome(), dano);
        alvo.receberDano(dano);
    }

    // Sobrescreve receberDano: reduz o dano recebido pela defesa física
    @Override
    public void receberDano(int dano) {
        int danoReduzido = (int) (dano * (1 - REDUCAO_FISICA));
        int danoEfetivo = Math.max(0, danoReduzido - defesa);
        System.out.printf("  🛡  %s absorve com armadura! Dano: %d → %d (defesa física ativa)%n",
                nome, dano, danoEfetivo);
        super.receberDano(danoEfetivo);
    }
}
