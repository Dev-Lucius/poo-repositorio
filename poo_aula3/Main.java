public class Main{
    public static void main(String[] args) {

        Nota n = new Nota();
        n.setValor(9);
        System.out.println(n.getValor()); // 9

        // Não podemos acessar diretamente o atributo pois ele é PRIVADO
        // Obs --> Atributo deve ser public
        // Nota n2 = new Nota();
        // n2.valor = -9;
        // System.out.println(n2.valor);

        Cor c1 = new Cor();
        
        c1.setR(255);
        System.out.println(c1); // 255, 0 , 0

        c1.setB(100);
        System.out.println(c1); // 255, 0 , 100

        c1.setG(100);
        System.out.println(c1); // 255, 200 , 100
    }
}