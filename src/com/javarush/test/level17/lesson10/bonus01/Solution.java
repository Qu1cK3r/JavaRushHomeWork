package com.javarush.test.level17.lesson10.bonus01;


import java.text.*;
import java.util.*;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/
public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    public static SimpleDateFormat oneFormat = new SimpleDateFormat("dd/MM/yyyy");
    public static SimpleDateFormat twoFormat = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }
    public static void main(String[] args) throws Exception{
        if(args.length < 2){
            return;
        }
        if(args[0].equals("-c")){
            argsIsC(args);
        }else if(args[0].equals("-u")){
            argsIsU(args);
        }else if(args[0].equals("-d")){
            argsIsD(args);
        }else if(args[0].equals("-i")){
            argsIsI(args);
        }
    }
    public static void argsIsC(String[] args) throws ParseException
    {
        String nameHuman = args[1];
        String sexHuman = args[2];
        Date bdHuman = oneFormat.parse(args[3]);
        Person newHuman;
        if(sexHuman.equals("м")){
            newHuman = Person.createMale(nameHuman,bdHuman);
        }else{
            newHuman = Person.createFemale(nameHuman,bdHuman);
        }
        allPeople.add(newHuman);
        System.out.println(allPeople.indexOf(newHuman));
    }
    public static void argsIsU(String[] args) throws ParseException
    {
        int idHuman = Integer.parseInt(args[1]);
        String nameHuman = args[2];
        String sexHuman = args[3];
        Date bdHuman = oneFormat.parse(args[4]);
        Person updatePerson = allPeople.get(idHuman);
        updatePerson.setName(nameHuman);
        if(sexHuman.equals("м")){
            updatePerson.setSex(Sex.MALE);
        } else
        {
            updatePerson.setSex(Sex.FEMALE);
        }
        updatePerson.setBirthDay(bdHuman);
    }
    public static void argsIsD(String[] args){
        int idHuman = Integer.parseInt(args[1]);
        Person nullPerson = allPeople.get(idHuman);
        nullPerson.setBirthDay(null);
    }
    public static void argsIsI(String[] args){
        int idHuman = Integer.parseInt(args[1]);
        Person person = allPeople.get(idHuman);
        String namePrintPerson = person.getName();
        String sex;
        if(person.getSex().equals(Sex.MALE)){
            sex = "м";
        }else {
            sex = "ж";
        }
        System.out.println(namePrintPerson + " " + sex + " " + twoFormat.format(person.getBirthDay()));
    }
}