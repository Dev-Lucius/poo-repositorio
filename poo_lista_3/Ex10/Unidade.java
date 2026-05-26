package Ex10;

public abstract class Unidade {

    protected String nome;
    protected int vidaMaxima;
    protected int vidaAtual;
    protected int ataqueBase;
    protected int defesa;

    public Unidade(String nome, int vida, int ataqueBase, int defesa) {
        this.nome = nome;
        this.vidaMaxima = vida;
        this.vidaAtual = vida;
        this.ataqueBase = ataqueBase;
        this.defesa = defesa;
    }

    // ── Contrato: cada subclasse define como ataca ────────────────────
    public abstract void atacar(Unidade alvo);

    // ── Comportamento comum: receber dano ─────────────────────────────
    public void receberDano(int dano) {
        // Dano nunca pode ser negativo (ataque menor que defesa vira 0)
        int danoEfetivo = Math.max(0, dano);
        vidaAtual = Math.max(0, vidaAtual - danoEfetivo);
    }

    // ── Comportamento comum: verificar se ainda está viva ─────────────
    public boolean estaViva() {
        return vidaAtual > 0;
    }

    // ── Exibe barra de vida visual ────────────────────────────────────
    public String barraDeVida() {
        int total = 20;
        int preenchido = (int) ((vidaAtual / (double) vidaMaxima) * total);
        String barra = "█".repeat(preenchido) + "░".repeat(total - preenchido);
        return String.format("[%s] %d/%d HP", barra, vidaAtual, vidaMaxima);
    }

    // ── Status resumido ───────────────────────────────────────────────
    public String status() {
        return String.format("%-12s %s", nome, barraDeVida());
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getVidaAtual() {
        return vidaAtual;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getAtaqueBase() {
        return ataqueBase;
    }
}