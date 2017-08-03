package com.Jakob;

import java.awt.*;
import java.util.Random;

/**
 * Created by jakob on 02/08/2017.
 */
public class Player extends GameObject {

    Random random = new Random();

    public Player(int x, int y, ID id) {
        super(x, y, id);


    }

    @Override
    public void tick() {
        x += vX;
        y += vY;

        x = Game.clamp(x,0, Game.WIDTH - 37);
        y = Game.clamp(y,0,Game.HEIGHT - 60);

    }

    @Override
    public void render(Graphics graphics) {
        if (id == ID.Player) {
            graphics.setColor(Color.white);
            graphics.fillRect(x, y, 32, 32);
        } /*else if (id == ID.Player2) {
            graphics.setColor(Color.cyan);
            graphics.fillRect(x, y, 32, 32);
        }*/
    }


}
