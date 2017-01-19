package com.javarush.test.level08.lesson11.home04;

import java.io.*;
import java.util.*;

/* Минимальное из N чисел
1. Ввести с клавиатуры число N.
2. Считать N целых чисел и заполнить ими список - метод getIntegerList.
3. Найти минимальное число среди элементов списка - метод getMinimum.
*/

public class Solution
{
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
       // System.out.println(integerList);
    }

    public static int getMinimum(List<Integer> array) {
        // Найти минимум
        Iterator<Integer> it = array.iterator();
        int min = it.next();
        while(it.hasNext()){
            int x =it.next();
            if (x<min)
                min = x;
        }
        /*
        for(int i=0;i<array.size();){
            if (array.get(i)<min)
                min = array.get(i);
            i++;
        }*/
        return min;
    }

    public static List<Integer> getIntegerList() throws IOException {
        //Тут создать и заполнить список
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] nums = br.readLine().split(" ");
        List<Integer> list = new LinkedList<Integer>();
        for(int i =0;i<n;i++){

            list.add(Integer.valueOf(nums[i]));
        }
        return list;
      /*  int n = Integer.parseInt(br.readLine());
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++)
        {
            list.add(Integer.parseInt(br.readLine()));
        }
        return list;*/
    }
}
