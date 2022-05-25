package Game.Graphic;

import javax.swing.*;
import java.awt.*;
// this class draws image for panel's background
public class Drawer extends JPanel {
    private final String path;

    public Drawer(String path) {
        this.path = path;
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Toolkit t = Toolkit.getDefaultToolkit();
        Image i = t.getImage("src\\Game\\Graphic\\Picture\\" + path + ".jpg");
        g2.drawImage(i, 0, 0, this);
    }
}
