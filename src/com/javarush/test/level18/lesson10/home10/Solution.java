package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        String result = "";
        String fileName;
        while (true)
        {
            fileName = reader.readLine();
            if ("end".equals(fileName))
            {
                break;
            }
            else
            {
                list.add(fileName);
            }
            result = fileName.substring(0, fileName.lastIndexOf('.'));
        }
        reader.close();

        Collections.sort(list);

        FileOutputStream  fileOutputStream = new FileOutputStream(result, true);
        for (String name : list)
        {
            FileInputStream fileInputStream = new FileInputStream(name);
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            fileInputStream.close();

            fileOutputStream.write(buffer);


        }
        fileOutputStream.close();

    }
}
