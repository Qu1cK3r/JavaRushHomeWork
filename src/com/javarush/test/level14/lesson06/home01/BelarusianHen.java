package com.javarush.test.level14.lesson06.home01;

public class BelarusianHen extends Hen
{
    private int N = 10;
    @Override
    public int getCountOfEggsPerMonth(){

        return N;
    }
    @Override
    public String getDescription(){
        return super.getDescription() + " Моя страна - " +Country.BELARUS+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
}
