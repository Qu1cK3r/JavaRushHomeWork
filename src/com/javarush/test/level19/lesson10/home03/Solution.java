package com.javarush.test.level19.lesson10.home03;

import java.util.*;
import java.io.*;


/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String s;
        String w = "";
        while ((s = reader.readLine()) != null) {
            w = "";
            String[] q = s.split(" ");
            Calendar c = new GregorianCalendar(Integer.parseInt(q[q.length - 1]),     Integer.parseInt(q[q.length - 2]) - 1, Integer.parseInt(q[q.length - 3]));
            Date date = c.getTime();
            System.out.println(c.get(Calendar.DATE));
            for (int i = 0; i < q.length - 3; i++) {
                w = w + q[i] + " ";
            }
            PEOPLE.add(new Person(w.trim(), date));
        }
        reader.close();
    }

}
