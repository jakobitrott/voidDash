package com.Jakob;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * VOID DASH
 * Created by jakob on 02/08/2017.
 *
 */
public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1550691097823471818L;

    public static final int WIDTH = 640, HEIGHT = (WIDTH / 12) * 9;

    private boolean running = false;
    private Thread thread;

    public Game() {
        new Window(WIDTH, HEIGHT, "VoidDa$h", this);
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
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime += now;
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
        /*
         The Setup
         ------------
         lastTime is as start time to measure amount of time passed
         amountOfTicks is the number of ticks per second
         ns is the number of nanoseconds allowed between ticks
         timer is used at the start time for measuring 1 second
         frames if the number of frames per second (calls to render)


         The Game Loop
         -------------
         While the game is running
         - update delta with the amount of time passed since the LAST ITERATION of the loop
         - while we're behind on game ticks --> make the game tick
         - redraw the screen and increase the fps counter by 1
         - finally if 1 SECOND has passed
         - Display the number of FPS and reset the counter to ZERO




          */
    }

    private void tick() {

    }

    private void render() {
        BufferStrategy bufferStrategy = this.getBufferStrategy();
        if (bufferStrategy == null) {
            this.createBufferStrategy(3);//how many buffers it creates
            return;
        }

        Graphics graphics = bufferStrategy.getDrawGraphics();
        graphics.setColor(Color.red);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);

        graphics.dispose();
        bufferStrategy.show();

    }

    public static void main(String[] args) {
        new Game();
    }
}
