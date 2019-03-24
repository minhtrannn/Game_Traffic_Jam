package game.scene;

import game.GameObject;
import game.Settings;
import game.renderer.AnimationRenderer;

public class BackgroundLoading extends GameObject {

    public BackgroundLoading() {
        renderer = new AnimationRenderer("/er copy/assets/images/background/loading",20);
        position.set(Settings.GAME_WIDTH / 2, Settings.GAME_HEIGHT / 2);
    }

    int count;
    @Override
    public void run() {
        count++;
        // fake loading in 2s >> TODO: real loading
        if(count > 120) {
            SceneManager.signNewScene(new SenceStage1());
        }
    }
}
