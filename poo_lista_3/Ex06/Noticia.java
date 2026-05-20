package Ex06;

public class Noticia extends Publicacao {
    private static final int MIN_TEXTO = 100;

    public Noticia(String titulo, String autor, String textoBase) {
        super(titulo, autor, textoBase);
    }

    @Override
    public boolean podeSerPublicada() {
        if (titulo == null || textoBase.length() < MIN_TEXTO || textoBase == null) {
            System.out.println("Erro. Noticia Não Atende aos Requisitos para ser Publicada");
            return false;
        }
        return true;
    }

    @Override
    public String gerarResumo() {
        return  "  [NOTÍCIA] " + titulo + "\n" +
                "  Autor:    " + autor + "\n" +
                "  Trecho:   " + textoBase.substring(0, Math.min(60, textoBase.length())) + "...\n";
    }
}
