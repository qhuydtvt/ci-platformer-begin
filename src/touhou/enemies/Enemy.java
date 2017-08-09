package touhou.enemies;

import tklibs.SpriteUtils;
import touhou.bases.Vector2D;
import touhou.bases.renderers.ImageRenderer;

import java.awt.*;

/**
 * Created by huynq on 8/9/17.
 */
public class Enemy {
    private static final float SPEED = 3;

    private Vector2D position;
    private ImageRenderer renderer;

    public Enemy() {
        position = new Vector2D();
        renderer = new ImageRenderer(SpriteUtils.loadImage("assets/images/enemies/level0/blue/0.png"));
    }

    // View
    public void render(Graphics2D g2d) {
        renderer.render(g2d, position);
    }

    public Vector2D getPosition() {
        return position;
    }

    // Controller
    public void run() {
        fly();
        shoot();
    }

    private void shoot() {
        // TODO: create enemy bullet and shoot
    }

    private void fly() {
        position.addUp(0, SPEED);
    }
}
