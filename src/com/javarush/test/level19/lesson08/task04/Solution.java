package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/
import java.io.*;
public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        testString.printSomething();
        System.setOut(consoleStream);

        String result[] = outputStream.toString().split(" ");

        int a = Integer.parseInt(result[0]);
        int b = Integer.parseInt(result[2]);

          if(result[1].equals("+")) System.out.println(a + " + " + b + " = " + (a + b));
        else if(result[1].equals("-")) System.out.println(a + " - " + b + " = " + (a - b));
        else if (result[1].equals("*")) System.out.println(a + " * " + b + " = " + (a * b));


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

