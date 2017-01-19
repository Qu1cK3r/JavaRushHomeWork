package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/
import java.io.*;

public class Solution
{


    public static void main(String[] args) throws IOException
    {
        FileInputStream fis = new FileInputStream(args[0]);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int letterAmount=0, byteSymbol;
        while ((byteSymbol=fis.read())!=-1) {
            if (alphabet.contains((char)byteSymbol + ""))
                letterAmount++;
        }
        fis.close();
        System.out.println(letterAmount);

    }
}