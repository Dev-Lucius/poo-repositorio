public class Main{
    public static void main (String[] args){
        /*
         * ==========================================================
         * AULA 1 - FUNDAMENTOS DE PROGRAMAÇÃO ORIENTADA A OBJETOS
         * ==========================================================
         *
         * Objetivo:
         * Demonstrar o conceito de ABSTRAÇÃO através da modelagem
         * de um Portão Elétrico.
         *
         * Ideia principal:
         * O usuário interage apenas com o comportamento do objeto
         * (apertar botão), sem conhecer sua implementação interna.
         *
         * Estados possíveis do portão:
         *  - Aberto
         *  - Fechado
         *  - Em movimento
         *
         * Ação possível:
         *  - Apertar botão
         *
         * A lógica interna decide a transição de estados.
         */

       // Inicialmente Fechado
       PortaoEletrico portao = new PortaoEletrico();

       boolean aberto = false; // Variável para representar os possíveis estados
       boolean movimento = false; // Variável para representar os possíveis movimentos

       // Uma ideia...
       // String estado = "ABERTO";
       System.out.println("Movimento: " + portao.movimento);
       System.out.println("Aberto: " + portao.aberto);
       
       // Apertar o botão --> Gera uma AÇÃO
       portao.apertarBotao();
       System.out.println("Apertou o Botão...");
       System.out.println("Movimento: " + portao.movimento);
       System.out.println("Aberto: " + portao.aberto);
       // aberto = true;
       // movimento = true;    

       // Depois de um tempo ...
       portao.passouTempo();       
       System.out.println("Passou um Tempo...");

       // botão é apertado novamente...
       portao.apertarBotao();
       System.out.println("Apertou o Botão...");
       System.out.println("Movimento: " + portao.movimento);
       System.out.println("Aberto: " + portao.aberto);
       // movimento = false;

       // Apertou o botão de novo...
       portao.apertarBotao();
       System.out.println("Passou um Tempo...");
       portao.passouTempo();
       // movimento = true;
       // ... Depois de um tempo
       portao.passouTempo();
       // aberto = false;
       // movimento = false;
       System.out.println("Movimento: " + portao.movimento);
       System.out.println("Aberto: " + portao.aberto);

       // Este código é frágil, pois ele possui uma difícil manutenção e reutilização!!
       // Nesse caso, Porque construir uma Classe?
       // Proteger Aquilo que estamos usando e construindo -> Encapsulamento!     
    }
}
