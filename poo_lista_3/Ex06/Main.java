package Ex06;

public class Main {

    static void separador() {
        System.out.println("─".repeat(45));
    }

    public static void main(String[] args) {

        // Array de Objetos para Publicações
        Publicacao[] publicacoes = {

            // ✔ Notícia válida
            new Noticia(
                "Novo Recorde Mundial de Temperatura",
                "Carlos Mendes",
                "Cientistas registraram nesta semana o maior índice de temperatura "
                + "já documentado no hemisfério sul, gerando alertas em diversas nações."
            ),

            // ✗ Notícia inválida — texto curto
            new Noticia(
                "Título OK",
                "Redação",
                "Texto curto."
            ),

            // ✔ Artigo técnico válido
            new ArtigoTecnico(
                "Padrões de Projeto em Java",
                "Ana Paula",
                "Este artigo discute os principais padrões de projeto...",
                new String[]{
                    "Gamma et al. — Design Patterns (1994)",
                    "Bloch — Effective Java (2018)",
                    "Martin — Clean Code (2008)",
                    "Fowler — Refactoring (2018)",
                    "Freeman — Head First Design Patterns (2004)"
                }
            ),

            // ✗ Artigo técnico inválido — poucas referências
            new ArtigoTecnico(
                "Artigo Incompleto",
                "João Silva",
                "Conteúdo do artigo...",
                new String[]{ "Só uma referência" }
            ),

            // ✔ Tutorial válido
            new Tutorial(
                "Como configurar o Git do zero",
                "Maria Souza",
                "Guia completo para iniciantes.",
                new String[]{
                    "Instalar o Git no sistema operacional",
                    "Configurar nome e e-mail com git config",
                    "Criar o primeiro repositório com git init"
                }
            ),

            // ✗ Tutorial inválido — passos insuficientes
            new Tutorial(
                "Tutorial Vazio",
                "Autor X",
                "Sem passos ainda.",
                new String[]{}
            )
        };

        // ── Desafio: percorre todas e publica apenas as válidas ──────
        System.out.println("\n===== PLATAFORMA DE CONTEÚDO =====\n");

        for (Publicacao p : publicacoes) {
            separador();
            p.validarPublicacao();
        }

        separador();
    }
}