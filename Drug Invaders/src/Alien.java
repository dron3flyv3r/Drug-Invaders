import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class Alien extends Rectangle {
    //static final (int, String ovs....) NAME(skriv med stort) = xxx;
    static ArrayList<Integer> arlTmpX=new ArrayList<Integer>();
    
    static final int WIDTH = 50;
    static final int HEIGHT = 90;
    static int x;
    static int y;
    static int speed;

    static final int loop = 0;
    

    Alien(){ // brug til at lav en reset
        speed = 1;
        x = 0;
        y = 10;
        for(int i = 0; i < GamePanel.NUM_ALIEN; i++){
            int x = GamePanel.ALIEN_WIDTH*i+GamePanel.ALIEN_SPACE*i;
            arlTmpX.add(x);
            }
        System.out.println(arlTmpX.get(5));
    }
    public static void move() {
        
    for(int i = 0; i < arlTmpX.size(); i++){
        arlTmpX.set(i, arlTmpX.get(i)+speed);
            }
    }

    public static void draw(Graphics g) {

            g.setColor(Color.red);
        for(int j = 0; j < arlTmpX.size(); j++){
            g.fillRect(arlTmpX.get(j), y, GamePanel.ALIEN_WIDTH, GamePanel.ALIEN_HEIGHT);
        }
    }
} 
