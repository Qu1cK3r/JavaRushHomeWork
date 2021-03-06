package com.javarush.test.level19.lesson10.home04;

import java.util.*;
import java.io.*;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words
Закрыть потоки. Не использовать try-with-resources

Пример: words содержит слова А, Б, В
Строки:
В Б А Д  //3 слова из words, не подходит
Д А Д    //1 слово из words, не подходит
Д А Б Д  //2 слова - подходит, выводим
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader file = new BufferedReader(new FileReader(r.readLine()));
            r.close();
            while(file.ready()) {
                String line = file.readLine();
                String[] strings = line.split("\\s");
                int count = 0;
                for (String string : strings)
                {
                    if(words.contains(string)) {
                        count++;
                    }
                }
                if(count == 2) {
                    System.out.println(line);
                }
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
