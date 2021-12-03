import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class Alien extends Rectangle {
    //static final (int, String ovs....) NAME(skriv med stort) = xxx;
    static final int DRUGS = 5;

    static ArrayList<Integer> arlTmpx=new ArrayList<Integer>();
    static ArrayList<Integer> arlTmpy=new ArrayList<Integer>();
    
    static final int WIDTH = 50;
    static final int HEIGHT = 90;
    static int x;
    static int y;

    static final int loop = 0;
    int antal=0;
    

    Alien(){ // brug til at lav en reset
        x = 0;
        y = 5;
        
        for(int i = 0; i < GamePanel.NUM_ALIEN; i++){
            int x = 67*i;
            arlTmpx.add(x);
        }
        System.out.println(arlTmpx.get(5));
        
        for(int i = 0; i < GamePanel.NUM_ALIEN_LINES; i++){
            int y = 107*i;
            arlTmpy.add(y);
        }
  
    }
    public void move() {

    }

    public static void draw(Graphics g) {
        
        g.setColor(Color.red);
        for(int j = 0; j < 14; j++){
        g.fillRect(arlTmpx.get(j), y, WIDTH, HEIGHT);
        
        }
    }
} 
