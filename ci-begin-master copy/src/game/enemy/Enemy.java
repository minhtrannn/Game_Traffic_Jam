package game.enemy;

import game.GameObject;
import game.physics.BoxCollider;
import game.player.Player;
import game.Settings;
import game.renderer.AnimationRenderer;

import java.awt.*;
import java.util.Random;

public class Enemy extends GameObject {
    int fireCount;
    int hp;
    int number;
    int number1;
    public  int damage;
    public static int mark;
    Random rd = new Random();
    boolean pass;
    public Enemy() {
        this.collider = new BoxCollider(this,20, 20);
        renderer = new AnimationRenderer("assets/images/enemies/level0/pink",10);
        number = rd.nextInt(350);
        position.set(number,0);
        velocity.set(1,0);
        velocity.setAngle( Math.PI /2);
        velocity.setLength(Settings.ENEMY_SPEED);
        fireCount = 0;
        collider = new BoxCollider(this,56,96);
        hp=1;
        this.damage = 1;
        pass = true;
    }

    @Override
    public void run() {
        super.run();
        this.checkIntersects();
        this.checkPass();
        this.checkEnd();
    }

    static Font font = new Font("Verdana",Font.BOLD,30);
    // ham font kha nang khi su dung
    @Override
    public void render(Graphics g) {

        super.render(g);
        g.drawRect((int) collider.left(),(int) collider.top(),(int)collider.width,(int)collider.height);
        g.setFont(font);
//        g.drawString(hp+ "",
//                (int) collider.left(),
//                (int) collider.top());
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
    private void checkPass()
    {
        if(this.position.y > Player.positionPlayery && pass == true)
        {
            if(Player.positionPlayerx > position.x)
            {
                if (Player.positionPlayerx - this.position.x <= 65 && this.position.y + 10 >= Player.positionPlayery)
                {
                    mark += 30;
                } else if (Player.positionPlayerx - this.position.x <= 110 && Player.positionPlayerx - this.position.x > 65)
                {
                    mark += 20;
                } else mark += 10;
            }
            else if(position.x > Player.positionPlayerx)
            {
                if(this.position.x - Player.positionPlayerx <= 65 && this.position.y + 10 >= Player.positionPlayery) {
                    mark += 30;
                }else if(this.position.x - Player.positionPlayerx <=110 && this.position.x - Player.positionPlayerx > 65)
                {
                    mark+=20;
                } else mark+=10;
            }
            pass = false;
        }
    }
    private void checkEnd() // di het map thi deactive
    {
        if(this.position.y > 600)
        {
            this.deactive();
            pass = true;
            number1 = rd.nextInt(3);
            System.out.println(number1);
            if(number1 == 0)
            {
                renderer = new AnimationRenderer("assets/images/enemies/level0/pink",10);
            }
             else if(number1 == 1)
            {
                 renderer = new AnimationRenderer("assets/images/enemies/level0/blue",10);
            }
            else
            {
                renderer = new AnimationRenderer("assets/images/enemies/level0/black",10);
            }
        }

    }
}
