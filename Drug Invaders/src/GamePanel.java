import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable{
    //spillet spille område
    static final int GAME_WIDTH = 950;
    static final int GAME_HEIGHT = 750;
    static boolean GAMEOVER;

    //player indstillinger
    static final int PLAYER_WIDTH = 90;
    static final int PLAYER_HEIGHT = 39;
    static final int PLAYER_SPEED = 5;
    static final int BARREL_WIDTH = 10;
    static final int BARREL_HEIGHT = 16;
    static final int PLAYERS_LIFE = 3;

    //alien indstillinger
    static final int ALIEN_WIDTH = 40;
    static final int ALIEN_HEIGHT = 80;
    static final int ALIEN_SPACE = 30;
    static final int NUM_ALIEN = GAME_WIDTH/(ALIEN_WIDTH+ALIEN_SPACE);
    static final int NUM_ALIEN_LINES = 3;

    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
    static Player player;
    Thread gameThread;
    Image image;
    Graphics graphics;


    GamePanel(){
        
        GAMEOVER = false;
        newPlayer();
        newAlien();
        newScore();
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);
       
        gameThread = new Thread(this);
        gameThread.start();
    }

    public static void newGame() {
        GAMEOVER = false;
        Alien.arl1.clear();
        Alien.arl2.clear();
        Alien.arl3.clear();
        newPlayer();
        newAlien();
        newScore();
    }

    public static void newPlayer() { //reset player 
        new Bullet();
        player = new Player(GAME_HEIGHT, GAME_WIDTH, PLAYER_HEIGHT, PLAYER_WIDTH, PLAYER_SPEED, BARREL_WIDTH, BARREL_HEIGHT);
    }

    public static void newAlien() {
        new Alien();
    }

    public static void newScore() {
        new Score(PLAYERS_LIFE, GAME_HEIGHT, GAME_WIDTH);
    }

    public void draw(Graphics g) {
        if (GAMEOVER == false) {
            Player.draw(g);
            Bullet.draw(g);
            Alien.draw(g);
            Score.draw(g);
        }
        if (GAMEOVER == true) {
            Score.gameOver(g);  
        }     
    }

    public void checkCollision() {

        // checker om player er indefor spillet
        if (Player.x<=0) {
            Player.x=0;
        }
        if (Player.x>=GAME_WIDTH-PLAYER_WIDTH) {
            Player.x = GAME_WIDTH-PLAYER_WIDTH;
        }

        if (Bullet.y<= 0) {
            Bullet.setSpeed(0);
            Bullet.y = GAME_HEIGHT + 50;
        }
    
        // checker om Bullet hit Alien 
        for (int i = 0; i < Alien.arl1.size(); i++) {
            if (Bullet.x >= Alien.arl1.get(i) && Bullet.x <= Alien.arl1.get(i) + ALIEN_WIDTH && Bullet.y >= Alien.y && Bullet.y <= Alien.y + ALIEN_HEIGHT) {
                Bullet.setSpeed(0);
                Bullet.y = GAME_HEIGHT + 50;
                Alien.arl1.remove(Alien.arl1.get(i));
                Score.PlayerScore = Score.PlayerScore + 105;
            }
        }
        // checker om Bullet hit Alien 
        for (int i = 0; i < Alien.arl2.size(); i++) {
            if (Bullet.x >= Alien.arl2.get(i) && Bullet.x <= Alien.arl2.get(i) + ALIEN_WIDTH && Bullet.y >= (Alien.y+ALIEN_HEIGHT+ALIEN_SPACE) && Bullet.y <= (Alien.y+ALIEN_HEIGHT+ALIEN_SPACE) + ALIEN_HEIGHT) {
                Bullet.setSpeed(0);
                Bullet.y = GAME_HEIGHT + 50;
                Alien.arl2.remove(Alien.arl2.get(i));
                Score.PlayerScore = Score.PlayerScore + 95;
            }
        }
        // checker om Bullet hit Alien 
        for (int i = 0; i < Alien.arl3.size(); i++) {
            if (Bullet.x >= Alien.arl3.get(i) && Bullet.x <= Alien.arl3.get(i) + ALIEN_WIDTH && Bullet.y >= (Alien.y+ALIEN_HEIGHT*2+ALIEN_SPACE*2) && Bullet.y <= (Alien.y+ALIEN_HEIGHT*2+ALIEN_SPACE*2) + ALIEN_HEIGHT) {
                Bullet.setSpeed(0);
                Bullet.y = GAME_HEIGHT + 50;
                Alien.arl3.remove(Alien.arl3.get(i)); 
                Score.PlayerScore = Score.PlayerScore + 85;
                //Score.pliv = Score.pliv - 1; //for test only
            }
        }

        if (Alien.arl1.size() == 0 && Alien.arl2.size() == 0 && Alien.arl3.size() == 0) {
            newAlien();
        }
        if (Score.pliv == 0) {
            GAMEOVER = true;
        }
    }

    public void move() {
        Player.move();
        Bullet.move();
        Alien.move();

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
        }
    }
}
