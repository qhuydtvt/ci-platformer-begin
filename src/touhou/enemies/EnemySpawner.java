package touhou.enemies;

import touhou.bases.FrameCounter;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by huynq on 8/9/17.
 */
public class EnemySpawner {
    private FrameCounter frameCounter;
    private Random random;

    public EnemySpawner() {
        frameCounter = new FrameCounter(70);
        random = new Random();
    }

    public void spawn(ArrayList<Enemy> enemies) {
        //TODO: use framecounter
        Enemy enemy = new Enemy();
        enemy.getPosition().set(random.nextInt(384), 40);
        enemies.add(enemy);
    }
}
