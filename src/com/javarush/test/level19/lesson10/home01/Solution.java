package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader; import java.io.FileReader; import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = args[0];
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
    Map<String,Double> people = new TreeMap<>();

    while (reader.ready())
    {
        char[] chars = reader.readLine().toCharArray();
        String name = "";
        double number = 0;
        String tempStr = "";
        for (int i=0;i<chars.length;i++)
        {
            if (chars[i] != ' ')
            {
                tempStr += chars[i];
            }
            else if (name.equals(""))
            {
                name = tempStr;
                tempStr = "";
            }
        }
        number = Double.parseDouble(tempStr);
        if (people.containsKey(name))
        {
            double tempnum = people.get(name) + number;
            people.put(name, tempnum);
        }
        else
            people.put(name,number);
    }
    for (Map.Entry<String,Double> element : people.entrySet())
        System.out.println(element.getKey()+" "+element.getValue());
    reader.close();
}
}