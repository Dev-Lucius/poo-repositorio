package poo_ex7;

public class Main {
    public static void main(String[] args) {

        Professor pf = new Professor(1, "Márcio");

        Turma t1 = new Turma(1, "Matemática");
        Turma t2 = new Turma(2, "Física");
        Turma t3 = new Turma(1, "Química");

        pf.adicionarTurma(t1);
        pf.adicionarTurma(t2);
        pf.adicionarTurma(t3);

        pf.acessarTurma();
    }
}
