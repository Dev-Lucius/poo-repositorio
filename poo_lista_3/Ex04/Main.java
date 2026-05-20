package Ex04;

public class Main {
    public static void main(String[] args) {

        Produto fisico      = new ProdutoFisico(1, "Teclado Mecânico", 300.0, 25.0);
        Produto digital     = new ProdutoDigital(2, "Pacote Adobe", 150.0, 40.0);
        Produto importado   = new ProdutoImportado(3, "Smartphone", 2000.0, 0.20);
        Produto invalido    = new ProdutoFisico(4, "Produto Fantasma", -50.0, 10.0);

        fisico.exibirResumo();
        System.out.println("");

        digital.exibirResumo();
        System.out.println("");

        importado.exibirResumo();
        System.out.println();
        
        invalido.exibirResumo();   // deve ser bloqueado
    }
}
