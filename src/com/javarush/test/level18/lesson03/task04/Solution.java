package com.javarush.test.level18.lesson03.task04;

import java.io.*;
import java.util.*;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
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


        int keyOfMinValue = 0;
        int minValue = Integer.MAX_VALUE;
        String result = "";
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue()<minValue) {
                minValue=entry.getValue();
                keyOfMinValue = entry.getKey();
             }
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
            if (entry.getValue() == minValue)
                result += entry.getKey() + " ";
        }
        System.out.println(result);
    }
}
