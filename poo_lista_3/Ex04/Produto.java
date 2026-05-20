package Ex04;

public abstract class Produto {

    protected int id;
    protected String nome;
    protected double precoBase;

    public Produto(int id, String nome, double precoBase) {
        this.id = id;
        this.nome = nome;
        this.precoBase = precoBase;
    }

    public boolean validarPreco(){
        if(precoBase <= 0){
            System.out.println("Erro: Preço base deve ser maior que 0");
            return false;
        }
        return true;
    }

    public abstract double calcularPrecoFinal();

    public void exibirResumo(){
        if(!validarPreco()){
            System.out.println("Resumo Bloqueado. Preço Inválido");
        }
        
        System.out.println("Resumo Completo");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Preço Base: " + precoBase);
        System.out.println("Preço Final: " + calcularPrecoFinal());
    }
}
