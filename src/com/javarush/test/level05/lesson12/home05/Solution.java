package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма».
Вывести на экран полученную сумму.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        String tmp = null;
        int sum = 0;
        while (true){
            tmp = b.readLine();
            if (tmp.equalsIgnoreCase("сумма")){
                System.out.print(sum);
                break;
            }
            sum += Integer.parseInt(tmp);
        }
    }
}