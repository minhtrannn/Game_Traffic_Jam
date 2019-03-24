package game.scene;

import game.Background;
import game.GameObject;

public class SceneWelcome extends Scene{
    @Override
    public void init(){
        GameObject.recycle(BackgroundWelcome.class);
    }

    public void clear(){
        GameObject.clearAll();
    }
}
