public class Main {
    public static void main(String[] args) {
        SessaoVotacao s = new SessaoVotacao();

        s.abrir(); // Abrindo Votação
        s.votarSim(); 

        s.votarSim();
        s.votarSim();
        s.votarNao();

        s.votarNao(); 
        s.fechar(); // Fechado Votação 

        System.out.println("Sim esperado = 3 | Atual = " + s.sim());
        System.out.println("Nao esperado = 2 | Atual = " + s.nao());
        System.out.println("Total esperado = 3 | Atual = " + s.total());
        System.out.println("Aberta esperado = false | Atual = " + s.estaAberta());
    }
}
