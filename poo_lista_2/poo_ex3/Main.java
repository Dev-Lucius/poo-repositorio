package poo_ex3;

public class Main {
    public static void main(String[] args) {
        Livro l = new Livro();
        Livro l1 = new Livro();
        Livro l2 = new Livro();

        l.adicionarLivro(new ItemLivro("Noitas Brancas", "Flódor Dostoievski", 110));
        l1.adicionarLivro(new ItemLivro("1984", "George Orwell", 102));
        l2.adicionarLivro(new ItemLivro("O Príncipe", "Nicolau Maquiavel", 164));
        
        System.out.println(l);
        System.out.println(l1);
        System.out.println(l2);
    }
}
