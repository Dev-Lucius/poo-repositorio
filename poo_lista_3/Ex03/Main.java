package Ex03;

public class Main {
    public static void main(String[] args) {
        
        Disciplina teorica = new DisciplinaTeorica("Fullstack - Formacao Teorica", 200, "Márcio Andrade", 7.2, 8.25);
        Disciplina pratica = new DisciplinaPratica("Desenvolvimento CRUD - React + MySQL", 150, "Maria Alice", 8.5, 9.0);
        Disciplina projeto = new DisciplinaProjeto("Projeto Integrador", 250, "Rodrigo Almeida", 7.6, 5.4, 10);

        System.out.println("Disciplina Teorica: " + teorica.calcularMediaFinal());
        System.out.println("Disciplina Prática: " + pratica.calcularMediaFinal());
        System.out.println("Disciplina Projeto: " + projeto.calcularMediaFinal());

        System.out.println();

        teorica.exibirSituacao();
        pratica.exibirSituacao();
        projeto.exibirSituacao();
    }
}
