import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class Alien extends Rectangle {
    //static final (int, String ovs....) NAME(skriv med stort) = xxx;
    static final int DRUGS = 5;
    static final int WIDTH = 50;
    static final int HEIGHT = 50;
    static final int x = 50;
    static final int y = 50;

    Alien(){ // brug til at lav en reset

    }

    public static void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

}
