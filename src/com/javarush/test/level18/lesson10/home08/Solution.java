package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.*;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и
добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

/*public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        while (!fileName.equals("exit")){
            new ReadThread(fileName).start();
            fileName = reader.readLine();
        }
        reader.close();
        /for(Map.Entry el: resultMap.entrySet())
        //    System.out.println(el.getKey()+" "+el.getValue());

    }

    public static class ReadThread extends Thread {
        public  String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
          this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run()
        {
            try
            {
                FileInputStream file = new FileInputStream(fileName);
                byte[] bytes = new byte[file.available()];
                file.read(bytes);
                ArrayList<Byte> tmpBytes = new ArrayList<>();
                for (int i=0;i<bytes.length;i++){
                    tmpBytes.add(bytes[i]);
                }
                file.close();
                int max = 0;
                int result = 0;
                for (int i=0;i<tmpBytes.size();i++){
                    int count = Collections.frequency(tmpBytes, tmpBytes.get(i));
                    if (count>max) {
                        max = count;
                        result = tmpBytes.get(i);
                    }
                }
                synchronized (resultMap) {
                    resultMap.put(fileName, result);
                }



            }catch (IOException e){e.printStackTrace();}


        }

    }
}*/
public class Solution
{
    public static volatile Map<String, Integer> resultMap = new HashMap<String, Integer>();
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = reader.readLine()).equals("exit"))
        {
            new ReadThread(line).start();
        }
        reader.close();
    }
    public static class ReadThread extends Thread
    {
        Map<Integer, Integer> byteMap = new HashMap<>();
        String fileName;
        public ReadThread(String fileName) throws FileNotFoundException
        {
            this.fileName = fileName;
        }
        @Override
        public void run()
        {
            try
            {
                FileInputStream fos = new FileInputStream(fileName);
                int buf;
                while (fos.available() > 0)
                {
                    buf = fos.read();
                    if (!byteMap.containsKey(buf))
                        byteMap.put(buf, 1);
                    else
                        byteMap.put(buf, byteMap.get(buf) + 1);
                }
                fos.close();
                int maxValue = -1; int maxKey = -1;
                for (Map.Entry<Integer, Integer> entry:  byteMap.entrySet())
                {
                    if (entry.getValue() > maxValue)
                    {
                        maxValue = entry.getValue();
                        maxKey = entry.getKey();
                    }
                }
                resultMap.put(fileName, maxKey);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
