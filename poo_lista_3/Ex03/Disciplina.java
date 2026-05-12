package Ex03;

public abstract class Disciplina {

    protected String nome;
    protected int cargaHoraria;
    protected String professorResponsavel;

    public Disciplina(String nome, int cargaHoraria, String professorResponsavel) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.professorResponsavel = professorResponsavel;
    }

    // Cada Subclasse define sua fórmula
    public abstract double calcularMediaFinal();

    // Método Concreto
    public boolean verificarAprovacao(){
        if(calcularMediaFinal() > 6.0){
            System.out.println("Aprovado");
            return true;
        } else {
            System.out.println("Reprovado");
            return false;
        }
    }

    public String exibirSituacao(){
        if(!verificarAprovacao()){
            return "Reprovado";
        }
        return "Aprovado";
    }
}
