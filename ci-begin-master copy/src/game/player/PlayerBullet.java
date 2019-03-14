//package game.player;
//
//import game.GameObject;
//import game.Settings;
//import game.enemy.Enemy;
//import game.physics.BoxCollider;
//import game.renderer.AnimationRenderer;
//import game.renderer.SingleImageRenderer;
//import tklibs.SpriteUtils;
//
//import java.awt.*;
//import java.awt.image.BufferedImage;
//
//public class PlayerBullet extends GameObject {
////    static BufferedImage type1Image = SpriteUtils.loadImage("assets/images/enemies/bullets/blue.png");
////    static BufferedImage type2Image = SpriteUtils.loadImage("assets/images/enemies/bullets/cyan.png");
////    static BufferedImage type3Image = SpriteUtils.loadImage("assets/images/enemies/bullets/green.png");
////    //
//
//
//    public int damage;
//    public PlayerBullet() {
//        renderer = new AnimationRenderer("assets/images/player-bullets/a",5);
//        velocity.set(1, 1);
//        velocity.setLength(Settings.PLAYER_BULLET_SPEED);
//        collider = new BoxCollider(this,10,10);
//        damage = 1;
//
//    }
//
//    @Override
//    public void run() {
//        super.run();
//        deactiveIfNeeded();
//        checkIntersects();
//    }
//
//    private void checkIntersects() {
//        Enemy enemy = GameObject.findIntersects(Enemy.class,this.collider);
//        if(enemy != null)
//        {
//            //neu vien dan cham vao enemy deactive bullet va enemy
//            deactive();
//            enemy.takeDamage(damage);
//        }
//    }
//
//    private void deactiveIfNeeded() {
//        if(this.position.y < -30) {
//            this.deactive();
//        }
//    }
//
//
//}
