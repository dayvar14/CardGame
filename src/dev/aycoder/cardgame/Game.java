package dev.aycoder.cardgame;

import dev.aycoder.cardgame.display.Display;
import dev.aycoder.cardgame.gfx.Assets;
import dev.aycoder.cardgame.gfx.ImageLoader;
import dev.aycoder.cardgame.gfx.SpriteSheet;

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
    }

    private void tick()
    {

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
        BufferedImage sprite = Assets.cardImages[3][3];
        g.drawImage( sprite, 0, 0, null);
        //End of Drawing
        bs.show();
        g.dispose();
    }
    @Override
    public void run()
    {
        init();

        while( running == true)
        {
            tick();
            render();
        }

        stop();
    }
}
