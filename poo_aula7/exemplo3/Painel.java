package exemplo3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class Painel extends JPanel implements MouseMotionListener{

    int x, y;

    public Painel() {
        this.addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(x-10, y-10, 20, 20);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'mouseDragged'");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
       System.out.println(e.getX() + ", " + e.getY());
       this.x = e.getX();
       this.y = e.getY();
       repaint();
    }



}
