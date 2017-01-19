package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/
import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        FileInputStream readOne = new FileInputStream(fileName1);
        byte[] bytes1 = new byte[readOne.available()];
        readOne.read(bytes1);
        readOne.close();

        FileOutputStream writeOne = new FileOutputStream(fileName1);
        FileInputStream readTwo = new FileInputStream(fileName2);
        byte[] bytes2 = new byte[readTwo.available()];
        readTwo.read(bytes2);
        writeOne.write(bytes2);
        writeOne.flush();
        readTwo.close();

        writeOne.write(bytes1);
        writeOne.flush();
        writeOne.close();
    }
}
