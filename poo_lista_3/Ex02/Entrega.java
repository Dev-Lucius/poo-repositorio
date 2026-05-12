package Ex02;

public abstract class Entrega {
    protected String destinatario;
    protected double peso;
    protected double valorDeclarado;

    public Entrega(String destinatario, double peso, double valorDeclarado) {
        this.destinatario = destinatario;
        this.peso = peso;
        this.valorDeclarado = valorDeclarado;
    }


    public boolean validarDados(){
        if(peso <= 0){
            System.out.println("Peso Inválido");
            return false;
        }

        if(valorDeclarado <= 0){
            System.out.println("Valor Inválido");
            return false;
        }

        if(destinatario == null){
            System.out.println("Entrega sem Destinário");
            return false;
        }
        return true;
    }

    // Cada Subclasse define sua fórmula
    public abstract double calcularFrete();

    // Método concreto
    public void gerarResumoEntrega(){
        if(!validarDados()){
            System.out.println("Dados Inválidos para esta entrega");
            return;
        }
        
        System.out.println("Resumo Entrega");
        System.out.println("Destinatário:    " + destinatario);
        System.out.println("Peso:            " + peso + " kg");
        System.out.println("Valor declarado: R$ " + valorDeclarado);
        System.out.println("Frete:           R$ " + calcularFrete());
    }
}

