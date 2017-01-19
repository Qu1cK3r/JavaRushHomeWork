package com.javarush.test.level14.lesson06.home01;

public class MoldovanHen extends Hen
{
    private int N = 10;
    @Override
    public int getCountOfEggsPerMonth(){
        N = 20;
        return N;
    }
    @Override
    public String getDescription(){
        return super.getDescription() + " Моя страна - " +Country.MOLDOVA+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
