package game.scene;

import game.*;
import game.enemy.EnemyDownSummoner;
import game.enemy.EnemySummoner;
import game.item.ItemSummoner;
import game.player.Player;

public class SenceStage1 extends Scene {
    @Override
    public void init(){
        GameObject.recycle(Background.class);
        new BackgroundManager();

        GameObject.recycle(Player.class);
        GameObject.recycle(EnemySummoner.class);
        GameObject.recycle(ItemSummoner.class);
        HighScore highScore = new HighScore();
        DamagePlayer damagePlayer = new DamagePlayer();
        GameObject.recycle(EnemyDownSummoner.class);
    }

    @Override
    public void clear(){
        GameObject.clearAll();
    }
}
