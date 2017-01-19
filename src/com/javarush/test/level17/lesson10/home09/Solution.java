package com.javarush.test.level17.lesson10.home09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все
строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    public static String firstFileName;
    public static String secondFileName;
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String dataA="",dataR="";
        try {
            firstFileName = br.readLine();
            secondFileName = br.readLine();
            br = new BufferedReader(new FileReader(firstFileName));

            while((dataA=br.readLine())!=null){
                allLines.add(dataA);
            }
            br = new BufferedReader(new FileReader(secondFileName));
            while((dataR=br.readLine())!=null){
                forRemoveLines.add(dataR);
            }
           new Solution().joinData();
            br.close();

        }catch(Exception e){}
    }

    public synchronized void joinData () throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) allLines.removeAll(forRemoveLines);
        else  allLines.clear();
        throw new CorruptedDataException();
    }
}
