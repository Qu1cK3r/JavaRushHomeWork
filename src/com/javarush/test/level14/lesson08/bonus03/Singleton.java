package com.javarush.test.level14.lesson08.bonus03;

public class Singleton
{
    private Singleton(){}
    private static Singleton instance;
    public static Singleton getInstance(){ // Метод getInstance
        if(instance == null){ // Если переменная пустая, мы создаем новый обьект, заносим в переменную..
            instance = new Singleton();
        }
        return instance; // И возвращаем его.
    }
}
