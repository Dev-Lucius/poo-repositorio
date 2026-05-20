package Ex04;

public class ProdutoDigital extends Produto{
    private double taxaLicenca;

    public ProdutoDigital(int id, String nome, double precoBase, double taxaLicenca) {
        super(id, nome, precoBase);
        this.taxaLicenca = taxaLicenca;
    }

    @Override
    public double calcularPrecoFinal(){
        if(taxaLicenca <= 0){
            System.out.println("Serviço Livre de Taxas");
            return precoBase;
        }

        System.out.println("Produto Possui uma Taxa de Licença Referente à: " + taxaLicenca);
        return precoBase + taxaLicenca;
    }
}
