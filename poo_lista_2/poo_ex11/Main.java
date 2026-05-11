package poo_ex11;

public class Main {
    public static void main(String[] args){
        Aluno a1 = new Aluno(1, "Lucas", 7.00);
        Escola e1 = new Escola("Instituto Ensina");

        System.out.println("Antes\n" + a1);
        e1.atualizarNota(a1, 8.5);
        System.out.println("Depois\n" + a1);
    }
}
