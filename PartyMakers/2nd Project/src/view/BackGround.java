package view;

import controller.MyKeyListener;
import controller.Observer;
import model.Human;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by user on 6/6/2016.
 */
public class BackGround extends JPanel {
    private Image BG;
    private int h;
    private int w;

    private void loadGif() {

        ImageIcon ii = new ImageIcon("C:\\Users\\user\\Desktop\\2.gif");
        BG = ii.getImage();
    }

    private void drawBG(Graphics g){
        g.drawImage(BG, 0,0,w,h,this);
        Toolkit.getDefaultToolkit().sync();
    }

    BackGround (int w, int h){
        this.h = h;
        this.w = w;
        //human = new Human(100, 100, 40); //создаем человека
        setPreferredSize(new Dimension(w,h)); //размер поля
        setBackground(Color.black);;
        loadGif();

        MyKeyListener mk = new MyKeyListener();
        //mk.addObserver(this);

        setFocusable(true);
        requestFocusInWindow();

        addKeyListener(mk);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBG(g);
    }

    /*@Override
    public void update(KeyEvent e) {
        .update(e);
        repaint();
    }*/
}
