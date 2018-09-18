package dev.aycoder.cardgame;

import dev.aycoder.cardgame.display.Display;

public class Launcher
{
    public static void main(String[] args)
    {
       Game game = new Game( "Card Game", 512, 512);
       game.start();
    }
}
