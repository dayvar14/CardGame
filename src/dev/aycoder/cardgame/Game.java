package dev.aycoder.cardgame;

import dev.aycoder.cardgame.display.Display;
import dev.aycoder.cardgame.gfx.Assets;
import dev.aycoder.cardgame.gfx.ImageLoader;
import dev.aycoder.cardgame.gfx.SpriteSheet;
import dev.aycoder.cardgame.states.GameState;
import dev.aycoder.cardgame.states.MenuState;
import dev.aycoder.cardgame.states.State;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable
{
    private Display display;
    public int width;
    public int height;
    public String title;

    private Thread thread;
    private boolean running = false;

    private BufferStrategy bs;
    private Graphics g;

    //States
    private State gameState;
    public Game( String title, int width, int height)
    {
        this.width = width;
        this.height = height;
    }

    public synchronized void start()
    {
        if( running == true)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop()
    {
        if( running == false)
            return;
        running = false;
        try
        {
            thread.join();
        }
        catch( InterruptedException ie)
        {
            ie.printStackTrace();
        }

    }

    private void init()
    {
        display = new Display( title, width, height);
        Assets.init();

        MenuState menuState = new MenuState();
        GameState gameState = new GameState();
        State.setState(menuState);
    }


    private void tick()
    {
        if(State.getState() != null)
        {
            State.getState().tick();
        }

    }

    private void render()
    {
        Canvas canvas = display.getCanvas();
        bs = canvas.getBufferStrategy();
        if( bs == null)
        {
            canvas.createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clears Screen
        g.clearRect( 0, 0, width, height);
        //Draw Here
        if(State.getState() != null)
        {
            State.getState().render(g);
        }
        //End of Drawing
        bs.show();
        g.dispose();
    }
    @Override
    public void run()
    {
        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long nowTime;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while( running == true)
        {
            nowTime = System.nanoTime();
            delta += ( nowTime - lastTime) / timePerTick;
            timer += nowTime - lastTime;
            lastTime = nowTime;
            if (delta >= 1)
            {
                tick();
                render();
                ticks++;
                delta--;
            }

            if( timer >= 1000000000)
            {
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop();
    }
}
