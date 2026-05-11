public class Cor {
    
    private int r;
    private int g;
    private int b;

    /**
     * Como o OBJ deve nasce
     * Construtor padrão --> public, sem parametros
     * Quando temos apenas o construtor padrão e ele "não faz nada", podemos definir seu estado inicial dá seguinte forma
     */
    public Cor(){
        this.r = 0;
        this.g = 0;
        this.b = 0;
    }

    // Método Privado --> É usado para reutilizar certas Lógicas
    // Trata-se de um Utilitário da própria Classe
    private int getValorCorrigido(int value){
        if(value < 0){
            value = 0;
        } else if(value > 255){
            value = 255;
        }
        return value;
    }


    // Java Doc --> barra(/) + asterisco(*) + asteriscio(*) + enter(Enter)

    /**
     * 
     * @param v int entre 0 255
     */
    public void setR(int value){
        r = getValorCorrigido(value);

        // if(value < 0){
        //     value = 0;
        // } else if(value > 255){
        //     value = 255;
        // }
        // // this não foi usado pois os nomes das variáveis e atributos eram diferentes !
        // r = value; 
    }

    public void setG(int value){
        g = getValorCorrigido(value);

        // if(value < 0){
        //     value = 0;
        // } else if(value > 255){
        //     value = 255;
        // }
        // g = value; 
    }

    public void setB(int value){
        b = getValorCorrigido(value);

        // if(value < 0){
        //     value = 0;
        // } else if(value > 255){
        //     value = 255;
        // }
        // b = value; 
    }

    // Gerando os Getters
    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

    // @Override --> Indicativo de Sobreescrita
    // Toda classe em Java herda de Object e este Método existe lá
    // Portanto, estamos alterando o comportamento do método
    @Override
    public String toString(){
        return "RGB" + "(" + r + "," + g + "," + b + ")";
    }
}
