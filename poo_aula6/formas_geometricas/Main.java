package formas_geometricas;

import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        
        Quadrado quadrado = new Quadrado(5);
        System.out.println("Área do quadrado: " + quadrado.getArea());
        System.out.println("Perímetro do quadrado: " + quadrado.getPerimetro());
        
        Triangulo triangulo = new Triangulo(5);
        System.out.println("Área do triângulo: " + triangulo.getArea());
        System.out.println("Perímetro do triângulo: " + triangulo.getPerimetro());

        List<Forma> formas = new ArrayList<>();
        // dado uma lista de formas, calcula quanto de tinta eu preciso para cobrir
        formas.add(quadrado);
        formas.add(triangulo);
        formas.add(new Circulo(2f));
        formas.add(new Quadrado(10));
        // ...

        float total = 0;
        for (Forma forma : formas) {
            total += forma.getArea();
        }
        System.out.println("Total de tinta necessária: " + total);
    }    


}