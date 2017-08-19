package touhou.scenes;

import bases.Constraints;
import bases.GameObject;
import tklibs.SpriteUtils;
import touhou.enemies.EnemySpawner;
import touhou.players.Player;

import java.awt.image.BufferedImage;

/**
 * Created by huynq on 8/19/17.
 */
public class Level1Scene {
    private BufferedImage background;
    Player player = new Player();
    EnemySpawner enemySpawner = new EnemySpawner(); // TODO: Viec cua lop: sua thanh game object

    public void init() {
        background = SpriteUtils.loadImage("assets/images/background/0.png");
        addPlayer();
    }

    private void addPlayer() {
//        player.setInputManager(this.inputManager);
//        player.setContraints(new Constraints(getInsets().top, 768, getInsets().left, 384));
//        player.getPosition().set(384 / 2, 580);

        //GameObject.add(player);
    }
}
