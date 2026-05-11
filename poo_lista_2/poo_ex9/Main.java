package poo_ex9;

public class Main {
    public static void main(String[] args) {
        
        Diretor d1 = new Diretor(1, "Christopher Nolan");

        Filme f1 = new Filme(1, "Oppenheimer");
        Filme f2 = new Filme(1, "Interstelar");
        Filme f3 = new Filme(1, "Batman: The Dark Knight");

        d1.adicionarFilme(f1);
        d1.adicionarFilme(f2);
        d1.adicionarFilme(f3);


        f1.consultarDiretor();
        f2.consultarDiretor();
        f3.consultarDiretor();
                
        d1.acessarDados();
        
        System.out.println(d1);
        System.out.println(f1);
    }
}
