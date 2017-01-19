package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/
import java.io.*;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws  IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileName1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileName2 = new BufferedWriter(new FileWriter(reader.readLine()));
        reader.close();

        String buffer="";
        while(fileName1.ready()){
            buffer+=fileName1.readLine();
        }
        fileName1.close();
        String[] mass = buffer.split(" ");
        double[] chis = new double[mass.length];
        String result="";
        for (int i=0;i<mass.length;i++){
            chis[i] = Double.parseDouble(String.format(Locale.ENGLISH,"%.2f", Double.parseDouble(mass[i])));
            result+=Math.round(chis[i])+" ";
        }
        fileName2.write(result.substring(0,result.length()-1));
        fileName2.close();
    }
}
