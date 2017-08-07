package com.Jakob;

import java.util.Random;

/**
 * Created by jakob on 05/08/2017.
 */
public class Spawn {
    private Handler handler;
    private HUD hud;
    private Random random = new Random();

    private int scoreKeep = 0;

    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void tick() {
        scoreKeep++;

        if (scoreKeep >= 250) {

            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);
            if (hud.getLevel() == 2) {
                new BasicEnemy(random.nextInt(Game.WIDTH - 10), random.nextInt(Game.HEIGHT - 10), ID.BasicEnemy, handler);
            } else if (hud.getLevel() == 3) {
                new BasicEnemy(random.nextInt(Game.WIDTH - 10), random.nextInt(Game.HEIGHT - 10), ID.BasicEnemy, handler);
            } else if (hud.getLevel() == 4) {
                new FastEnemy(random.nextInt(Game.WIDTH - 10), random.nextInt(Game.HEIGHT - 10), ID.BasicEnemy, handler);
            } else if (hud.getLevel() == 5) {
               new SmartEnemy(random.nextInt(Game.WIDTH - 10), random.nextInt(Game.HEIGHT - 10), ID.SmartEnemy, handler);
            }
            else if (hud.getLevel() == 6) {
                new FastEnemy(random.nextInt(Game.WIDTH - 10), random.nextInt(Game.HEIGHT - 10), ID.FastEnemy, handler);
            }
            else if (hud.getLevel() == 7) {
                new FastEnemy(random.nextInt(Game.WIDTH - 10), random.nextInt(Game.HEIGHT - 10), ID.FastEnemy, handler);
            }
            else if (hud.getLevel() == 8) {
                new SmartEnemy(random.nextInt(Game.WIDTH - 10), random.nextInt(Game.HEIGHT - 10), ID.SmartEnemy, handler);
            }
            else if (hud.getLevel() == 10) {
                handler.clearEnemies();
                new BossEnemy((Game.WIDTH /2) - 48, -140, ID.BossEnemy, handler);
            }




        }
    }
}



