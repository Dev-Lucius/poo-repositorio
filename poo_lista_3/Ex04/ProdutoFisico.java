package Ex04;

public class ProdutoFisico extends Produto {
    private double taxaEnvio;

    public ProdutoFisico(int id, String nome, double precoBase, double taxaEnvio) {
        super(id, nome, precoBase);
        this.taxaEnvio = taxaEnvio;
    }

    @Override
    public double calcularPrecoFinal() {
        if(taxaEnvio <= 0){
            System.out.println("Produto Isento de Taxas");
            return precoBase;
        }
        System.out.println("Valor da Taxa: " + taxaEnvio);
        return precoBase + taxaEnvio;
    }
}