package game;

import game.enemy.EnemyDownSummoner;
import game.enemy.EnemySummoner;
import game.item.ItemSummoner;
import game.player.Player;
import game.scene.SceneManager;
import game.scene.SceneWelcome;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
//    Background background;
//    Player player;
//    EnemySummoner enemySummoner;
//    HighScore highScore;
//    DamagePlayer damagePlayer;
//    public GamePanel() {
////        background = new Background();
//        SceneManager.signNewScene(new SceneWelcome());

    Background background;
    Player player;
    EnemySummoner enemySummoner;
    HighScore highScore;
    EnemyDownSummoner enemyDownSummoner;
    public GamePanel() {
//        background = new Background();
//        new BackgroundManager();
//        player = new Player();
//        enemySummoner = new EnemySummoner();
//        enemyDownSummoner = new EnemyDownSummoner();
//        highScore = new HighScore();
        SceneManager.signNewScene(new SceneWelcome());
    }




    public void gameLoop() {
        long lastTime = 0;
        long delay = 1000 / 60;
        while(true) {
            long currentTime = System.currentTimeMillis();
            if(currentTime - lastTime >= delay) {
                runAll();
                renderAll();
                lastTime = currentTime;
            }
        }
    }

    private void renderAll() {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        // ve anh
        for(int i = 0; i < GameObject.objects.size(); i++) {
            GameObject object = GameObject.objects.get(i);
            if(object.active) {
                object.render(g);
            }
        }
    }

    private void runAll() {
        for(int i = 0; i < GameObject.objects.size(); i++) {
            GameObject object = GameObject.objects.get(i);
            if(object.active) {
                object.run();
            }
        }
        //System.out.println(GameObject.objects.size());
    }
}
