package com.javarush.test.level18.lesson03.task01;

import java.io.*;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        FileInputStream fis = new FileInputStream(fileName);
        int max = 0;
        while(fis.available()>0){
            int data = fis.read();
            if (data>max) max = data;
        }
        br.close();
        fis.close();
        System.out.println(max);
    }
}
