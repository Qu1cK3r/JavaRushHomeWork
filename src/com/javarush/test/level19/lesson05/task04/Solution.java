package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));
        String s1 = s.readLine();
        String s2 = s.readLine();
        s.close();
        FileReader f= new FileReader(s1);
        FileWriter f2 = new FileWriter(s2);
        char c;
        while (f.ready())
        {
            c = (char)f.read();
            if (c == 46) c= 33;
            f2.write(c);
        }
        f.close();f2.close();
    }
}
