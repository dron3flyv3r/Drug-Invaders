import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

 
public class Score { 
 
    static int pliv;
    static int GH;
    static int GW;
    /* 
    indhold:
    scoren
    antal liv
    (tid) spillet
    lidt simple GUI
    */

    Score(int PLAYERS_LIFE, int GAME_HEIGHT, int GAME_WIDTH){ //brug til at lave en reset
    pliv = PLAYERS_LIFE;
    GH = GAME_HEIGHT;
    GW = GAME_WIDTH;
    }
    /*
    //mangler alien.y
    public void playerLiv(){
        if (Alien.y > GH){
            pliv--;
        }
        
        if (pliv==0){
            gameOver(g);
        }
    }     
    */

    public void score(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("free ink",Font.BOLD,40));
        g.drawString("Score: ?", GW+50, GH+100);
    }

    public void HP(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("free ink",Font.BOLD,40));
        g.drawString("HP: ?" + pliv, GW+50, GH+50);
    }

    public void gameOver(Graphics g) {
        //score
        g.setColor(Color.WHITE);
        g.setFont(new Font("free ink",Font.BOLD,40));
        g.drawString("Score: ?", GW+50, GH+50);
        
        //game over
        g.setColor(Color.RED);
        g.setFont(new Font("free ink",Font.BOLD,69));
        g.drawString("GAME OVER", GW/2, GH/2);
    }
}
