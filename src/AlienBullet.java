import java.awt.*;
import java.util.*;

public class AlienBullet {

    static int bVelocity;
    static int Speed = 10;
    static int width = 5;
    static int height = 7;
    static int spawnRate;

    static ArrayList<Integer> y =new ArrayList<Integer>();
    static ArrayList<Integer> x =new ArrayList<Integer>();
    static Random rn = new Random();

    AlienBullet(){
        spawnRate = 60;
    }

            
        public static void move() {
            int luckyNum = rn.nextInt(spawnRate) + 1;

            if (luckyNum == 1) {
            int AlienNumber = rn.nextInt(Alien.arl1.size());
            AlienBullet.x.add(Alien.arl1.get(AlienNumber) + GamePanel.ALIEN_WIDTH/2);
            AlienBullet.y.add(GamePanel.ALIEN_HEIGHT + Alien.y);
            }

        for(int i = 0; i < y.size(); i++){
            y.set(i, y.get(i)+Speed);
            }
        }


        public static void draw(Graphics g) {
            g.setColor(new Color(14,209,69));
            for(int j = 0; j < y.size(); j++){
            g.fillRect(x.get(j), y.get(j), width, height);
            }
        }
}

