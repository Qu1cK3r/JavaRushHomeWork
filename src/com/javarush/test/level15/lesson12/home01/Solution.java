package com.javarush.test.level15.lesson12.home01;


import java.io.*;
import java.util.IllegalFormatException;

/* Разные методы для разных типов
1. Считать с консоли данные, пока не введено слово "exit".
2. Для каждого значения, кроме "exit", вызвать метод print. Если значение:
2.1. содержит точку '.', то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
            String s = br.readLine();
            try
            {
                if (s.contains("."))
                {
                    print(Double.valueOf(s));
                    break;
                }
                if (Integer.valueOf(s) > 0 && Integer.valueOf(s) < 128) print(Short.valueOf(s));
            /*if (Integer.valueOf(s) >= 128)*/
                else print(Integer.valueOf(s));
            }
            catch (Exception e)
            {
                if (s.equals("exit")) System.exit(0);
                else print(s);
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
