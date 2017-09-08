package game;

import bases.GameObject;
import bases.renderers.ImageRenderer;

/**
 * Created by huynq on 9/8/17.
 */
public class Player extends GameObject {

    public Player() {
        super();
        this.renderer = ImageRenderer.create("assets/images/green_square.png");
    }
}
