package com.javarush.test.level04.lesson16.home02;

import java.io.*;
import java.util.Arrays;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)  throws Exception
    {
        //напишите тут ваш код
      /*  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] nums = br.readLine().split(" ");
        Arrays.sort(nums);
        System.out.println(nums[1]);*/
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int d = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        int y = Integer.parseInt(reader.readLine());
        if(d<m && d>y || d>m && d<y){
            System.out.println(d);}
        if(m<d && m>y || m>d && m<y){
            System.out.println(m);}
        if(y<m && y>d || y>m && y<d){
            System.out.println(y);}

    }
}
