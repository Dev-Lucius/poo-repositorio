package Ex08;

public class PlanoBasico extends PlanoAssinatura{
    
    private int limiteDisponivel;

    public PlanoBasico(String nome, String email, double mensalidadeBase, int limiteDisponivel){
        super(nome, email, mensalidadeBase);
        this.limiteDisponivel = limiteDisponivel;
    }

    @Override
    public double calcularMensalidadeFinal() {
        return getMensalidadeBase();
    }
    
    @Override
    public void listarBeneficios() {
        System.out.println("=== Plano Básico ===");
        System.out.println("- Acesso limitado");
        System.out.println("- Suporte comum");
        System.out.println("- Exibição de anúncios");
        System.out.println("- Limite de dispositivos: " + limiteDisponivel);
    }

}
