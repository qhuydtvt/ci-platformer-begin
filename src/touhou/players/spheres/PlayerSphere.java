package touhou.players.spheres;

import bases.GameObject;
import bases.renderers.Animation;
import tklibs.SpriteUtils;

/**
 * Created by huynq on 8/16/17.
 */
public class PlayerSphere extends GameObject {
    Animation animation;

    public PlayerSphere() {
        super();

        this.animation = new Animation(
                7,
                false,
                SpriteUtils.loadImage("assets/images/sphere/0.png"),
                SpriteUtils.loadImage("assets/images/sphere/1.png"),
                SpriteUtils.loadImage("assets/images/sphere/2.png"),
                SpriteUtils.loadImage("assets/images/sphere/3.png")
        );

        this.renderer = animation;
    }

    public void setReverse(boolean reverse) {
        this.animation.setReverse(reverse);
    }
}
