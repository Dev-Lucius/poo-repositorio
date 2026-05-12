package Ex03;

public class DisciplinaTeorica extends Disciplina{
    private double prova1;
    private double prova2;

    public DisciplinaTeorica(String nome, int cargaHoraria, String professorResponsavel, double prova1, double prova2){
        super(nome, cargaHoraria, professorResponsavel);
        this.prova1 = prova1;
        this.prova2 = prova2;
    }

    @Override
    public double calcularMediaFinal(){
        return (prova1 + prova2) / 2;
    }
}
