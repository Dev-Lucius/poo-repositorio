package agregacao;

public class Main{
    public static void main(String[] args){
        // System.out.println("Hello World");

        // -------------------------------------------------------
        // INSTANCIANDO OBJETOS
        // Aqui estamos criando objetos (instâncias concretas) a
        // partir das classes Turma, Aluno e Professor.
        // Cada `new` aloca um novo objeto na memória.
        // ---------

        // Criando um Objeto do tipo Turma com o nome "POO"
        Turma turma = new Turma("POO");

        // Criando Três objetos distintos do tipo Aluno
        Aluno a1 = new Aluno("Victor");
        Aluno a2 = new Aluno("Christian");
        Aluno a3 = new Aluno("Rafael");

        // -------------------------------------------------------
        // AGREGAÇÃO EM AÇÃO — Turma <> Alunos
        // A Turma "agrega" os Alunos: ela os referencia internamente,
        // mas os objetos Aluno existem fora da Turma.
        // Se a Turma deixar de existir, a1, a2 e a3 continuam na memória.
        // -------------------------------------------------------
        turma.addAluno(a1);
        turma.addAluno(a2);
        turma.addAluno(a3);

        // -------------------------------------------------------
        // ASSOCIAÇÃO — Turma <> Professor
        // O Professor é associado à Turma, mas também existe de
        // forma independente. Isso é um exemplo de Associação simples.
        // -------------------------------------------------------
        Professor p1 = new Professor("Vini");
        turma.associarProfessor(p1);


         
        // -------------------------------------------------------
        // EXIBINDO OS DADOS
        // Os métodos get* são GETTERS — permitem acessar atributos
        // privados de um objeto de fora da classe (encapsulamento).
        // -------------------------------------------------------
 
        System.out.println(turma.getProfessor()); // vini
        System.out.println(turma.getAlunos()); // [Aluno: Victor, Aluno: Christian, Aluno: Rafael]
        System.out.println();
        System.out.println(turma); // Aqui chamaos o método toString() da classe turma
    }
}