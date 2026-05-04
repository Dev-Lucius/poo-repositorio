public class AntesMain{
    public static void main (String[] args){
        // Aula 1 - POO

        // POO tem como foco principal é atingir é a ABSTRAÇÃO
        // Manipular determinados comportamentos do Código
        // Trata-se de Codar para prevenir erros futuros!

        // Ao abstrir um comportamento ele se torna "limpo"
        // Isto é, mais utilizável, testável e afins
        
        // Abstração --> Controle E Portão de Garagem
        // - apertar o botao
        // - dependendo do estado anterior e estado atual, vai realizar uma ação

        /* 
            - estados possíveis
                * Movimento
                * aberto
                * fechado
            - ações possíveis
                * apertar o botao
        */

       // Criando uma Abstração sem POO
       boolean aberto = false; // Variável para representar os possíveis estados
       boolean movimento = false; // Variável para representar os possíveis movimentos

       // Uma ideia...
       // String estado = "ABERTO";
       System.out.println("Movimento: " + movimento);
       System.out.println("Aberto: " + aberto);
       
       // Apertar o botão --> Gera uma AÇÃO
       System.out.println("Apertou o Botão...");
       System.out.println("Movimento: " + movimento);
       System.out.println("Aberto: " + aberto);
       aberto = true;
       movimento = true;    

       // Depois de um tempo ...
       System.out.println("Passou um Tempo...");
       // botão é apertado novamente...
       System.out.println("Apertou o Botão...");
       System.out.println("Movimento: " + movimento);
       System.out.println("Aberto: " + aberto);
       movimento = false;

       // Apertou o botão de novo...
       System.out.println("Passou um Tempo...");
       movimento = true;
       // ... Depois de um tempo
       aberto = false;
       movimento = false;
       System.out.println("Movimento: " + movimento);
       System.out.println("Aberto: " + aberto);

       // Este código é frágil, pois ele possui uma difícil manutenção e reutilização!!
       // Nesse caso, Porque construir uma Classe?
       // Proteger Aquilo que estamos usando e construindo -> Encapsulamento!     
    }
}