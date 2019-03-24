package game.scene;

import game.Background;
import game.GameObject;
import game.GameWindow;
import game.Settings;
import game.renderer.AnimationRenderer;
import tklibs.SpriteUtils;

import java.awt.image.BufferedImage;

public class BackgroundWelcome extends GameObject {
    public BackgroundWelcome(){
        renderer = new AnimationRenderer("assets/images/background/backgroundwelcome",10);
        this.position.set(Settings.GAME_WIDTH /2 , Settings.GAME_HEIGHT/2);
    }

    public void run(){
        super.run();
        if (GameWindow.isAnyKeyPress){
            SceneManager.signNewScene(new SenceStage1());
        }
    }
}
