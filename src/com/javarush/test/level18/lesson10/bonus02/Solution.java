package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        if(args.length>=4){
            if(args[0].equals("-c")){
                FileOutputStream file = new FileOutputStream(fileName,true);
                String prName="";
                String data="";
                for (int i=1;i<args.length-2;i++){
                    prName = prName+args[i]+" ";
                }
/*
                if(getId(fileName)==1) {
                    data = setSpace(getId(fileName).toString(), 8) + setSpace(prName, 30) + setSpace(args[args.length - 2], 8) + setSpace(args[args.length - 1], 4);
                }else {
                    data =  System.lineSeparator() + setSpace(getId(fileName).toString(), 8) + setSpace(prName, 30) + setSpace(args[args.length - 2], 8) + setSpace(args[args.length - 1], 4);
                }
*/
                data = setSpace(getId(fileName).toString(), 8) + setSpace(prName, 30) + setSpace(args[args.length - 2], 8) + setSpace(args[args.length - 1], 4);
                file.write(data.getBytes());
                file.close();
            }
        }
        reader.close();
    }
    public static Long getId (String fileName) throws IOException {
        String[] list1 = new String[0];
        ArrayList<Long> list = new ArrayList<Long>();
        FileInputStream file = new FileInputStream(fileName);
        String s1 ="";
        Long max = Long.valueOf(0);
        while (file.available()>0){
            char s = (char)file.read();
            s1 = s1 + Character.toString(s);
            list1=  s1.split("\n");
        }
        for (String n:list1){
            n = n.substring(0,8);
            n= n.trim();
            list.add(Long.valueOf(n));
        }
        if(list.size()>0) {
            max = Collections.max(list);
        }
        file.close();
        return max+1;
    }
    public static String setSpace(String s, int count){
        while (s.length()<count){
            s=s+" ";
        }
        while (s.length()>count){
            s = s.substring(0,s.length()-1);
        }
        return s;
    }
}
