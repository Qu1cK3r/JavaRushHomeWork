package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/
import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(br.readLine());
        FileOutputStream outs2 = new FileOutputStream(br.readLine());
        FileOutputStream outs3 = new FileOutputStream(br.readLine());

            byte[] buffer = new byte[fis.available()];
            int count = fis.read(buffer);
            if (count % 2 == 0) {
                outs2.write(buffer, 0, count / 2);
                outs3.write(buffer,count - count / 2 , count/2);
            }else {
                outs2.write(buffer, 0, count / 2 + 1);
                outs3.write(buffer,count - (count / 2 + 1), count - (count / 2 + 1));
            }
        br.close();
        fis.close();
        outs2.close();
        outs3.close();
    }
}
