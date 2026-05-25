package Ex08;

public class PlanoPremium extends PlanoAssinatura{

    // Desconto Não se Altera Após a Criação
    private final double descontoAnual;
    
    public PlanoPremium(String nome, String email, double mensalidadeBase, double descontoAnual){
        super(nome, email, mensalidadeBase);
        this.descontoAnual = descontoAnual;
    }

    public boolean temDescontoAnual(){
        if(descontoAnual < 0 || descontoAnual > 1){
            System.out.println("Desconto Inválido");
        }
        return descontoAnual > 0;
    }

    @Override
    public double calcularMensalidadeFinal() {
        double mensalidade = getMensalidadeBase();

        if (temDescontoAnual()) {
            return mensalidade - (mensalidade * descontoAnual);
        }

        return mensalidade;
    }

    @Override
    public void listarBeneficios() {
        System.out.println("Benefícios do Plano Básico:");
        System.out.println("- Acesso limitado");
        System.out.println("- Suporte básico");

        if(temDescontoAnual()){
            System.out.println("- Desconto Anual Aplicado");
        }
    }
}
