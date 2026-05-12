package Ex03;

public class DisciplinaProjeto extends Disciplina{

    private double entregaParcial;
    private double entregaFinal;
    private double apresentacao;

    private static final double PESO_ENTREGA_PARCIAL = 2.0; 
    private static final double PESO_ENTREGA_FINAL = 3.0; 
    private static final double PESO_ENTREGA_APRESENTACAO = 5.0; 
    
    public DisciplinaProjeto(String nome, int cargaHoraria, String professorResponsavel, double entregaParcial, double entregaFinal, double apresentacao) {
        super(nome, cargaHoraria, professorResponsavel);
        this.entregaParcial = entregaParcial;
        this.entregaFinal = entregaFinal;
        this.apresentacao = apresentacao;
    }

    @Override
    public double calcularMediaFinal(){
        return (entregaParcial * PESO_ENTREGA_PARCIAL) + (entregaFinal * PESO_ENTREGA_FINAL) + (apresentacao * PESO_ENTREGA_APRESENTACAO) / 10.0;
    }    
}
