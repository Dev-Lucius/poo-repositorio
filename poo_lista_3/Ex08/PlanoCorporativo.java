package Ex08;

public class PlanoCorporativo extends PlanoAssinatura{
    
    private int assinaturas;
    private final double TAXA_POR_ASSINATURA = 10.0;

    public PlanoCorporativo(String nome, String email, double mensalidadeBase, int assinaturas){
        super(nome, email, mensalidadeBase);
        this.assinaturas = assinaturas;
    }

    @Override
    public double calcularMensalidadeFinal() {
        double mensalidade = getMensalidadeBase();

        if(assinaturas > 1){
            mensalidade = getMensalidadeBase() + ((assinaturas - 1) * TAXA_POR_ASSINATURA);
        }
        return mensalidade;
    }

    @Override
    public void listarBeneficios() {
        System.out.println("- Múltiplas Assinaturas");
        System.out.println("- Sem anúncios");
        System.out.println("- Qualidade máxima");
        System.out.println("- Downloads offline");
        System.out.println("- Suporte prioritário");
        System.out.println("- Acesso Antecipado a Conteúdos Exclusivos");
    }
}
