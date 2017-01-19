package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        int count=0;
        String line = "",linereplaceAll;
        while(file.ready())
        {
            line = file.readLine();
            linereplaceAll = line.replaceAll("\\p{Punct}", " ");
            String[]massLine = linereplaceAll.split(" ");
            for (String str : massLine){
                if (str.equals("world")){
                    count++;}
            }
        }


        System.out.println(count);
        file.close();

    }
}
