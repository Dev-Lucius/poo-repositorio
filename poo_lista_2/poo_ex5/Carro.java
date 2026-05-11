package poo_ex5;

public class Carro {
    private String marca;
    private String modelo;
    private int ano;

    

    public void setMarca(String marca) {
        if(marca == null || marca.trim().isEmpty()){
            throw new IllegalArgumentException("Dado Inválido");
        } else {
            this.marca = marca;
        }
    }

    public void setModelo(String modelo) {
        if(modelo == null || modelo.trim().isEmpty()){
            throw new IllegalArgumentException("Dado Inválido");
        } else {
            this.modelo = modelo;
        }
    }

    public void setAno(int ano) {
        if(ano <= 0){
            throw new IllegalArgumentException("Dado Inválido");
        } else {
            this.ano = ano;
        }
    }

    // Um objeto do tipo Motor dentro da Classe Carro
    // Trata-se de uma composição!
    Motor motor; // Carro possui motor

    // Construtor de carro
    public Carro(String marca, String modelo, int ano, Motor motor){
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;

        // Associamos o Motor ao Carro
        // Isto é, estamos dizendo qual motor peretence a este carro
        this.motor = motor;
    }

    public void exibirDados(){
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);

        System.out.println("\nDados do Motor:");
        // Aqui, podem,os chamar o método do objeto motor
        // Isso mostra que um objeto pode usar métodos de outros objetos
        motor.exibirDados();
    }
}
