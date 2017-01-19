package com.javarush.test.level18.lesson03.task03;

import java.io.*;
import java.util.*;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = br.readLine();
        FileInputStream fis = new FileInputStream(fileName);
        Map<Integer,Integer> map = new HashMap<>();
        while(fis.available()>0){
            int inputKey = fis.read();
            if(!map.containsKey(inputKey)) map.put(inputKey,1);
                else map.put(inputKey,map.get(inputKey)+1);
        }
        br.close();
        fis.close();


        int keyOfMaxValue = 0;
        int maxValue = 0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue()>maxValue) {
                maxValue=entry.getValue();
                keyOfMaxValue = entry.getKey();
            }
        }
        String result = "";
        result += keyOfMaxValue;

        System.out.println(result);
    }
}
