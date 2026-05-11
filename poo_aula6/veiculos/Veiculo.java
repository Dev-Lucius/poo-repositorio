package veiculos;

public class Veiculo {

    private String tipo;
    private String marca;
    private String modelo;
    private int ano;
    // private String cor;

    public Veiculo(String tipo, String marca, String modelo, int ano) {
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public void exibirInfo() {
        System.out.println("Tipo: " + tipo);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
    }

}