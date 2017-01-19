package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args)
    {
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String fileToWrite = br.readLine();
            FileWriter fileWriter = new FileWriter(fileToWrite,false);
            String input="";
            while (!input.equals("exit"))
            {
                input = br.readLine();
                /*if (input.equals("exit"))
                {
                    break;
                }*/
                fileWriter.write(input);
                fileWriter.write(System.lineSeparator()); //
            }
            fileWriter.close();
          //  br.close();
        }catch (IOException e) {e.printStackTrace();}
    }
}
