package game.scene;

import game.GameObject;

public class SceneLoading extends  Scene
{
    @Override
    public void init() {
        GameObject.recycle(BackgroundLoading.class);
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}
