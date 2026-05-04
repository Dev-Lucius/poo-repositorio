// 1. Sentido do Movimento
// 2. Abre ou Fecha por 100 ticks de tempo

public class PortaoEletrico{

    // Variáveis do Portão Elétrico --> Atributos da Classe
    boolean aberto = false; // Atributo para representar os possíveis estados
    boolean movimento = false; // Atributo para representar os possíveis movimentos
    boolean abrindo = false; // Atributo para representar o Sentido do Movimnento

    // Método Exposto da Classe e sem Retorno
    public void apertarBotao(){
        System.out.println("Apertou o Botão...");
        if(!aberto){
            movimento = true;
            aberto = true;
            abrindo = true;
        } else if(movimento) {
            movimento = false;
            abrindo = false;
        } else{
            movimento = true;
            abrindo = false;
        }
    }

    // para fazer -> Implementar os ticks
    public void passouTempo(int ticks){
        if(movimento && abrindo){
            movimento = false;
            abrindo = false;
        } else if(movimento && !abrindo){
            movimento = true;
            abrindo = true;
        }
    }
    
}