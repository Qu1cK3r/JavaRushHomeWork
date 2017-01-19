package com.javarush.test.level07.lesson12.home02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Переставить M первых строк в конец списка
Ввести с клавиатуры 2 числа N  и M.
Ввести N строк и заполнить ими список.
Переставить M первых строк в конец списка.
Вывести список на экран, каждое значение с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //напишите тут ваш код
        int n = Integer.valueOf(reader.readLine());
        int m = Integer.valueOf(reader.readLine());
        ArrayList<String> list = new ArrayList<String>();
        for (int i=0;i<n;i++)
            list.add(reader.readLine());
        if(m<n){
            for (int i=0;i<m;i++) {
                list.add(list.get(0));  //берем первую строчку и вставляем ее в конец
                list.remove(0);         //удаляем первую строчку. И так по кругу
            }
        }


    for(String s : list)
        System.out.println(s);
    }
}
