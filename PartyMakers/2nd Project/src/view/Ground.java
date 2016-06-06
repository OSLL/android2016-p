package view;

import controller.MyKeyListener;
import controller.Observable;
import controller.Observer;
import model.Human;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

/**
 * Created by user on 6/3/2016.
 */
public class Ground extends JPanel implements Observer {
    Human human = null;
    private Image Raketa;
    private Image nlo;
    private int w;
    private int h;

    private void loadImage() {

        ImageIcon ii = new ImageIcon("C:\\Users\\user\\Desktop\\nlo.png");
        Raketa = ii.getImage();
    }

    private void loadGif() {

        ImageIcon ii = new ImageIcon("C:\\Users\\user\\Desktop\\1.gif");
        nlo = ii.getImage();


    }
    Ground(int w, int h){
        human = new Human(100, 100, 40); //создаем человека
        this.h = h;
        this.w = w;
        setPreferredSize(new Dimension(w,h)); //размер поля
        setBackground(Color.black);
        loadImage();
        loadGif();

        MyKeyListener mk = new MyKeyListener();
        mk.addObserver(this);

        setFocusable(true);
        requestFocusInWindow();

        addKeyListener(mk);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBG(g);
        drawHuman(g);
    }

    private void drawBG(Graphics g){
        g.drawImage(nlo, 0, 0, w, h, this);
        Toolkit.getDefaultToolkit().sync();
    }

    private void drawHuman(Graphics g){
        //картинку рисовать тут
        //g.fillOval(human.getX(), human.getY(), human.getSize(), human.getSize());
        g.drawImage(Raketa, human.getX(), human.getY(), this);
        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void update(KeyEvent e) {
        human.update(e);
        repaint();
    }
}
