package Ex06;

public class ArtigoTecnico extends Publicacao {

    private String[] referencias;
    private static final int MIN_REFERENCIAS = 5;

    public ArtigoTecnico(String titulo, String autor, String textoBase, String[] referencias) {
        super(titulo, autor, textoBase);
        // Garante que nunca iremos armazenar Null Diretamente
        this.referencias = (referencias != null) ? referencias : new String[0];
    }

    @Override
    public boolean podeSerPublicada() {
        if (referencias.length < MIN_REFERENCIAS) {
            System.out.println("Artigo Não Pode Ser Publicado. Referências Insuficientes");
            return false;
        }
        return true;
    }

    @Override
    public String gerarResumo() {
        StringBuilder sb = new StringBuilder();
        sb.append("  [ARTIGO TÉCNICO] ").append(titulo).append("\n");
        sb.append("  Autor:           ").append(autor).append("\n");
        sb.append("  Referências (").append(referencias.length).append("):\n");
        for (String ref : referencias) {
            sb.append("    • ").append(ref).append("\n");
        }
        return sb.toString();
    }
}
