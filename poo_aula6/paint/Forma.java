package paint;

import java.awt.*;

abstract class Forma {
    
    Color color;
    
    //ponto inicial
    int xi, yi;

    // ponto final
    int xf, yf;

    public Forma(Color color, int xi, int yi, int xf, int yf) {
        this.color = color;
        this.xi = xi;
        this.yi = yi;
        this.xf = xf;
        this.yf = yf;
    }

    abstract public void desenhar(Graphics g);
}