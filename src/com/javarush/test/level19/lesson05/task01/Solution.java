package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        FileWriter fileWriter = new FileWriter(reader.readLine());
        int count = 0;
        while(fileReader.ready())
        {
            int data = fileReader.read();
            if((count != 0) && (count%2 == 1))
            {
                fileWriter.write(data);
            }
            count++;
        }
        fileWriter.close();
        fileReader.close();
        reader.close();
    }
}
