package Atv_01;

public class MaquinaAgua {
    private int agua;
    private int copos200;
    private int copos300;

    public MaquinaAgua(){
        this.agua = 0;
        this.copos200 = 0;
        this.copos300 = 0;
    }

    // Getter que retorna o Volume da água em mL
    public int agua(){
        return agua;
    }

    // Getter que retorna a quantidade de copos de 200mL
    public int copos200(){
        return copos200;
    }

    // Getter que retorna a quantidade de copos de 300mL
    public int copos300(){
        return copos300;
    }


    public void abastecerAgua(){
        if(this.agua == 20000) {
            System.out.println("Máquina Já está cheia");
            System.out.println("Água Disponível: " + agua + "mL");
            return;
        }
        System.out.println("Abastecido");
        this.agua = 20000;
        System.out.println("Água Disponível: " + agua + "mL");
    }

    public void abastecerCopo200(){
        if(this.copos200 == 100) System.out.println("Repositório de Copos já está cheio");
        System.out.println("Copos Abastecidos");
        this.copos200 = 100;
    }

    public void abastecerCopo300(){
        if(this.copos300 == 100) System.out.println("Repositório de Copos já está cheio");
        this.copos300 = 100;
    }

    public void servirCopo200(){
        if(agua >= 200 && copos200 >= 1){
            System.out.println("Servido");
            this.agua = this.agua - 200;
            this.copos200 = this.copos200 - 1;
            System.out.println("Copos de 200ml: " + copos200);
            System.out.println("Água Disponível: " + agua + "mL");
        } else {
            System.out.println("Não é possível servir copos no momento");
            System.out.println("Copos de 200ml: " + copos200);
            System.out.println("Água Disponível: " + agua + "mL");
        }
    }

    public void servirCopo300(){
        if(agua >= 300 && copos300 >= 1){
            System.out.println("Servido");
            this.agua = this.agua - 300;
            this.copos300 = this.copos300 - 1;
            System.out.println("Copos de 300ml: " + copos300);
            System.out.println("Água Disponível: " + agua + "mL");
        } else {
            System.out.println("Não tem água Suficiente para isso");
            System.out.println("Copos de 300ml: " + copos300);
            System.out.println("Água Disponível: " + agua + "mL");
        }
    }
}
