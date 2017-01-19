package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.List;

public class Order
{
    protected  List<Dish> dishes;
    private Tablet tablet;

    public Order(Tablet tablet) throws IOException
    {
        this.tablet = tablet;
        initDishes();
    }

    protected void initDishes() throws IOException {
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }


    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    public int getTotalCookingTime() {

        int totalTime = 0;

        for (int i = 0; i < dishes.size(); i++) {
            totalTime += dishes.get(i).getDuration();
        }

        return totalTime;

    }

    @Override
    public String toString()
    {
        return dishes.isEmpty() ? "" : "Your order: " + dishes.toString() +" of "+  tablet.toString();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public Tablet getTablet() {
        return tablet;
    }

}
