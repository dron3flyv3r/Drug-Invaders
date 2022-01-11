import java.awt.Color;

import javax.swing.JFrame;

public class GameFrame extends JFrame{
	GamePanel panel;
    GameFrame(){
        panel = new GamePanel();        
        
        this.add(panel);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setMinimumSize(GamePanel.SCREEN_SIZE);
        this.setResizable(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
