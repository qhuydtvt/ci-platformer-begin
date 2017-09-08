package game;

import bases.GameObject;
import bases.renderers.ImageRenderer;

/**
 * Created by huynq on 9/8/17.
 */
public class Platform extends GameObject {
    public Platform() {
        super();
        this.renderer = ImageRenderer.create("assets/images/yellow_square.jpg");
    }
}
