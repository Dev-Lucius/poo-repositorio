package clinico.model.veiculo;

// Criação da Classe Veiculo
// abstract -> veiculo representa um conceito, não um objeto
// usado para implementar outros tipos de veículos
// Usamos para implementar o Polimorfismo
public abstract class Veiculo {

    private final String placa;
    private final String modelo;
    private final double capacidadeMaximaKg;
    private boolean disponivel;

    public Veiculo(String placa, String modelo, double capacidadeMaximaKg) {
        this.placa = placa;
        this.modelo = modelo;
        this.capacidadeMaximaKg = capacidadeMaximaKg;
        this.disponivel = true;
    }

    public String getPlaca() { return placa; }
    public String getModelo() { return modelo; }
    public double getCapacidadeMaximaKg() { return capacidadeMaximaKg; }
    public boolean isDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }

    public boolean suportaPeso(double pesoKg) {
        return pesoKg <= capacidadeMaximaKg;
    }

    @Override
    public String toString() {
        String disponibilidade;
        if(disponivel){
            disponibilidade = "Disponivel";
        } else {
            disponibilidade = "Indisponivel";
        }
        return modelo + "[" + placa + "] - " + disponibilidade;
    }
}

