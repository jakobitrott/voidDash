package com.Jakob;

import java.awt.*;
import java.util.Random;

/**
 * Created by jakob on 07/08/2017.
 */
public class MenuParticle extends GameObject {

    private Handler handler;
    Random random = new Random();
    private Color color;
    int direction = 0;

    public MenuParticle(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);
        this.handler = handler;

        direction = random.nextInt(2);
        if (direction == 0) {
            vX = 2;
            vY = 2;
        } else if (direction == 1) {
            vX = 2;
            vY = 2;
        }

        color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));

    }


    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }

    public void tick() {
        x += vX;
        y += vY;

        if (y <= 0 || y >= Game.HEIGHT - 32) // reverse direction
            vY *= -1;

        if (x <= 0 || x >= Game.WIDTH - 32) // reverse direction
            vX *= -1;

        new Trail((int) x, (int) y, ID.Trail, color, 16, 16, 0.03f, handler);
    }

    public void render(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillOval((int) x, (int) y, 16, 16);
    }
}
