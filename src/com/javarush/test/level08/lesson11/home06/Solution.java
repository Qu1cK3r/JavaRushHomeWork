package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое
детей.
3. Вывести все объекты Human на экран.
*/

import java.util.*;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        ArrayList<Human> ch= new ArrayList<Human>();
        ch.add(new Human("sdf",true,3, new ArrayList<Human>()));
        ch.add(new Human("sdd",true,3,new ArrayList<Human>()));
        ch.add(new Human("sd",true,3,new ArrayList<Human>()));
        Human f = new Human("pap",true,3,ch);
        Human m = new Human("mam",false,3,ch);
        ArrayList<Human> papmam= new ArrayList<Human>();
        papmam.add(f);
        papmam.add(m);
        Human gf1 = new Human("ded1",true,3,papmam);
        Human gf2 = new Human("ded2",true,3,papmam);
        Human gm1 = new Human("bab1",false,3,papmam);
        Human gm2 = new Human("bab2",false,3,papmam);
        for(Human h : papmam)
            System.out.println(h);
        for(Human c : ch)
            System.out.println(c);
        System.out.println(gf1);
        System.out.println(gf2);
        System.out.println(gm1);
        System.out.println(gm2);
    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children ;//= new ArrayList<Human>();
      //  Human(String name, boolean sex, int age){}
        Human(String name, boolean sex, int age, ArrayList<Human> children){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }
        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
