package Ex03;

public class DisciplinaPratica extends Disciplina{

    private double notaPratica;
    private double relatorio;

    public DisciplinaPratica(String nome, int cargaHoraria, String professorResponsavel, double notaPratica, double relatorio){
        super(nome, cargaHoraria, professorResponsavel);
        this.notaPratica = notaPratica;
        this.relatorio = relatorio;
    }

    @Override
    public double calcularMediaFinal(){
        return (notaPratica + relatorio) / 2;
    }
}
