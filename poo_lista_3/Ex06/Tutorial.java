package Ex06;

public class Tutorial extends Publicacao {
    private static final int MIN_PASSOS = 3;

    private String[] passos;

    public Tutorial(String titulo, String autor,
                    String textoBase, String[] passos) {
        super(titulo, autor, textoBase);
        this.passos = (passos != null) ? passos : new String[0];
    }

    @Override
    public boolean podeSerPublicada() {
        if (passos.length < MIN_PASSOS) {
            System.out.println("  → Passos insuficientes: "
                + passos.length + "/" + MIN_PASSOS + " mínimos.");
            return false;
        }
        return true;
    }

    @Override
    public String gerarResumo() {
        StringBuilder sb = new StringBuilder();
        sb.append("  [TUTORIAL] ").append(titulo).append("\n");
        sb.append("  Autor:     ").append(autor).append("\n");
        sb.append("  Passos (").append(passos.length).append("):\n");
        for (int i = 0; i < passos.length; i++) {
            sb.append("    ").append(i + 1).append(". ").append(passos[i]).append("\n");
        }
        return sb.toString();
    }
}