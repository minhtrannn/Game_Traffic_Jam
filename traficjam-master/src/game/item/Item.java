package game.item;

import game.GameObject;
import game.physics.BoxCollider;
import game.player.Player;

public class Item extends GameObject  {
    BoxCollider boxCollider;

    public Item()
    {
        this.boxCollider = new BoxCollider(this , 12 ,12);
    }
    @Override
    public void run(){
        super.run();
        Player player = GameObject.findIntersects(Player.class,this.boxCollider);
        if(player != null) {
            this.powerUp();
            this.deactive();
        }
    }

    public void powerUp(){

    }

}
