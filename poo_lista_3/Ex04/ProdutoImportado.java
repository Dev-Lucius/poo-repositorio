package Ex04;

public class ProdutoImportado extends Produto{
    private double impostoImportacao;

    public ProdutoImportado(int id, String nome, double precoBase, double impostoImportacao){
        super(id, nome, precoBase);
        this.impostoImportacao = impostoImportacao;
    }

    @Override
    public double calcularPrecoFinal(){
        if(impostoImportacao <= 0){
            System.out.println("Serviço Livre de Taxas");
            return precoBase;
        }

        System.out.println("Produto Possui uma Taxa de Licença Referente à: " + impostoImportacao);
        return precoBase + impostoImportacao;
    }
}
