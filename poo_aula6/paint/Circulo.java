package paint;

import java.awt.Color;
import java.awt.Graphics;

public class Circulo extends Forma {
    
    private int raio;

    public Circulo(int xi, int yi, int raio) {
        super(Color.YELLOW, xi - raio, yi - raio, xi + raio, yi + raio);
        this.raio = raio;
    }
    
    public void desenhar(Graphics g) {
        g.setColor(color);
        // g.fillOval(xi - raio, yi - raio, xi + raio, yi + raio);
        g.fillOval(xi, yi, xf-xi, yf-yi);
    }
}