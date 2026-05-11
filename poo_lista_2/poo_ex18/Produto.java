package poo_ex18;

public class Produto {

    private int id;
    private String nome;
    private double preco;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public Produto(int id, String nome, double preco){
        setId(id);
        setNome(nome);
        setPreco(preco);
    }

    public void setId(int id){
        if(id <= 0){
            System.out.println("ID Inválida");
        } else{
            this.id = id;
        }
    }

    public void setNome(String nome){
        if(nome.trim().isEmpty() || nome == null){
            System.out.println("Nome Inválido");
        } else {
            this.nome = nome;
        }
    }

    public void setPreco(double preco){
        if(preco <= 0){
            System.out.println("Preço Inválido");
        } else {
            this.preco = preco;
        }
    }

    @Override
    public String toString(){
        return  "\nProduto: " + nome + 
                "\nId: " + id + 
                "\nPreço: " + String.format("%.2f", preco);
    }
}
