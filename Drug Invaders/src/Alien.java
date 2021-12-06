import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class Alien extends Rectangle {
    //static final (int, String ovs....) NAME(skriv med stort) = xxx;
    static ArrayList<Integer> arl1=new ArrayList<Integer>();
    static ArrayList<Integer> arl2=new ArrayList<Integer>();
    static ArrayList<Integer> arl3=new ArrayList<Integer>();
    
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
            arl1.add(x);
            arl2.add(x);
            arl3.add(x);
            }
    }
    public static void move() {
        x = arl1.get(arl1.size()-1)+GamePanel.ALIEN_WIDTH;
        //change the speed direction when it hit the border
        if(x == GamePanel.GAME_WIDTH){
            speed = -1;
        }
        if(arl1.get(0) == 0){
            speed = 1;
        }

      
    for(int i = 0; i < arl1.size(); i++){
        arl1.set(i, arl1.get(i)+speed);
            }
    for(int i = 0; i < arl2.size(); i++){
        arl2.set(i, arl2.get(i)+speed);
            }
    for(int i = 0; i < arl3.size(); i++){
        arl3.set(i, arl3.get(i)+speed);
            }
    }

    public static void draw(Graphics g) {
        Image img = new ImageIcon("alien1.png").getImage();
        Image img2 = new ImageIcon("alien2.png").getImage();
        Image img3 = new ImageIcon("alien3.png").getImage();

            g.setColor(Color.red);
        for(int j = 0; j < arl1.size(); j++){
            g.drawImage(img, arl1.get(j), y, null);
        }
        for(int j = 0; j < arl2.size(); j++){
            g.drawImage(img2, arl2.get(j), y+GamePanel.ALIEN_HEIGHT+GamePanel.ALIEN_SPACE, null);
        }
        for(int j = 0; j < arl3.size(); j++){
            g.drawImage(img3, arl3.get(j), y+GamePanel.ALIEN_HEIGHT*2+GamePanel.ALIEN_SPACE*2, null);
        }
    }
} 
