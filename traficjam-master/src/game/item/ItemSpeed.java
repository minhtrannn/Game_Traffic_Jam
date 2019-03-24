package game.item;

import game.Settings;
import game.player.Player;

import game.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class ItemSpeed extends Item {
    public ItemSpeed(){

        this.renderer = new AnimationRenderer("assets/images/items/speedUp",10);
        this.velocity.set(0,3);

    }

    @Override
    public void powerUp(){
        Settings.ENEMY_SPEED = 3;
        Settings.BACKGROUND_SPEED = 1;
        Settings.ITEM_SPEED_FRAME_LEFT = 120;
    }
}
