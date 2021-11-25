import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Score { 

    /* 
    indhold:
    scoren
    antal liv
    (tid) spillet
    lidt simple GUI
    */

    Score(){ //brug til at lave en reset

    }

    public void playerLiv(){

        int pLiv = 3 - skadet(0);

        if (pLiv == 0){

        }
    }

    public int skadet(int x){

        return x+1;

    }

    public void draw(Graphics g) {
        
    }




}
