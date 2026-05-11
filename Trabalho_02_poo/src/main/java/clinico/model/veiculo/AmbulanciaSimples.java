package clinico.model.veiculo;

// Extends -> estabelece que a AmbulanciaSimples é um veículo (Herança)
// Ou seja, a AmbulanciaSimples herda todos os atributos de veículo
public class AmbulanciaSimples extends Veiculo {

    private boolean possuiMaca;
    private boolean possuiOxigenio;

    public AmbulanciaSimples(String placa, String modelo, double capacidadeMaximaKg,
                              boolean possuiMaca, boolean possuiOxigenio) {
        super(placa, modelo, capacidadeMaximaKg);
        this.possuiMaca = possuiMaca;
        this.possuiOxigenio = possuiOxigenio;
    }

    public boolean isPossuiMaca() { return possuiMaca; }
    public boolean isPossuiOxigenio() { return possuiOxigenio; }
}
