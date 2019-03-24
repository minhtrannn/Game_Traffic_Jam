package game.enemy;

import game.GameObject;

public class EnemyDownSummoner extends GameObject
{
    int wayCount;
    int summonCount;
    int enemyDownCount;
    public EnemyDownSummoner()
    {
        wayCount = 0;
        summonCount = 0;
        enemyDownCount = 0;
    }

    @Override
    public void run() {
        super.run();
        summonEnemy();
    }

    private void summonEnemy()
    {
        wayCount++;
        if(wayCount > 300)
        {
            summonCount++;
            if(summonCount > 10)
            {
                EnemyDown enemyDown = GameObject.recycle(EnemyDown.class);
                summonCount=0;
                enemyDownCount++;
                if(enemyDownCount >=1)
                {
                    wayCount = 0;
                    enemyDownCount = 0;
                }
            }
        }
    }


}
