package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &,
 например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) {
        //add your code here
try{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String allArguments = s.substring(s.indexOf("?") + 1);
        String[] parsed = allArguments.split("&");
        for (int i = 0; i < parsed.length; i++) {
            String[] currentArgArr = parsed[i].split("=");
        System.out.print(currentArgArr[0] + " ");

        }
        System.out.println();
        for (int i = 0; i < parsed.length; i++) {
            String[] currentArgArr = parsed[i].split("=");
            if(currentArgArr[0].equals("obj")){
                try{
                   alert((Double.parseDouble(currentArgArr[1])));
                }catch(NumberFormatException e){
                    alert(currentArgArr[1]);
                }
            }
        }
    }catch(Exception e){
e.printStackTrace();
}
    }
    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
