import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{
    //spillet spille område
    static final int GAME_WIDTH = 950;
    static final int GAME_HEIGHT = 750;

    //player indstillinger
    static final int PLAYER_WIDTH = 90;
    static final int PLAYER_HEIGHT = 25;
    static final int PLAYER_SPEED = 5;
    static final int BARREL_WIDTH = 10;
    static final int BARREL_HEIGHT = 16;
    static final int PLAYERS_LIFE = 3;

    //alien indstillinger
    static final int ALIEN_WIDTH = 50;
    static final int ALIEN_HEIGHT = 50;
    static final int ALIEN_SPACE = 15;
    static final int NUM_ALIEN = (GAME_WIDTH-ALIEN_SPACE)/(ALIEN_WIDTH+ALIEN_SPACE);
    static final int NUM_ALIEN_LINES = 5;

    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
    Player player;
    Thread gameThread;
    Image image;
    Graphics graphics;


    GamePanel(){
        newPlayer();
        newAlien();
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);
       
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void newPlayer() { //reset player 
        player = new Player(GAME_HEIGHT, GAME_WIDTH, PLAYER_HEIGHT, PLAYER_WIDTH, PLAYER_SPEED, BARREL_WIDTH, BARREL_HEIGHT);
    }

    public void newAlien() {
        
    }

    public void draw(Graphics g) {

        Player.draw(g);
        Alien.draw(g);
        
    }

    public void checkCollision() {

        // checker om player er indefor spillet
        if (Player.x<=0) {
            Player.x=0;
        }
        if (Player.x>=GAME_WIDTH-PLAYER_WIDTH) {
            Player.x = GAME_WIDTH-PLAYER_WIDTH;
        }
    }

    public void move() {
        Player.move();
    }

    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
        
    }
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks; 
        double delta = 0;
        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            if (delta >= 1) {
                move();
                checkCollision();
                repaint();
                delta--;
            }
        }        
    }

    public class AL  extends KeyAdapter{

        public void keyPressed(KeyEvent e) {
            Player.keyPressed(e);
            Bullet.keyPressed(e);
        }
        public void keyReleased(KeyEvent e) {
            Player.keyReleased(e);
            Bullet.keyReleased(e);
        }
    }
}
