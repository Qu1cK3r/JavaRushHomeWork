package com.javarush.test.level21.lesson16.big01;


import java.util.ArrayList;
import java.util.Collections;

public class Hippodrome
{
    public static Hippodrome game;
    ArrayList<Horse> horses = new ArrayList<>();

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }
    public void run() throws InterruptedException{
        for(int i=0;i<100;i++){
            move();
            print();
            Thread.sleep(200);

        }
    }
    public void move(){
        for(Horse itH : horses){
            itH.move();
        }
    }
    public void print(){
        for(Horse itH : horses){
            itH.print();
            System.out.println();
            System.out.println();
        }
    }

    public Horse getWinner() {
        double dis=0;
        Horse winner=null;
        for (Horse horse : getHorses()){
            if (horse.getDistance() > dis) {
                dis=horse.getDistance();
                winner=horse;
            }
        }
        return winner;
    }
    public void printWinner(){
        System.out.println("Winner is "+getWinner().getName()+"!");
    }
    public static void main(String[] args) throws InterruptedException
    {
        game = new Hippodrome();
        Horse horse1 = new Horse("Sleven",3,0);
        Horse horse2 = new Horse("Lucky",3,0);
        Horse horse3 = new Horse("Bartholomew",3,0);
        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);

        game.run();
        game.printWinner();
    }
}
