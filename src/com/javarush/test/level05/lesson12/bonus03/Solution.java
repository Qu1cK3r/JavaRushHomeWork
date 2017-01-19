package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine()); //Число N
        int maximum; //Переменная максимума
        int numFromString; //Число вводимое с консоли
        while (n <= 0) //если N меньше 0, то вводим пока пока оно не станет больше 0
        {
            n = Integer.parseInt(reader.readLine());
        }
        BufferedReader readerN = new BufferedReader(new InputStreamReader(System.in)); //Читаем строку
        numFromString = Integer.parseInt(readerN.readLine()); //Преобразуем строку в число
        maximum = numFromString; //первое введенное число становится максимумом
        for (int i = 1; i < n; i++) //читаем остальные числа, если их всего больше одного
        {
            numFromString = Integer.parseInt(readerN.readLine());
            maximum = maxN(maximum, numFromString); //максимум между прежним максимумом и новым введенным числом
        }
        System.out.println(maximum);//вывод максимума на экран
    }
    public static int maxN(int a, int b){ //определение максимума среди двух чисел
        return a>b?a:b;
    }
}
