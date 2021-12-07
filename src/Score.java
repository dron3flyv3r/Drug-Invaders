import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

 
public class Score { 
 
    static int pLife;
    static int GH;
    static int GW;
    static int PlayerScore;
    static int tmpScore;
    /* 
    indhold:
    scoren
    antal liv
    (tid) spillet
    lidt simple GUI
    */

    Score(int PLAYERS_LIFE, int GAME_HEIGHT, int GAME_WIDTH){ //brug til at lave en reset
    pLife = PLAYERS_LIFE;
    GH = GAME_HEIGHT;
    GW = GAME_WIDTH;
    PlayerScore = 0;
    tmpScore = 0;
    }

    public static void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("free ink",Font.BOLD,40));
        g.drawString("Score: " + PlayerScore, 50, 100);

        g.setColor(Color.WHITE);
        g.setFont(new Font("free ink",Font.BOLD,40));
        g.drawString("HP: " + pLife, 50, 50);
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
