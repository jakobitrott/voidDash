package com.Jakob;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

/**
 * VOID DASH
 * Created by jakob on 02/08/2017.
 */
public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1550691097823471818L;

    public static final int WIDTH = 640, HEIGHT = (WIDTH / 12) * 9;

    private Thread thread;
    private boolean running = false;

    private Random random;
    private Handler handler;
    private HUD hud;
    private Spawn spawner;
    private Menu menu;

    public static STATE gameState = STATE.Menu;

    public enum STATE {
        Menu,
        Game,
        Help,
        End
    }

    ;


    public Game() {

        handler = new Handler(); //
        hud = new HUD();
        menu = new Menu(this,handler,hud);

        this.addKeyListener(new KeyInput(handler));
        this.addMouseListener(menu);

        AudioPlayer.load();

        AudioPlayer.getMusic("music").loop();

        new Window(WIDTH, HEIGHT, "VoidDa$h", this);


        spawner = new Spawn(handler, hud);
        random = new Random();


        if (gameState == STATE.Game) {
            new Player((WIDTH / 2 - 32), (HEIGHT / 2 - 32), ID.Player, handler);

            new BasicEnemy(random.nextInt(Game.WIDTH - 10), random.nextInt(Game.HEIGHT - 10), ID.BasicEnemy, handler);
        }
        else{
            for (int i = 0; i < 10; i++) {
                new MenuParticle(random.nextInt(WIDTH),random.nextInt(HEIGHT),ID.MenuParticle,handler);
            }
        }


    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace(); //run an error in the console
        }
    }



    public void run() { //game loop
        this.requestFocus(); //don't have to click window in order to use controls

        /*
         The Setup
         ------------
         lastTime is as start time to measure amount of time passed
         amountOfTicks is the number of ticks per second
         ns is the number of nanoseconds allowed between ticks
         timer is used at the start time for measuring 1 second
         frames if the number of frames per second (calls to render)

          */


        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;


          /*

         The Game Loop
         -------------
         While the game is running
         - update delta with the amount of time passed since the LAST ITERATION of the loop
         - while we're behind on game ticks --> make the game tick
         - redraw the screen and increase the fps counter by 1
         - finally if 1 SECOND has passed
         - Display the number of FPS and reset the counter to ZERO
          */

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running)
                render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) { //1 second has passed
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }

    }

    private void tick() {
        handler.tick();
        if (gameState == STATE.Game) {
            hud.tick();
            spawner.tick();
            if(HUD.HEALTH <= 0){
                HUD.HEALTH = 100;
                gameState = STATE.End;
                handler.clearEnemies();
                for (int i = 0; i < 10; i++) {
                    new MenuParticle(random.nextInt(WIDTH),random.nextInt(HEIGHT),ID.MenuParticle,handler);
                }
            }
        }
        else if(gameState == STATE.Menu || gameState == STATE.End){
            menu.tick();
        }
    }

    private void render() {
        BufferStrategy bufferStrategy = this.getBufferStrategy();
        if (bufferStrategy == null) {
            this.createBufferStrategy(3);//how many buffers it creates
            return;
        }

        Graphics graphics = bufferStrategy.getDrawGraphics();
        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(graphics);

        if (gameState == STATE.Game) {

            hud.render(graphics);
        } else if(gameState == STATE.Menu || gameState == STATE.Help || gameState == STATE.End){
            menu.render(graphics);
        }

        graphics.dispose();
        bufferStrategy.show();

    }

    public static float clamp(float value, float minimumValue, float maximumValue) {
        if (value >= maximumValue) {
            return (value = maximumValue);
        } else if (value <= minimumValue) {
            return (value = minimumValue);
        } else
            return value;
    }

    public static void main(String[] args) {
        new Game();
    }

}

