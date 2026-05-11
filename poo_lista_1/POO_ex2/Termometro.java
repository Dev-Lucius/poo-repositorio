package POO_ex2;

public class Termometro {
    private double temperatura = 0.0; // em celsius
    private double fahrenheit = 0.0; // em fahrenheit

    // Método Aumentar Temperatura
    public void aumentar(double delta){
        if(delta <= 0.0){
            System.out.println("Apenas Deltas Positivos");
        } else{
            temperatura = temperatura + delta;
        }
    }

    // Método Diminuir Temperatura
    public void diminuir(double delta){
        if(delta <= 0.0){
            System.out.println("Apenas Deltas Positivos");;
        } else {
            temperatura = temperatura - delta;
        }
    }

    // Métodos getters
    public double emCelsius(){
        return temperatura;
    }

    public double emFahrenheit(){
        fahrenheit = (temperatura * 9/5) + 32;
        return fahrenheit;   
    }
}
