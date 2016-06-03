/**
 * Created by user on 6/3/2016.
 */

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JPanel{
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        Font font = new Font("Serif", Font.PLAIN, 96);
        g2.setFont(font);
        g2.drawString("Hey owo", 40, 120);
        int x=100;
        int y=100;
        int d=0;
        boolean t=true;
        for (int y1=0; y1<15;y1++) {
            for (int x1 = 0; x1 < 15; x1++) {
                g2.drawRect(75 + x * x1, 80 + y * y1, 100, 100);
                g2.fillRect(75 + x * x1, 80 + y * y1, 100, 100);
                d++;
                if (d%2==0){g2.setColor(Color.BLUE);} else g2.setColor(Color.RED);
            }
        }

    }
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.getContentPane().add(new Main());
        f.setSize(300, 200);
        f.setVisible(true);
    }
}



