package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, String> map = new HashMap<String, String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = fileReader.readLine()) != null)
            map.put(line.substring(0, 8), line.substring(8));
        fileReader.close();
        String id = args[1];
        String price = args[args.length - 2];
        String quantity = args[args.length - 1];
        String productName = "";
        for (int i = 2; i < args.length - 2; i++)
            productName += args[i] + " ";
        String key = String.format("%-8s", id);
        String value = String.format("%-30s%-8s%-4s", productName, price, quantity);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey().equals(key)) {
                if (args[0].equals("-u")) map.put(key, value);
                //if (args[0].equals("-d")) map.remove(key);
            }
        }
        Iterator<Map.Entry<String,String>> it = map.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry<String,String> s = it.next();
            if (s.getKey().equals(key)) {
                if (args[0].equals("-d")) it.remove();
            }
        }
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName));
        for (Map.Entry<String, String> entry : map.entrySet()) {
            fileWriter.write(entry.getKey() + entry.getValue());
            fileWriter.newLine();
        }
        fileWriter.close();
    }
}
