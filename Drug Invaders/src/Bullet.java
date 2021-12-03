import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Bullet {

static int bVelocity;
static int Speed = 5;
static int y;
static int x;
static int width = 5;
static int height = 7;

Bullet(){
    
}

 public static void setSpeed(int speed) {
    bVelocity = speed;
} 
    
public static void move() {
    y = y + bVelocity;
}


public static void draw(Graphics g) {
    g.setColor(Color.WHITE);
    g.fillRect(x, y, width, height);
}

public static void newBullet(Graphics g) {
    g.setColor(Color.WHITE);
    g.fillRect(x, y, width, height);
}

public static void keyPressed(KeyEvent e) {
    if (e.getKeyCode()==KeyEvent.VK_W) {
        x = (Player.x + (Player.WIDTH/2));
        y = GamePanel.GAME_HEIGHT;
        setSpeed(Speed);
        newBullet();
    }
}
public static void keyReleased(KeyEvent e) {
    
    }
}