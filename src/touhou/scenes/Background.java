package touhou.scenes;

import bases.GameObject;
import bases.Vector2D;
import bases.renderers.ImageRenderer;
import tklibs.SpriteUtils;

/**
 * Created by huynq on 8/19/17.
 */
public class Background extends GameObject {
    private ImageRenderer imageRenderer;
    private float SPEED = 4;
    float imageHeight;

    public Background() {
        super();
        this.imageRenderer = new ImageRenderer(
                SpriteUtils.loadImage("assets/images/background/0.png")
        );
        this.imageRenderer.getAnchor().set(0, 1);
        this.position.set(0, 768);
        this.imageHeight = imageRenderer.image.getHeight();
        this.renderer = imageRenderer;
    }

    @Override
    public void run(Vector2D parentPosition) {
        super.run(parentPosition);
        position.y += SPEED;
        if (position.y > imageHeight) {
            position.y = imageHeight;
        }
    }
}
