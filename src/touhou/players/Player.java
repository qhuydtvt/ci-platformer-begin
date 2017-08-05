package touhou.players;

import tklibs.SpriteUtils;
import touhou.bases.Constraints;
import touhou.bases.Vector2D;
import touhou.bases.renderers.ImageRenderer;
import touhou.inputs.InputManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by huynq on 8/2/17.
 */
public class Player {
    private static final int SPEED = 5;
    public Vector2D position;
    public InputManager inputManager;
    public Constraints constraints;
    public ArrayList<PlayerSpell> playerSpells;
    public ImageRenderer renderer;

    public Player() {
        position = new Vector2D(384/2, 600);
        BufferedImage image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
        renderer = new ImageRenderer(image);
    }

    public void run() {
        if (inputManager.upPressed)
            position.addUp(0, -SPEED);
        if (inputManager.downPressed)
            position.addUp(0, SPEED);
        if (inputManager.leftPressed)
            position.addUp(-SPEED, 0);
        if (inputManager.rightPressed)
            position.addUp(SPEED, 0);

        if (constraints != null) {
            constraints.make(position);
        }

        castSpell();
    }

    private void castSpell() {
        if (inputManager.xPressed) {
            PlayerSpell newSpell = new PlayerSpell();
            newSpell.position.set(this.position);
            playerSpells.add(newSpell);
        }
    }

    public void render(Graphics2D g2d) {
        renderer.render(g2d, position);
    }
}
