package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1 = args[0];
        String file2 = args[1];
        BufferedReader br = new BufferedReader(new FileReader(file1));
        FileWriter fwr = new FileWriter(file2);
        String line ="";
        String outStr="";
        while (br.ready()){
            line = br.readLine();
            String [] lineDig = line.split(" ");
            for (String strIter : lineDig){
                if(strIter.length()>6)
                    outStr += strIter+",";
            }
        }
        fwr.write(outStr.substring(0,outStr.length()-1));

        br.close();
        fwr.close();
    }
}
