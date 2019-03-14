package game.enemy;

import game.GameObject;
import game.physics.BoxCollider;
import game.player.Player;
import game.Settings;
import game.Vector2D;
import game.renderer.AnimationRenderer;
import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.util.Random;

public class Enemy extends GameObject {
    int fireCount;
    int hp;
    int number;
    public  int damage;
    Random rd = new Random();
    public Enemy() {
        //image = SpriteUtils.loadImage("assets/images/enemies/level0/pink/0.png");
        this.collider = new BoxCollider(this,20 , 20);
        renderer = new AnimationRenderer("assets/images/enemies/level0/pink",10);
        number = rd.nextInt(350);
        position.set(number,0);
        velocity.set(1,0);
        velocity.setAngle( Math.PI /2);
        velocity.setLength(Settings.ENEMY_SPEED);
        fireCount = 0;
        collider = new BoxCollider(this,28,28);
        hp=1;
        this.damage = 1;
    }

    @Override
    public void run() {

        super.run();
        this.checkIntersects();
    }

    public void takeDamage(int damage)
    {
        hp -= damage;
        if(hp <= 0)
        {
            this.deactive();
            hp=0;
        }
    }
    static Font font = new Font("Verdana",Font.BOLD,30);
    // ham font kha nang khi su dung
    @Override
    public void render(Graphics g) {
        super.render(g);
        g.drawRect((int) collider.left(),(int) collider.top(),(int)collider.width,(int)collider.height);
        g.setFont(font);
        g.drawString(hp+ "",
                (int) collider.left(),
                (int) collider.top());
    }
    @Override
    public void reset() {
        super.reset(); // active = true;
        number = rd.nextInt(350);
        position.set(number,0);
        hp = 1;
        velocity.setAngle(Math.PI/2);
    }
    private void checkIntersects()
    {
        Player player = GameObject.findIntersects(Player.class,this.collider);
        if(player != null)
        {
            player.takeDamage(damage);
            this.deactive();
        }
    }
}
