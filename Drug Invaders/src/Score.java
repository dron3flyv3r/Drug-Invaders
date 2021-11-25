import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

 
public class Score { 
 
    int pliv;
    int skade = 1;
    int score = 0;
    String hej = "hej med dig";
    /* 
    indhold:
    scoren
    antal liv
    (tid) spillet
    lidt simple GUI
    */

    Score(int PLAYERS_LIFE){ //brug til at lave en reset
    pliv = PLAYERS_LIFE;
    }

    public void playerLiv(){
        pliv = pliv - skade;
    }     

    public int skadet(){

        return skade+1;

    }

    public int score(){
        score = score + 100;
        return score;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawString("hejj", 300, 50);
    }
}
