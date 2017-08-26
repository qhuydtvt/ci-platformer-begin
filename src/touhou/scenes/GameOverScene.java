package touhou.scenes;

import bases.GameObject;
import bases.renderers.ImageRenderer;
import tklibs.SpriteUtils;

/**
 * Created by huynq on 8/23/17.
 */
public class GameOverScene extends Scene {

    @Override
    public void init() {
        
        GameObject.add(new GameObject().setRenderer(
                ImageRenderer.create("assets/images/scenes/game-over-background.jpg"))
        );
    }
}
