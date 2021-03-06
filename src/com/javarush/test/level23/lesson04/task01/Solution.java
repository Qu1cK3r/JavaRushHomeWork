package com.javarush.test.level23.lesson04.task01;

/* Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution[] arr = new Solution[2];
        arr[0] = new Solution();
        arr[1] = new Solution();
        arr[0].innerClasses[0] = arr[0].new InnerClass();
        arr[0].innerClasses[1] = arr[0].new InnerClass();
        arr[1].innerClasses[0] = arr[1].new InnerClass();
        arr[1].innerClasses[1] = arr[1].new InnerClass();
        return arr;
    }
}
