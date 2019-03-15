package game.player;

import game.GameObject;
import game.GameWindow;
import game.Settings;
import game.enemy.Enemy;
import game.physics.BoxCollider;
import game.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class Player extends GameObject {
    int fireCount;
    int bulletType;
    int changeBulletCount;
    Random random;
    int hp;
    public int damage;
    public Player() {
        collider = new BoxCollider(this,30,60);
        renderer = new PlayerRenderer();
        position.set(200, 500);
        random = new Random();
        hp = 5;
        this.damage = 1;
    }

    @Override
    public void run() {
        super.run();
        playerMove();
        playerLimit();
//        this.checkIntersects();
    }


    private void playerMove() {
        int vX = 0;
        int vY = 0;

        if(GameWindow.isUpPress) { // player move
            vY--;
        }
        if(GameWindow.isRightPress) {
            vX++;
        }
        if(GameWindow.isDownPress) {
            vY++;
        }
        if(GameWindow.isLeftPress) {
            vX--;
        }

        this.velocity.set(vX, vY);
        this.velocity.setLength(1);
    }

    private void playerLimit() {
        double offsetWidth = anchor.x * Settings.PLAYER_WIDTH;
        double offsetHeight = anchor.y * Settings.PLAYER_HEIGHT;
        if(position.x < offsetWidth) { // limit player
            position.x = offsetWidth;
        }
        if(position.x > Settings.BACKGROUND_WIDTH - offsetWidth) {
            position.x = Settings.BACKGROUND_WIDTH - offsetWidth;
        }
        if(position.y < offsetHeight) {
            position.y = offsetHeight;
        }
        if(position.y > Settings.GAME_HEIGHT - offsetHeight) {
            position.y = Settings.GAME_HEIGHT - offsetHeight;
        }
    }
    public void takeDamage(int damage)
    {
        hp -= damage;
        if(hp <= 0)
        {
            hp=0;
            this.deactive();
        }
    }
    private void checkIntersects() {
        Enemy enemy = GameObject.findIntersects(Enemy.class,this.collider);
        if(enemy != null)
        {
            this.deactive();
            enemy.takeDamage(damage);
        }
    }
}
