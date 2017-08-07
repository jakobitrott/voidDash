package com.Jakob;

import java.awt.*;

/**
 * Created by jakob on 04/08/2017.
 */
public class Trail extends GameObject {

    private float alpha = 1;

    private Handler handler;
    private Color color;

    private int width, height;
    private float life;

    //life is a value between 0.01 and 0.1

    public Trail(float x, float y, ID id, Color color, int width, int height, float life, Handler handler) {
        super(x, y, id,handler);
        this.handler = handler;
        this.color = color;
        this.height = height;
        this.width = width;
        this.life = life;
    }

    @Override
    public void tick() {
        if (alpha > life) {
            alpha -= (life - 0.001f);
        } else {
            handler.removeObject(this);
        }
    }


    @Override
    public void render(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setComposite(makeTransparent(alpha));

        graphics.setColor(color);
        graphics.fillRect((int)x, (int)y, width, height);

        graphics2D.setComposite(makeTransparent(1));

    }

    //renders out transparencys in object
    private AlphaComposite makeTransparent(float alpha) {
        int type = AlphaComposite.SRC_OVER;
        return (AlphaComposite.getInstance(type, alpha));
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }


}

