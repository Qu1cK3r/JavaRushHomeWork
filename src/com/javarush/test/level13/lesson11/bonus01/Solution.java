package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args)
    {
        // напишите тут ваш код
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader readFile = new BufferedReader(new FileReader(br.readLine()));
            ArrayList<Integer> nums= new ArrayList<>();
            while (readFile.ready())
            {
                int tmp = Integer.parseInt(readFile.readLine());
                if (tmp%2 == 0) nums.add(tmp);
            }
            Collections.sort(nums);
            for(Integer num : nums)
            System.out.println(num);
        }catch (IOException e) {e.printStackTrace();}
    }
}
