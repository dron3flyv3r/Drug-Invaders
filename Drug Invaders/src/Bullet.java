import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Bullet {

int bVelocity = 5;
int y = 1;
int x = 1;
int width = 5;
int height = 7;

Bullet(){

}
    
public void move() {
    y = y + bVelocity;
}


public void draw(Graphics g) {
    g.setColor(new Color(0,150,0));
    g.fillRect(x, y, width, height);
}

public static void keyPressed(KeyEvent e) {
    if (e.getKeyCode()==KeyEvent.VK_SPACE) {
        
    }
}
public static void keyReleased(KeyEvent e) {
    
}
}