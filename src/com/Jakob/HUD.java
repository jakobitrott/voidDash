package com.Jakob;

import java.awt.*;

/**
 * Created by jakob on 03/08/2017.
 */
public class HUD {

    public static int HEALTH = 100;

    public void tick(){
        HEALTH --;
        HEALTH = Game.clamp(HEALTH,0,100);

    }

    public void render(Graphics graphics){

        //empty health bar
        graphics.setColor(Color.darkGray);
        graphics.fillRect(15,15,200,32);

        //Health
        graphics.setColor(Color.GREEN);
        graphics.fillRect(15,15,HEALTH*2,32);

        //draw border around health
        graphics.setColor(Color.WHITE);
        graphics.drawRect(15,15,200,32);
    }
}
