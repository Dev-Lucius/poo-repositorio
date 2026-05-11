package poo_ex3;

import java.util.ArrayList;
import java.util.List;

public class Livro {
    // Criação da Lista de Livros
    // Atributo privado do tipo List<ItemLivro> chamado livros, que é uma lista de objetos do tipo ItemLivro.
    // Logo..
    /*
    Livro
        ├── Titulo
        ├── Autor
        └── NumPaginas
    */
   private List<ItemLivro> livros;

   public Livro(){
    livros = new ArrayList<>();
   }

   public void adicionarLivro(ItemLivro item){
    if(item == null){
        System.out.println("Este item não pode ser nulo");
    }
    livros.add(item);
   }

   public void listarLivros(){
    if(livros.isEmpty()){
        System.out.println("Nenhum Livro Cadastrado");
    }
    // forEach
    // Para cada ItemLivro dentro da lista livros, faça algo
    // livro é apenas uma variável temporária
    for(ItemLivro livro : livros){
        System.out.println(livro);
    }
   }

   @Override
    public String toString() {
        return "Livro{" + livros + "}";
    }
}
