package com.javarush.test.level14.lesson08.home05;



public class Computer
{
    private Keyboard kb;
    private Mouse mice;
    private Monitor scr;
    public Computer()
    {
        kb = new Keyboard();
        mice = new Mouse();
        scr= new Monitor();
    }

    public Keyboard getKeyboard()
    {
        return kb;
    }

    public Mouse getMouse()
    {
        return mice;
    }

    public Monitor getMonitor()
    {
        return scr;
    }
}
