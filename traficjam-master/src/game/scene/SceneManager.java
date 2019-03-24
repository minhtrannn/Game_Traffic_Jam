package game.scene;

public class SceneManager {

    /**
     * thuoc tinh luu lai scenehien tai duoc chay trong game
     * */

    public static Scene currentScene;

    /**
     * am dung de ua 1 scene moi vao game
     * 2 nhiem vu chinh init scene moi vao clear sence cu
     * @param newScene: scene moi can dua vao game
     * */

    public static void signNewScene(Scene newScene){
        if (currentScene != null){
            currentScene.clear();
        }
        newScene.init();
        currentScene = newScene;

    }
}
