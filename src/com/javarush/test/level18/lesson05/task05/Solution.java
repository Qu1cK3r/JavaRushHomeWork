package com.javarush.test.level18.lesson05.task05;

/* DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть потоки
2.2 выбросить исключение DownloadException
*/
import java.io.*;
public class Solution {
    public static void main(String[] args) throws DownloadException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{

            File f;

            while(true){
                f= new File(br.readLine());
                if (f.length() < 1000) {
                    br.close();
                    throw new DownloadException();
                }
            }

        }catch(IOException e) {
            System.out.println("not a file or folder");
        }



    }

    public static class DownloadException extends Exception{

    }
}
