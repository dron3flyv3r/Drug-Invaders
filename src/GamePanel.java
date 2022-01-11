import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{

    
    //her har vi nogle overall settings
	static final int GAME_WIDTH = 950;
    static final int GAME_HEIGHT = 750;
    static boolean GAMEOVER;
    int run;
    
    static final int PLAYER_WIDTH = 90;
    static final int PLAYER_HEIGHT = 39;
    static final int PLAYER_SPEED = 5;
    static final int BARREL_WIDTH = 10;
    static final int BARREL_HEIGHT = 16;
    static final int PLAYERS_LIFE = 3;

    static final int ALIEN_WIDTH = 40;
    static final int ALIEN_HEIGHT = 80;
    static final int ALIEN_SPACE = 30;
    static final int NUM_ALIEN = 2; //GAME_WIDTH/(ALIEN_WIDTH+ALIEN_SPACE);
    static final int NUM_ALIEN_LINES = 3;
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);

    //her er nogle dirigeringer for lidt forskallede
    static Player player;
    Thread gameThread;
    Image image;
    Graphics graphics;


    GamePanel(){ //den her function starter hele spillet
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
    
    public static void newGame() { //her bliver spillet reset
        GAMEOVER = false;
        AlienBullet.spawnRate = 60;
        Alien.arl1.clear();
        Alien.arl2.clear();
        Alien.arl3.clear();
        newPlayer();
        newAlien();
        newScore();
    }

    public static void newPlayer() { //reset player 
        new AlienBullet();
        new Bullet();
        AlienBullet.spawnRate = 60;
        player = new Player(GAME_HEIGHT, GAME_WIDTH, PLAYER_HEIGHT, PLAYER_WIDTH, PLAYER_SPEED, BARREL_WIDTH, BARREL_HEIGHT);
    }

    public static void newAlien() {
        new Alien();
    }

    public static void newScore() {
        new Score(PLAYERS_LIFE, GAME_HEIGHT, GAME_WIDTH);
    }

    public void draw(Graphics g) { //her bliver de forskellige sprites kaldt på de nødvendig draw funktioner som skal bruges 
            Background.draw(g);
        if (GAMEOVER == false) { // i denne if bliver default spiller genereret
            Player.draw(g);
            Bullet.draw(g);
            Alien.draw(g);
            Score.draw(g);
            AlienBullet.draw(g);
        }
        if (GAMEOVER == true) { // her bliver vores gamer over function lavet når spilleren taber
            Score.gameOver(g);  
        }
    }

    public void checkCollision() { // alt som er i inden for her, søgere for at registrere at de interaktive ting gør det når det er tid

        //her søgere for at spilleren ikke kan komme ud for spille arealet
        if (Player.x<=0) {
            Player.x=0;
        }
        if (Player.x>=GAME_WIDTH-PLAYER_WIDTH) {
            Player.x = GAME_WIDTH-PLAYER_WIDTH;
        }
    
        //her bliver der tjekket om et skud har ramt en alien
        for (int i = 0; i < Alien.arl1.size(); i++) {
            if (Bullet.x >= Alien.arl1.get(i) && Bullet.x <= Alien.arl1.get(i) + ALIEN_WIDTH && Bullet.y >= Alien.y && Bullet.y <= Alien.y + ALIEN_HEIGHT) {
                Bullet.setSpeed(0);
                Bullet.y = GAME_HEIGHT + 50;
                Alien.arl1.remove(Alien.arl1.get(i));
                if (AlienBullet.spawnRate > 2) { AlienBullet.spawnRate--; }
                Score.PlayerScore = Score.PlayerScore + 95;
                Score.tmpScore = Score.tmpScore + 95;
            }
        }
        //her bliver der tjekket om et skud har ramt en alien
        for (int i = 0; i < Alien.arl2.size(); i++) {
            if (Bullet.x >= Alien.arl2.get(i) && Bullet.x <= Alien.arl2.get(i) + ALIEN_WIDTH && Bullet.y >= (Alien.y+ALIEN_HEIGHT+ALIEN_SPACE) && Bullet.y <= (Alien.y+ALIEN_HEIGHT+ALIEN_SPACE) + ALIEN_HEIGHT) {
                Bullet.setSpeed(0);
                Bullet.y = GAME_HEIGHT + 50;
                Alien.arl2.remove(Alien.arl2.get(i));
                if (AlienBullet.spawnRate > 2) { AlienBullet.spawnRate--; }
                Score.PlayerScore = Score.PlayerScore + 40;
                Score.tmpScore = Score.tmpScore + 40;
            }
        }
        //her hvis en alien er blevet ramt gør
        for (int i = 0; i < Alien.arl3.size(); i++) {
            if (Bullet.x >= Alien.arl3.get(i) && Bullet.x <= Alien.arl3.get(i) + ALIEN_WIDTH && Bullet.y >= (Alien.y+ALIEN_HEIGHT*2+ALIEN_SPACE*2) && Bullet.y <= (Alien.y+ALIEN_HEIGHT*2+ALIEN_SPACE*2) + ALIEN_HEIGHT) {
                Bullet.setSpeed(0);
                Bullet.y = GAME_HEIGHT + 50;
                Alien.arl3.remove(Alien.arl3.get(i));
                if (AlienBullet.spawnRate > 2) { AlienBullet.spawnRate--; } 
                Score.PlayerScore = Score.PlayerScore + 15;
                Score.tmpScore = Score.tmpScore + 15;
                //Score.pliv = Score.pliv - 1; //for test only
            }
        }

        //her bliver det først/øverste/nederste skud tjekket om det er uden for spille arealet, og hvis det er så bliver det fjernet
        if (AlienBullet.x.size() >= 1) {
            if (AlienBullet.y.get(0) > GAME_HEIGHT) {
                AlienBullet.x.remove(0);
                AlienBullet.y.remove(0);
            }
            
        
        //her tjekker
        for (int i = 0; i < AlienBullet.y.size(); i++) {
            if (AlienBullet.x.get(i) > Player.x && AlienBullet.x.get(i) < Player.x + PLAYER_WIDTH && AlienBullet.y.get(i) > Player.y && AlienBullet.y.get(i) < Player.y + PLAYER_HEIGHT ) {
                AlienBullet.x.remove(i);
                AlienBullet.y.remove(i);
                Score.pLife = Score.pLife - 1;
            }
        }
    }
    //hvis du har flere end 1000 point, vil du få et liv til
    if (Score.tmpScore > 1000) {
        Score.pLife++;
        Score.tmpScore = 0;
    }

        if (Alien.arl1.size() + Alien.arl2.size() + Alien.arl3.size() == 0) {
            newAlien();
        }
        //hvis du har 0 liv, vil du tabe
        if (Score.pLife == 0) {
            GAMEOVER = true;
        }
    }

    //her bliver move function sendt til alt der skal bevæge sig
    public void move() {
        Player.move();
        Bullet.move();
        Alien.move();
        AlienBullet.move();
    }

    //her bliver alt der er blevet tegnet samme sat og hvis som et bilede
    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    //det her er game engine, som køre hele spillet
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
                delta--;
            }
        repaint();
        }        
    }

    //her bliver keyPressed sendt til de nødvendige steder som skal bruge dem
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
