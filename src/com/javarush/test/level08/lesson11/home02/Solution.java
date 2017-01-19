package com.javarush.test.level08.lesson11.home02;

import java.util.*;


/* Множество всех животных
1. Внутри класса Solution создать public static классы Cat, Dog.
2. Реализовать метод createCats, котороый должен возвращать множество с 4 котами.
3. Реализовать метод createDogs, котороый должен возвращать множество с 3 собаками.
4. Реализовать метод join, котороый должен возвращать объединенное множество всех животных
- всех котов и собак.
5. Реализовать метод removeCats, котороый должен удалять из множества pets всех котов, которые
есть в множестве cats.
6. Реализовать метод printPets, котороый должен выводить на экран всех животных, которые в нем
есть. Каждое животное с новой строки
*/

public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);
        System.out.println(" \n");
        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats()
    {
        HashSet<Cat> result = new HashSet<Cat>();

        //напишите тут ваш код
        result.add(new Cat());
        result.add(new Cat());
        result.add(new Cat());
        result.add(new Cat());
        return result;
    }

    public static Set<Dog> createDogs()
    {
        //напишите тут ваш код
        HashSet<Dog> res = new HashSet<Dog>();
        res.add(new Dog());
        res.add(new Dog());
        res.add(new Dog());

        return res;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs)
    {
        //напишите тут ваш код
        Set<Object> ccopy = new HashSet<Object>(cats);
       ccopy.addAll(dogs);
      /*  Set<Object> ccopy = new HashSet<Object>();//Написать тут ваш код
        ccopy.addAll(cats);
        ccopy.addAll(dogs);*/
        return ccopy;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats)
    {
        //напишите тут ваш код
      //  Set<Object> cpets = new HashSet<Object>(pets);
        Iterator<Cat> it = cats.iterator();
        while(it.hasNext()){

            pets.remove(it.next());
        }
    }

    public static void printPets(Set<Object> pets)
    {
        //напишите тут ваш код
        for(Object pet:pets)
            System.out.println(pet);
    }

    public static class Cat{}
    public static class Dog{}

    //напишите тут ваш код
}
