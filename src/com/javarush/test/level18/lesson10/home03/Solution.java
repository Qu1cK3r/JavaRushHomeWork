package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое
третьего файла
Закрыть потоки. Не использовать try-with-resources
*/
import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream file1 = new FileOutputStream(br.readLine());
        FileInputStream file2 = new FileInputStream(br.readLine());
        FileInputStream file3 = new FileInputStream(br.readLine());

        byte[] buffer = new byte[file2.available()];
        int count = file2.read(buffer);
        file1.write(buffer, 0, count);

        byte[] buffer2 = new byte[file3.available()];
        int count2 = file3.read(buffer2);
        file1.write(buffer2, 0, count2);

        br.close();
        file1.close();
        file2.close();
        file3.close();
    }
}
