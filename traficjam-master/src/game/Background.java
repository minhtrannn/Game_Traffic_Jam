package game;

import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background extends GameObject {
    public Background() {
        this.renderer = new SingleImageRenderer(SpriteUtils.loadImage("assets/images/background/map-2.png"));
        this.anchor.set(0,0); // set cho background ve vi tri 0 0
//        this.position.set(0,600-1498);
//        this.velocity.set(0,10);


    }

    @Override
    public void run() {
        super.run();

        // == this.position.add(this.velocity.x, this.velocity.y);
    }

    @Override
    public void render(Graphics g) {
        super.render(g);

    }
}
