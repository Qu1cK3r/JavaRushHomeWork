package com.javarush.test.level08.lesson11.home01;

import java.util.*;


/* Set из котов
1. Внутри класса Solution создать public static класс кот – Cat.
2. Реализовать метод createCats, он должен создавать множество (Set) котов и добавлять в него 3
кота.
3. В методе main удалите одного кота из Set cats.
4. Реализовать метод printCats, он должен вывести на экран всех котов, которые остались во
 множестве. Каждый кот с новой строки.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();

        //напишите тут ваш код. пункт 3
        Iterator<Cat> iterator = cats.iterator() ;
        Cat cat = iterator.next() ;
        iterator.remove() ;
        printCats(cats);
    }

    public static Set<Cat> createCats()
    {
        //напишите тут ваш код. пункт 2
        Set<Cat> cset = new HashSet<Cat>();
        //for(int c=0;c<3;c++)
        cset.add(new Cat());
        cset.add(new Cat());
        cset.add(new Cat());
        return cset;
    }

    public static void printCats(Set<Cat> cats)
    {
        // пункт 4
        for(Cat c : cats)
            System.out.println(c);
    }

    // пункт 1
    public static class Cat{
      //  Cat(){}
    }
}
