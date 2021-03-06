import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.ImageIcon;

public class Player{

     static int SPEED;
     static int B_WIDTH;
     static int B_HEIGHT;
     static int HEIGHT;
     static int WIDTH; 
     static int xVelocity;
     static int x;
     static int y;

     static Random rn = new Random();


    Player(int GAME_HEIGHT,int GAME_WIDTH, int PLAYER_HEIGHT, int PLAYER_WIDTH, int PLAYER_SPEED, int BARREL_WIDTH, int BARREL_HEIGHT){
        HEIGHT = PLAYER_HEIGHT;
        WIDTH = PLAYER_WIDTH;
        B_WIDTH = BARREL_WIDTH;
        B_HEIGHT = BARREL_HEIGHT;
        SPEED = PLAYER_SPEED;
        y = GAME_HEIGHT - PLAYER_HEIGHT - 5;
        x = (GAME_WIDTH/2)-(WIDTH/2);
    }

    public static void keyPressed(KeyEvent e) {
        //A og D
        if (e.getKeyCode() == KeyEvent.VK_A){
            setXDirection(-SPEED);
            move();
        }
        if (e.getKeyCode() == KeyEvent.VK_D){
            setXDirection(SPEED);
            move();
        }

        //piletaster
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            setXDirection(-SPEED);
            move();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            setXDirection(SPEED);
            move();
        }
    }

    public static void keyReleased(KeyEvent e) {
        //A og D
        if (e.getKeyCode() == KeyEvent.VK_A){
            setXDirection(0);
            move();
        }
        if (e.getKeyCode() == KeyEvent.VK_D){
            setXDirection(0);
            move();
        }
         //piletaster
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            setXDirection(0);
            move();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            setXDirection(0);
            move();
        } 
        if (GamePanel.GAMEOVER == true && e.getKeyCode() == KeyEvent.VK_SPACE) {
            GamePanel.newGame();
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {

            int AlienNumber = rn.nextInt(Alien.arl1.size() + 1);
            AlienBullet.x.add(Alien.arl1.get(AlienNumber-1) + GamePanel.ALIEN_WIDTH/2);
            AlienBullet.y.add(GamePanel.ALIEN_HEIGHT + Alien.y);
        }
    }

    public static void setXDirection(int xDirection) {
        xVelocity = xDirection;
    }

    public static void move(){
        x = x + xVelocity; 
    }

    public static void draw(Graphics g){
        Image img = new ImageIcon("player.png").getImage();
        g.drawImage(img, x, y, null);
    }   
}
