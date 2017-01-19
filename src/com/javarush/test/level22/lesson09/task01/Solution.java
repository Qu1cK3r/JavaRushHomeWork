package com.javarush.test.level22.lesson09.task01;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.*;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        StringBuilder sb = new StringBuilder("");
        FileReader fileReader = new FileReader(fileName);
        while (fileReader.ready())
        {
            sb.append((char) fileReader.read());
        }
        String line = sb.toString().replace(System.lineSeparator()," ");
        String[] words = line.split(" ");
        for (int i = 0; i < words.length; i++)
        {
            for (int j = i + 1; j < words.length; j++)
            {
                if (words[i] == null ) break;
                if (words[j]==null) continue;
                if (words[i].equals(new StringBuilder(words[j]).reverse().toString()))
                {
                    result.add(new Pair());
                    result.get(result.size() - 1).first = words[i];
                    result.get(result.size() - 1).second = words[j];
                    words[i] = null;
                    words[j] = null;
                }
            }
        }
         for (Pair p : result) System.out.println(p);
        reader.close();
        fileReader.close();
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
