package com.javarush.test.level18.lesson03.task05;

import java.io.*;
import java.util.*;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        FileInputStream fis = new FileInputStream(fileName);
        List<Integer> sortBytes = new ArrayList<>();
        int readB;
        while(fis.available()>0){
            readB = fis.read();
           if(!sortBytes.contains(readB)) sortBytes.add(readB);
        }
        br.close();
        fis.close();
        Collections.sort(sortBytes);
        Object[] sb = sortBytes.toArray();
        for (Object i : sb)
        System.out.print(i.toString()+" ");
    }
}
