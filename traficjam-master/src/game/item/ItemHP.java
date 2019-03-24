package game.item;

import game.player.Player;

import game.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class ItemHP extends Item {
    public ItemHP(){

        this.renderer = new AnimationRenderer("assets/images/items/speedUp",10);
        this.velocity.set(0,3);

    }

    @Override
    public void powerUp(Player player){
        player.hpPlayer++;
    }
}
