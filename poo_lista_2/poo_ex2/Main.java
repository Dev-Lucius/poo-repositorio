package poo_ex2;

public class Main {

    public static void main(String[] args) {

        Produto p = new Produto("Notebook", 3500);

        System.out.println(p.getNome());
        System.out.println(p.getPreco());

        p.setPreco(3200);

        System.out.println(p);
    }
}