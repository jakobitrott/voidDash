package com.Jakob;

/**
 * Created by jakob on 07/08/2017.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject {
    private Handler handler;
    private GameObject player;

    public SmartEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);
        this.handler = handler;
        for (int i = 0; i < handler.gameObject.size(); i++) {
            if (handler.gameObject.get(i).getId() == ID.Player) player = handler.gameObject.get(i);
        }
    }

    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }

    public void tick() {
        x += vX;
        y += vY;
        float diffX = x - player.getX() - 16;
        float diffY = y - player.getY() - 16;
        float distance = (float) Math.sqrt((x - player.getX()) * (x - player.getX()) + (y - player.getY()) * (y - player.getY()));
        vX = ((-1 / distance) * diffX);
        vY = ((-1 / distance) * diffY);
        handler.addObject(new Trail(x, y, ID.Trail, Color.green, 16, 16, 0.02f, handler));
    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.green);
        graphics.fillRect((int) x, (int) y, 16, 16);
    }
}