package Ex01;

public class Main{
    public static void main(String[] args){
        
        Funcionario dev = new Desenvolvedor("Paulo Renato", "001", 5000);
        Funcionario vend = new Vendedor("Ana Silveira", "002", 3200, 6);

        dev.exibirResumo();
        System.out.println();

        vend.exibirResumo();
    }
}