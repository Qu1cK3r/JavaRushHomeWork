package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и
вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        //напишите тут ваш код
       /* ArrayList<String>[] arraystring = new ArrayList[3];
        ArrayList<String> a1 = new ArrayList<String>();
        ArrayList<String> a2 = new ArrayList<String>();
        ArrayList<String> a3 = new ArrayList<String>();
        for(int i=0;i<4;i++)   a1.add("qwe"+ i );
        for(int i=0;i<4;i++)   a2.add("asd"+ i );
        for(int i=0;i<4;i++)   a3.add("zxc"+ i );

        arraystring[0] = a1;
        arraystring[1] = a2;
        arraystring[2] = a3;

        return arraystring;*/
        ArrayList<String>[] list = new ArrayList[3];
        for (int i = 0; i < 3; i++) {
            ArrayList<String> a = new ArrayList<String>();
            for (int j = 0; j < 5; j++)
                a.add(i + "-й массив " + j + "-я строка");
            list[i] = a;
        }
        return list;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}