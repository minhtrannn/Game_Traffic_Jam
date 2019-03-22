package game.enemy;

import game.GameObject;
import game.physics.BoxCollider;
import game.player.Player;
import game.Settings;
import game.renderer.AnimationRenderer;

import java.awt.*;
import java.util.Random;

public class EnemyDown extends GameObject {
    int fireCount;
    int hp;
    int number;
    int number1;
    public  int damage;
    public static int mark;
    Random rd = new Random();
    boolean pass;

    public EnemyDown() {
        this.collider = new BoxCollider(this,20, 20);
        renderer = new AnimationRenderer("assets/images/enemies/level1/pink",10);
        number = 80 + rd.nextInt(550);
        position.set(number,0);
        velocity.set(0,1);
        velocity.setLength(Settings.ENEMY_SPEED);
        //velocity.setAngle(Math.PI/2);
        fireCount = 0;
        collider = new BoxCollider(this,56,96);
        hp=1;
        this.damage = 1;
        pass = true;
        System.out.println(number);
    }

    @Override
    public void run() {
        super.run();
        this.checkIntersects();
        this.checkPass();
        this.checkEnd();
        //this.upDown();
    }


    static Font font = new Font("Verdana",Font.BOLD,30);
    // ham font kha nang khi su dung
    @Override
    public void render(Graphics g) {

        super.render(g);
        g.drawRect((int) collider.left(),(int) collider.top(),(int)collider.width,(int)collider.height);
        g.setFont(font);
    }
    @Override
    public void reset() {
        if(Player.hpPlayer > 0) {
            super.reset(); // active = true;
            number = 80 + rd.nextInt(550);
            position.set(number, 0);
            hp = 1;
            velocity.setAngle(Math.PI / 2);
        }
        else
        {
            Settings.ENEMY_SPEED = 0;
        }
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
            number1 = rd.nextInt(5);
            if(number1 == 0) {
                renderer = new AnimationRenderer("assets/images/enemies/level1/pink", 10);
            }
            else if(number1 == 1)
            {
                renderer = new AnimationRenderer("assets/images/enemies/level1/blue",10);
            }
            else if(number == 2)
            {
                renderer = new AnimationRenderer("assets/images/enemies/level1/black",10);
            }
            else if(number == 3 )
            {
                renderer = new AnimationRenderer("assets/images/enemies/level1/red",10);
            }
            else
            {
                renderer = new AnimationRenderer("assets/images/enemies/level1/white",10);
            }
        }

    }
}