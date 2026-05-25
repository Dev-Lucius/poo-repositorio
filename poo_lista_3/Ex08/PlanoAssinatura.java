package Ex08;

public abstract class PlanoAssinatura{

    protected String nome;
    protected String email;
    protected double mensalidadeBase;

    public double getMensalidadeBase(){
        return mensalidadeBase;
    }

    public PlanoAssinatura(String nome, String email, double mensalidadeBase){
        this.nome = nome;
        this.email = email;
        this.mensalidadeBase = mensalidadeBase;
    }

    public abstract double calcularMensalidadeFinal();
    public abstract void listarBeneficios();

    public String exibirPlano(){
        return "Plano: " + nome + 
               "\nEmail: " + email +
               "\nMensalidade: " + calcularMensalidadeFinal();
    }
}