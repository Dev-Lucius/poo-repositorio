package poo_ex17;

public class Main {
    public static void main(String[] args) {

        Tecnico tecnico = new Tecnico(1, "Carlos Ancelotti", 66);

        Time time = new Time("Brasil", tecnico);

       Jogador j1 = new Jogador(1, "Vini Jr", "Ponta Esquerda", time);
       Jogador j2 = new Jogador(1, "Casemiro", "Primeiro Volante", time);

        time.adicionarJogador(j1);
        time.adicionarJogador(j2);

        System.out.println(time);

        time.totalJogadores();
    }
}
