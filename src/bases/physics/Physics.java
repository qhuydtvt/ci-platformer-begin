package bases.physics;

import touhou.enemies.Enemy;

import java.util.Vector;

/**
 * Created by huynq on 8/12/17.
 */
public class Physics {
    private static Vector<PhysicsBody> bodies = new Vector<>();

    public static Enemy collideWithEnemy(BoxCollider boxCollider) {
        for(PhysicsBody body : bodies) {
            if (body.isActive()) {
                if (body instanceof Enemy && body.getBoxCollider().intersects(boxCollider)) {
                    return (Enemy) body;
                }
            }
        }

        return null;
    }

    public static void add(PhysicsBody body) {
        bodies.add(body);
    }
}
