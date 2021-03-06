package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class TestOrder extends Order {

    public TestOrder(Tablet tablet) throws IOException {
        super(tablet); }

    @Override
    protected void initDishes() throws IOException {
        ConsoleHelper.writeMessage(Dish.allDishesToString());
        this.dishes = new ArrayList<>();
        int numRandom = ThreadLocalRandom.current().nextInt(1,Dish.values().length);
        if (numRandom==0){numRandom=1;}
        Dish[] dishMas = Dish.values();
        for(int i = 0; i < numRandom; i++){
            int random = (int)(Math.random() * (Dish.values().length));
            dishes.add(dishMas[random]);
        }
    }
}