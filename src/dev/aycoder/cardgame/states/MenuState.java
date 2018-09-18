package dev.aycoder.cardgame.states;

import dev.aycoder.cardgame.gfx.Assets;

import java.awt.*;

public class MenuState extends State
{
    public MenuState()
    {

    }

    @Override
    public void tick()
    {

    }

    @Override
    public void render(Graphics g)
    {
        g.drawImage(Assets.cardImages[3][12], 0, 0, null);
    }
}
