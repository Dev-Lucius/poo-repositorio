package paint;

import java.awt.Color;
import java.awt.Graphics;

public class Quadrado extends Forma {
    
    public Quadrado(Color cor, int xi, int yi, int tamanho) {
        super(cor, xi, yi, xi + tamanho, yi + tamanho);
    }
    
    public void desenhar(Graphics g) {
        g.setColor(color);
        g.fillRect(xi, yi, xf - xi, yf - yi);
    }
}