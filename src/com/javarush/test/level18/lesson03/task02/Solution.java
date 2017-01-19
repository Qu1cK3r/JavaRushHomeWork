package com.javarush.test.level18.lesson03.task02;

import java.io.*;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        FileInputStream fis = new FileInputStream(fileName);
        int min = Integer.MAX_VALUE;
        while(fis.available()>0){
            int data = fis.read();
            if (data<min) min = data;
        }
        br.close();
        fis.close();
        System.out.println(min);
    }
}
