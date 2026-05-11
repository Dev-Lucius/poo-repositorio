package poo_ex2;

public class Produto {
    private String nome;
    private int preco;

    public Produto(String nome, int preco){
        setNome(nome);
        setPreco(preco);
    }

    public String getNome(){
        return nome;
    }

    public int getPreco(){
        return preco;
    }

    public void setNome(String nome){
        if(nome == null || nome.trim().isEmpty()){
            System.out.println("Nome Inválido");
        } else {
            this.nome = nome;
        }
    }

    public void setPreco(int preco){
        if(preco <= 0){
            System.out.println("Preço Inválido");
        } else{
            this.preco = preco;
        }
    }

    // método toString
    @Override
    public String toString(){
        return "Produto{nome=" + nome + ", preco=" + preco + "}";
    }
}
