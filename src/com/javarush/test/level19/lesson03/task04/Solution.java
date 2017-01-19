package com.javarush.test.level19.lesson03.task04;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод
read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner sc;
        public PersonScannerAdapter(Scanner sc)
        {
            this.sc = sc;
        }

        @Override
        public void close() throws IOException
        {
            this.sc.close();
        }

        @Override
        public Person read() throws IOException
        {
            String[] lines = this.sc.nextLine().split(" ");
            Calendar c = new GregorianCalendar(Integer.parseInt(lines[5]) , Integer.parseInt(lines[4]) - 1, Integer.parseInt(lines[3]));
            Person person = new Person(lines[1], lines[2], lines[0], c.getTime());
            return person;
        }
    }
}
