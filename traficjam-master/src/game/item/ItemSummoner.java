package game.item;

import game.FrameCounter;
import game.GameObject;
import game.Settings;

import java.util.Random;

public class ItemSummoner extends GameObject {
    FrameCounter summonerCouter;
    Random random;

    public ItemSummoner(){
        this.summonerCouter = new FrameCounter(300); //2s summon 1 item
        this.random = new Random();
    }

    @Override
    public void run(){
        super.run();
        if (this.summonerCouter.run()){
            Item item = GameObject.recycle(ItemSpeed.class);
            int randomX = this.random.nextInt(Settings.BACKGROUND_WIDTH);
            item.position.set(randomX,-30);
            this.summonerCouter.reset();
        }
        checkItemSpeedFrameLeft();
    }

    private void checkItemSpeedFrameLeft() {
        if(Settings.ITEM_SPEED_FRAME_LEFT > 0) {
            Settings.ITEM_SPEED_FRAME_LEFT--;
            if(Settings.ITEM_SPEED_FRAME_LEFT <= 0) {
                Settings.ITEM_SPEED_FRAME_LEFT = 0;
                Settings.ENEMY_SPEED = 5;
                Settings.BACKGROUND_SPEED = 3;
            }
        }
    }
}
