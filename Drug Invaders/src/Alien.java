import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class Alien extends Rectangle {
    //static final (int, String ovs....) NAME(skriv med stort) = xxx;
    static final int DRUGS = 5;
    static final int WIDTH = 50;
    static final int HEIGHT = 90;
    static int x;
    static int y;
    static final int loop = 0;
    

    Alien(){ // brug til at lav en reset
        x = 0;
        y = 5;
    }
    public void move() {

    }

    public static void draw(Graphics g) {
        
        g.setColor(Color.red);
        for (int i = 0; i < GamePanel.NUM_ALIEN; i++){
        g.fillRect(((GamePanel.ALIEN_WIDTH * i) + (GamePanel.ALIEN_SPACE * 3)), y, WIDTH, HEIGHT);
        }
    }
}   
