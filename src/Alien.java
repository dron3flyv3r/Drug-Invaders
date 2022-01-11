import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
public class Alien extends Rectangle {
	static ArrayList<Integer> arl1=new ArrayList<Integer>();
    static ArrayList<Integer> arl2=new ArrayList<Integer>();
    static ArrayList<Integer> arl3=new ArrayList<Integer>();

    static Random rn = new Random();
    
    static final int WIDTH = 50;
    static final int HEIGHT = 90;
    static int y;
    static int x1;
    static int x2;
    static int x3;
    static int speed;

    static final int loop = 0;
    

    Alien(){ 
        speed = 2;
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
        //change the speed direction when it hit the border
        if (arl1.size() > 0) {
            x1 = arl1.get(arl1.size()-1)+GamePanel.ALIEN_WIDTH;
            if(x1 == GamePanel.GAME_WIDTH){
                speed = -1;
            }
            if(arl1.get(0) == 0){
                speed = 1;
            }
        }
        if (arl2.size() > 0) {
            x2 = arl2.get(arl2.size()-1)+GamePanel.ALIEN_WIDTH;
            if(x2 == GamePanel.GAME_WIDTH){
                speed = -1;
            }
            if(arl2.get(0) == 0){
                speed = 1;
            }
        }
        if (arl3.size() > 0) {
            x3 = arl3.get(arl3.size()-1)+GamePanel.ALIEN_WIDTH;
            if(x3 == GamePanel.GAME_WIDTH){
                speed = -1;
            }
            if(arl3.get(0) == 0){
                speed = 1;
            }
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