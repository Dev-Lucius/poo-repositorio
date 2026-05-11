package veiculos;

// a moto É UM veiculo
// nao é uma relacao de TEM-UM
public class Moto extends Veiculo {

    private String guidao;

    public Moto(String marca, String modelo, int ano, String guidao) {
        // chama o construtor da classe pai
        super("Moto", marca, modelo, ano);
        this.guidao = guidao;
    }
   
    public void darGrau() {
        System.out.println("A moto " + getMarca() + " " + getModelo() + " está dando grau!");
    }

    // sobrescreve o método exibirInfo da classe Veiculo para incluir informações específicas da Moto
    @Override
    public void exibirInfo() {
        // super refere-se a classe pai
        // System.out.println("Tipo: Moto");
        // System.out.println("Marca: " + getMarca());
        super.exibirInfo();
        System.out.println("Guidao: " + guidao);
    }
}