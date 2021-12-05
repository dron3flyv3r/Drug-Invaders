import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

 
public class Score { 
 
    static int pliv;
    static int GH;
    static int GW;
    static int PlayerScore;
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
    PlayerScore = 0;
    }

    public static void draw(Graphics g) {
        int grayColor = 225;
        g.setColor(Color.WHITE);
        g.setFont(new Font("free ink",Font.BOLD,40));
        g.drawString("Score: " + PlayerScore, 50, 100);

        g.setColor(Color.WHITE);
        g.setFont(new Font("free ink",Font.BOLD,40));
        g.drawString("HP: " + pliv, 50, 50);
    }

    public static void gameOver(Graphics g) {
        //score
        g.setColor(Color.WHITE);
        g.setFont(new Font("free ink",Font.BOLD,40));
        g.drawString("Score: " + PlayerScore, 50, 50);
        
        //game over
        g.setColor(Color.RED);
        g.setFont(new Font("free ink",Font.BOLD,69));
        g.drawString("GAME OVER", GW/2 - 180, GH/2);
    }
}
