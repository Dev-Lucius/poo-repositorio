package poo_ex13;

public class Item {

    private String nome;
    private double preco;

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public Item(String nome, double preco){
        setNome(nome);
        setPreco(preco);
    }

    public void setNome(String nome){
        if(nome == null || nome.trim().isEmpty()){
            System.out.println("Nome Inválido");
        } else {
            this.nome = nome;
        }
    }

    public void setPreco(double preco){
        if(preco <= 0) {
            System.out.println("Preço Inválido");
        } else {
            this.preco = preco;
        }
    }

    @Override
    public String toString(){
        return nome + " - R$ " + String.format("%.2f", preco);
    }
}
