package game;

import game.player.Player;

public class BackgroundManager extends  GameObject
{
    Background b1;
    Background b2;
    Background currentDisplay;
    Background currentHide;
    public  BackgroundManager()
    {
        b1 = new Background();
        b1.position.set(0, Settings.GAME_HEIGHT - Settings.BACKGROUND_HEIGHT);
        b1.velocity.set(0, Settings.BACKGROUND_SPEED);
        b2= new Background();
        //b2.position.set(0, Settings.GAME_HEIGHT - Settings.BACKGROUND_HEIGHT);
        b2.velocity.set(0, Settings.BACKGROUND_SPEED);
        setAbove(b2,b1);
        currentDisplay = b1;
        currentHide = b2;
    }


    @Override
    public void run() {
        super.run();
        if(Player.hpPlayer > 0) {
            if (currentDisplay.position.y > -5) {
                setAbove(currentHide, currentDisplay);
                Background temp = currentDisplay;
                currentDisplay = currentHide;
                currentHide = temp;
            }
        }
        else
        {
              b1.velocity.set(0,0);
              b2.velocity.set(0,0);
        }
    }
    public void setAbove(Background a, Background b)
    {
        Vector2D newAPosition = b.position.clone();
        newAPosition.add(0, -Settings.BACKGROUND_HEIGHT + 3);
        a.position.set(newAPosition);
    }
}
