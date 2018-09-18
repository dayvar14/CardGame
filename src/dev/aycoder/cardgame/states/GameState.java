package dev.aycoder.cardgame.states;

import dev.aycoder.cardgame.gfx.Assets;

import java.awt.*;

public class GameState extends State
{
    public GameState()
    {

    }
    @Override
    public void tick()
    {

    }

    @Override
    public void render(Graphics g)
    {
        g.drawImage(Assets.cardImages[13][3],0, 0, null);
    }
}
