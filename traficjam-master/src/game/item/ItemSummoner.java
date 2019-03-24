package game.item;

import game.FrameCounter;
import game.GameObject;
import game.Settings;

import java.util.Random;

public class ItemSummoner extends GameObject {
    FrameCounter summonerCouter;
    Random random;

    public ItemSummoner(){
        this.summonerCouter = new FrameCounter(120); //2s summon 1 item
        this.random = new Random();
    }

    @Override
    public void run(){
        super.run();
        if (this.summonerCouter.run()){
            Item item = GameObject.recycle(ItemHP.class);
            int randomX = this.random.nextInt(Settings.BACKGROUND_WIDTH);
            item.position.set(randomX,-30);
            this.summonerCouter.reset();
        }

    }
}
