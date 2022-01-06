import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Background {
    Background(){

    }

    public static void draw(Graphics g) {
        Image img = new ImageIcon("Bg.png").getImage();
        g.drawImage(img, 0, 0, null);
    }
}