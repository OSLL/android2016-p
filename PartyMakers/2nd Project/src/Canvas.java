import javax.swing.*;
import java.awt.*;

/**
 * Created by user on 6/3/2016.
 */
public class Canvas extends JComponent{
    public void paint(Graphics g){

        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setPaint(Color.GREEN);
        g2d.drawRect(getX(), getY(), 100, 100);
        super.repaint();
    }
}
