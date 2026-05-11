package paint;

import java.util.List;
import java.awt.Graphics;

import javax.swing.JPanel;

// JPANEL - painel de desenho, onde podemos desenhar formas, imagens, etc.
public class Painel  extends JPanel {
    
    List<Forma> formas;

    Painel(List<Forma> formas) {
        this.formas = formas;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Forma forma : formas) {
            forma.desenhar(g);
        }
    }
    

}