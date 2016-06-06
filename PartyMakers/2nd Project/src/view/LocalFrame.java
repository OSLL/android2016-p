package view;

import controller.Observer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import controller.MyKeyListener;
import controller.Observable;
import model.Human;

/**
 * Created by user on 6/3/2016.
 */
public class LocalFrame extends JFrame {

    public static int P_WIDTH = 2000;
    public static int P_HEIGHT = 1000;
    public static JPanel panel;
    public static JButton button1;
    public static BackGround b;


    private JLayeredPane lpane = new JLayeredPane();
    private JPanel panelBlue = new JPanel();
    private JPanel panelGreen = new JPanel();

        public LocalFrame(String name) {
            super(name);


            button1 = new JButton("Играть!");
            button1.setBounds(0,0,P_WIDTH/5,P_HEIGHT/5);
            button1.setActionCommand("ЭЭ");
            button1.setOpaque(true);
            button1.setFont(new Font("Arial", Font.PLAIN, 40));
            b = new BackGround(P_WIDTH,P_HEIGHT);
            b.setOpaque(true);


            setPreferredSize(new Dimension(P_WIDTH, P_HEIGHT));
            setLayout(new BorderLayout());
            add(lpane, BorderLayout.CENTER);
            lpane.setBounds(0, 0, P_WIDTH, P_HEIGHT);
            panelBlue.setBounds(0, 0, P_WIDTH, P_HEIGHT);
            panelBlue.setOpaque(true);
            panelBlue.add(b);
            //panelGreen.setBackground(Color.GREEN);
            panelGreen.setBounds((P_WIDTH-(P_WIDTH/5))/2, (P_HEIGHT-(P_HEIGHT/5))/2, P_WIDTH/5, P_HEIGHT/5);
            panelGreen.setLayout(new BorderLayout());
            panelGreen.add(button1);
            panelGreen.setOpaque(true);
            lpane.add(panelBlue, new Integer(0), 0);
            lpane.add(panelGreen, new Integer(1), 0);
            pack();
            setVisible(true);

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            button1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    getContentPane().add(new Ground(P_WIDTH,P_HEIGHT));
                    LocalFrame.button1.setVisible(false);
                    LocalFrame.b.setVisible(false);
                    pack();
                }
            });
            Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (int) ((dimension.getWidth() - getWidth()) / 2);
            int y = (int) ((dimension.getHeight() - getHeight()) / 2);
            setLocation(x, y);
        }

}
