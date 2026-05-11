package poo_ex5;

public class Main {
    public static void main(String[] args) {
        Motor motor = new Motor("Gasolina", 150, 2000);

        Carro carro = new Carro(
            "Toyota", 
            "Corolla", 
            2022, 
            motor
        );
        
        carro.exibirDados();
    }    
}
