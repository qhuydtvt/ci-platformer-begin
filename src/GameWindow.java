
import bases.GameObject;
import bases.inputs.InputManager;
import bases.scenes.SceneManager;
import bases.settings.Settings;
import game.Platform;
import game.Player;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

/**
 * Created by huynq on 7/29/17.
 */
public class GameWindow extends Frame {

    private long lastTimeUpdate;
    private long currentTime;

    private BufferedImage blackBackground;

    private BufferedImage backbufferImage;
    private Graphics2D backbufferGraphics;

    InputManager inputManager = InputManager.instance;

    public GameWindow() {
        pack();
        setupGameLoop();
        setupWindow();
        setupLevel();
    }

    private void setupLevel() {
        // Add player
        Player player = new Player();
        player.getPosition().set(100, 50);
        GameObject.add(player);

        // Add platforms
        for(int i = 0, platformX = 20; i < 20; i++, platformX += 30) {
            Platform platform = new Platform();
            platform.getPosition().set(platformX, 600);
            GameObject.add(platform);
        }

        for(int i = 0, platformX = 270; i < 7; i++, platformX += 30) {
            Platform platform = new Platform();
            platform.getPosition().set(platformX, 500);
            GameObject.add(platform);
        }
    }

    private void setupGameLoop() {
        lastTimeUpdate = -1;
    }

    private void setupWindow() {
        this.setSize(Settings.instance.getWindowWidth(), Settings.instance.getWindowHeight());

        this.setTitle("<Enter title here>");
        this.setVisible(true);

        this.backbufferImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        this.backbufferGraphics = (Graphics2D) this.backbufferImage.getGraphics();

        this.blackBackground = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D backgroundGraphics = (Graphics2D) this.blackBackground.getGraphics();
        backgroundGraphics.setColor(Color.BLACK);
        backgroundGraphics.fillRect(0, 0, this.getWidth(), this.getHeight());

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                inputManager.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                inputManager.keyReleased(e);
            }
        });

        Settings.instance.setWindowInsets(this.getInsets());
    }

    public void loop() {
        while(true) {
            if (lastTimeUpdate == -1) {
                lastTimeUpdate = System.nanoTime();
            }

            currentTime = System.nanoTime();

            if (currentTime - lastTimeUpdate > 17000000) {
                run();
                render();
                SceneManager.changeSceneIfNeeded();
                lastTimeUpdate = currentTime;
            }
        }
    }

    private void run() {
        GameObject.runAll();
        GameObject.runAllActions();
    }

    private void render() {
        backbufferGraphics.drawImage(blackBackground, 0, 0, null);
        GameObject.renderAll(backbufferGraphics);
        getGraphics().drawImage(backbufferImage, 0, 0, null);
    }
}
