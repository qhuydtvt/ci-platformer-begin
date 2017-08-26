package touhou.scenes;

import bases.Constraints;
import bases.GameObject;
import touhou.enemies.EnemySpawner;
import touhou.inputs.InputManager;
import touhou.players.Player;
import touhou.settings.Settings;


/**
 * Created by huynq on 8/19/17.
 */
public class Level1Scene extends Scene {
    Player player = new Player();

    Settings settings = Settings.instance;

    @Override
    public void init() {
        addBackground();
        addPlayer();
        addEnemySpawner();
    }

    private void addEnemySpawner() {
        GameObject.add(new EnemySpawner());
    }

    private void addBackground() {
        GameObject.add(new Background());
    }

    private void addPlayer() {
        player.setInputManager(InputManager.instance);
        player.setContraints(new Constraints(
                settings.getWindowInsets().top,
                settings.getGamePlayHeight(),
                settings.getWindowInsets().left,
                settings.getGamePlayWidth())
        );

        player.getPosition().set(
                settings.getGamePlayWidth() / 2,
                settings.getGamePlayHeight() * 3 / 4);

        GameObject.add(player);
    }
}
