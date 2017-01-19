package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human).
 Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое
 детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при
выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/


import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        ArrayList<Human> list = new ArrayList<Human>();
        Human ded1 = new Human("ded1", true, 16, null,null);
        list.add(ded1);
        Human ded2 = new Human("ded2", true, 17, null,null);
        list.add(ded2);
        Human baba1 = new Human("baba1", false, 14, null,null);
        list.add(baba1);
        Human baba2 = new Human("baba2", false, 13, null,null);
        list.add(baba2);
        Human mom = new Human("mom", true, 77, ded1, baba1);
        list.add(mom);
        Human dad = new Human("dad", false, 88, ded2, baba2);
        list.add(dad);
        Human z1 = new Human("z1", true, 16, dad, mom);
        list.add(z1);
        Human z2 = new Human("z2", true, 26, dad, mom);
        list.add(z2);
        Human z3 = new Human("z3", true, 36, dad, mom);
        list.add(z3);




        for(Human h : list)
        System.out.println(h);
    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        Boolean sex;
        int age;
        Human father, mother;
    public Human(String name, boolean sex, int age, Human father, Human mother){
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.mother = mother;
        this.father = father;
    }
        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
