public class SessaoVotacao {

    private int votacao = 0;
    private int totalSim = 0;
    private int totalNao = 0;
    private int totalVotos = 0;

    boolean condicao = false;
    public boolean abrir(){
        condicao = true;
        return condicao;
    }

    public boolean fechar(){
        condicao = false;
        return condicao;
    }

    public void votarSim(){
        if(condicao){
            votacao = votacao + 1;
            totalSim++;
            totalVotos++;
        }
    }

    public void votarNao(){
        if(condicao){
            totalNao++;
            totalVotos++;
        }
    }

    public int total(){
        return totalVotos;
    }

    public int sim() {
        return totalSim;
    }

    public int nao() {
        return totalNao;
    }

    public boolean estaAberta(){
        return condicao;
    }
}
