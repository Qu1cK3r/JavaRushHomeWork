package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/
import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(br.readLine());
        FileOutputStream outs = new FileOutputStream(br.readLine());

        byte[] buffer = new byte[fis.available()];
        byte [] reffub = new byte[fis.available()];
        int count = fis.read(buffer);
        for(int index = count-1; index>=0;index--) {
            reffub[count - 1 - index] = buffer[index];
        }
        outs.write(reffub);


        br.close();
        fis.close();
        outs.close();
    }

}
