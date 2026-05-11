package poo_ex19;

public class Main {

    public static void main(String[] args) {

        Professor professor = new Professor(
            1,
            "Dr. Carlos"
        );

        Disciplina disciplina = new Disciplina(
            "Programação Orientada a Objetos",
            professor
        );

        Aluno aluno1 = new Aluno(
            1001,
            "Lucas",
            disciplina
        );

        Aluno aluno2 = new Aluno(
            1002,
            "Maria",
            disciplina
        );

        System.out.println(disciplina);
        System.out.println();

        System.out.println(aluno1);
        System.out.println();

        System.out.println(aluno2);
    }
}