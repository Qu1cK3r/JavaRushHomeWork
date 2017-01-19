package com.javarush.test.level20.lesson10.bonus01;

/*Натуральное десятичное N - значное число называется числом Армстронга, если сумма его цифр,
возведенных в степень N, равна самому числу.

Примеры: 153 = 1^3 + 5^3 + 3^3 ; 1634 = 1^4 + 6^4 + 3^4 + 4^4.

Найти все числа Армстронга для 1<=N<=9.*/


import java.text.SimpleDateFormat;
import java.util.*;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
/*
    public static void main(String[]args) {
        long start = System.currentTimeMillis();
        int[] array = getNumbers(10000000);
        long end = System.currentTimeMillis() - start;
        long memore = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        SimpleDateFormat sdf = new SimpleDateFormat("ss.SSS");
        System.out.println("Time = " + sdf.format(new Date(end)));
        System.out.println("Memory = " + memore + " b");


        for (int a : array) {
            if (a != 0)
                System.out.print(a + " ");
        }
    }*/

    public static int[] getNumbers(int N) {
        ArrayList<Integer> list = new ArrayList<>();
        int mas[][]=new int[20][20],M,curr,sum;

        for (int ii=1;ii<20;ii++){
            for(int jj=1;jj<20;jj++){
                mas[ii][jj] = (int)Math.pow(ii,jj);
            }
        }

        for (int i = 1; i < N; i++) {
            M=(int)Math.log10(i)+1;
            curr=i;
            sum=0;



            while(curr != 0){
                sum+=mas[curr % 10][M];//Math.pow((curr % 10),M);
                curr/=10;
            }
            if (i==sum) list.add(i);
        }


        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            result[i] = list.get(i);
        return result;
    }
}