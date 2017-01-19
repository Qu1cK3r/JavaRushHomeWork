package com.javarush.test.level22.lesson13.task03;

/* Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')'  , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true

+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(", need FALSE - " + checkTelNumber(""));
        System.out.println("null, need FALSE - " + checkTelNumber(null));
        System.out.println("+313450--531202, need FALSE - " + checkTelNumber("+313450--531202"));
        System.out.println("+38(05)1234567, need FALSE - " + checkTelNumber("+38(05)1234567"));
        System.out.println("(3)80501234567, need FALSE - " + checkTelNumber("(3)80501234567"));
        System.out.println("(380)501234567, need FALSE - " + checkTelNumber("(380)501234567"));
        System.out.println("(380)501-234567, need FALSE - " + checkTelNumber("(380)501-234567"));
        System.out.println("(38-0)501234567, need FALSE - " + checkTelNumber("(38-0)501234567"));
        System.out.println("380-(501)234567, need FALSE - " + checkTelNumber("380-(501)234567"));
        System.out.println("380(50-1)234567, need FALSE - " + checkTelNumber("380(50-1)234567"));
        System.out.println("380(501)(23)4567, need FALSE - " + checkTelNumber("380(501)(23)4567"));
        System.out.println("+38050123(456)76, need FALSE - " + checkTelNumber("+38050123(456)76"));///
        System.out.println("+38050123(456)768, need FALSE - " + checkTelNumber("+38050123(456)768"));///
        System.out.println("+38050123(456)7685, need FALSE - " + checkTelNumber("+38050123(456)7685"));///
        System.out.println("+380501234(567), need FALSE - " + checkTelNumber("+380501234(567)"));
        System.out.println("3-805-0123-45, need FALSE - " + checkTelNumber("3-805-0123-45"));
        System.out.println("-3805-012345, need FALSE - " + checkTelNumber("-3805-012345"));
        System.out.println("3805-012345-, need FALSE - " + checkTelNumber("3805-012345-"));
        System.out.println("+38(05)01234567, need FALSE - " + checkTelNumber("+38(05)01234567"));
        System.out.println("+38(0501)234567, need FALSE - " + checkTelNumber("+38(0501)234567"));
        System.out.println("(050)12345678, need FALSE - " + checkTelNumber("(050)12345678"));
        System.out.println("+38)050(1234567, need FALSE - " + checkTelNumber("+38)050(1234567"));
        System.out.println("+38(050)1-23-45-6-7, need FALSE - " + checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println("050ххх4567, need FALSE - " + checkTelNumber("050ххх4567"));
        System.out.println("050123456, need FALSE - " + checkTelNumber("050123456"));
        System.out.println("+38-(050)1234567, need FALSE - " + checkTelNumber("+38-(050)1234567"));
        System.out.println("+38((050)1234567, need FALSE - " + checkTelNumber("+38((050)1234567"));
        System.out.println("+5(0--5)1234567, need FALSE - " + checkTelNumber("+5(0--5)1234567"));
        System.out.println("7-4-4123689-5, need FALSE - " + checkTelNumber("7-4-4123689-5"));
        System.out.println("+38051202(345)7, need TRUE - " + checkTelNumber("+38051202(345)7"));
        System.out.println("+38051202(345)-7, need TRUE - " + checkTelNumber("+38051202(345)-7"));
        System.out.println("+-313450531202, need TRUE - " + checkTelNumber("+-313450531202"));
        System.out.println("380-50123-45, need TRUE - " + checkTelNumber("380-50123-45"));
        System.out.println("+38050123(456)7, need TRUE - " + checkTelNumber("+38050123(456)7"));
        System.out.println("+38050123-45-67, need TRUE - " + checkTelNumber("+38050123-45-67"));
        System.out.println("050123-4567, need TRUE - " + checkTelNumber("050123-4567"));
        System.out.println("(050)123-4567, need TRUE - " + checkTelNumber("(050)123-4567"));
        System.out.println("(050)1234567, need TRUE - " + checkTelNumber("(050)1234567"));
        System.out.println("+380501234567, need TRUE - " + checkTelNumber("+380501234567"));
        System.out.println("+38(050)1234567, need TRUE - " + checkTelNumber("+38(050)1234567"));
        System.out.println("1-23456789-0, need TRUE - " + checkTelNumber("1-23456789-0"));
        System.out.println("+38(050)1234567, need TRUE - " + checkTelNumber("+38(050)1234567"));
        System.out.println("380-50123-45, need TRUE - " + checkTelNumber("380-50123-45"));
        System.out.println("-38050123-4534, need false - " + checkTelNumber("-38050123-4534"));
        System.out.println("+38(050)-1234567, need true - " + checkTelNumber("+38(050)-1234567"));
        System.out.println("+38050(123)(456)7 , need FALSE - " + checkTelNumber("+38050(123)(456)7 "));

    }

    public static boolean checkTelNumber(String telNumber) {
        //   if (telNumber == null || telNumber.length() < 10) return false;
      /*  return (telNumber.matches("^\\+(\\d[\\-\\(\\)]?){11}\\d$") || telNumber.matches("^[\\(\\d]-?(\\d[\\-\\)]?){8}\\d$"))
                && telNumber.matches("^(\\+)?(\\d)*(\\(\\d{3}\\))?(\\d+-?\\d+-?)?\\d+$");*/
        //return (telNumber.matches("^(\\+\\d{2})?" + "((\\(\\d{3}\\))|(\\d{3}))" + "((\\d{7})|(\\d{3}\\-\\d\\d\\-?\\d\\d)|())$"));
        // return (telNumber.matches("^[\\+\\d{0,3}\\-]?" + "((\\(\\d{3}\\))|(\\d{0,3})|(-))" + "((\\d{7})|(\\d{3}-\\d\\d-?\\d\\d)|())$"));
       /* if (telNumber == null ) return false;
        else if (telNumber.replaceAll("[^\\d]", "").length() == 12 && telNumber.matches("\\+(\\d+)?(\\(\\d{3}\\))?((\\d+)|(\\(\\d{3}\\)))?((-)?(\\d+)(-)?((\\d+)|(\\(\\d{3}\\)))|-?\\d+)\\d$" ))
        {
            return true;

        }
        else if (telNumber.replaceAll("[^\\d]", "").length() == 10 && telNumber.matches("^[^-](\\d*)((\\d+)|(\\(\\d{3}\\)))?\\d*(\\d+)?-?(\\d+)?-?(\\d+)?\\d$")) {
            return true;
        }

        else if((telNumber.replaceAll("[^\\d]", "").length() == 12 && telNumber.matches("^\\+\\d+(\\(\\d{3}\\))-?\\d$"))){
            return true;}

        else if((telNumber.replaceAll("[^\\d]", "").length() == 10 && telNumber.matches("^(\\(\\d{3}\\))\\d+-?\\d+\\d$"))){
            return true;}

        return false;*/
        if (telNumber == null || telNumber.length() < 10) return false;
        if((telNumber.replaceAll("[^\\d]", "").length() == 12 && telNumber.matches("^\\+\\d+(\\(\\d{3}\\))-?\\d$")))
            return true;
        return ((telNumber.matches("^\\+[(\\-]?(\\d[()\\-]?){11}\\d$") || telNumber.matches("^\\(?(\\d[-()]?){9}\\d$"))
                && telNumber.matches("[+]?\\d*(\\(\\d{3}\\))?\\d*-?\\d*-?\\d*\\d$"));
    }
}
