package game;


import game.enemy.EnemyDown;

import java.awt.*;

public class HighScore extends  GameObject
{
    String highscore;
    static Font font = new Font("Verdana",Font.BOLD,30);
    public HighScore()
    {
        highscore = "High Score";
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        g.setFont(font);
        g.drawString(highscore,510,50);
        g.drawString(String.valueOf(EnemyDown.mark),580,90);
    }
}
