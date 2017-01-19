package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/
/*
import java.io.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();
        String tag = args[0];
        String html="";

        while (fileReader.ready()){
            html += fileReader.readLine();
        }
        fileReader.close();
       // System.out.println(html);

        Pattern pat = Pattern.compile("<"+ tag + ".*?</" + tag + ">.*?<[^/].*?");
        Pattern patt = Pattern.compile("<" + tag + ">.*?</" + tag + ">");

        Matcher mat = pat.matcher(html);
        Matcher matt = patt.matcher(html);
        String multi;
        while (mat.find()){
            multi = mat.group();
            System.out.println(multi.substring(0,multi.length() - 2));

        }
        while(matt.find()){
            System.out.println(matt.group());
        }

    }

}
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String tagin = "<" + args[0];
        String tagout = "</" + args[0] + ">";
        String text = "";
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader f = new BufferedReader(new FileReader(r.readLine()));
        r.close();

        while (f.ready()){
            text += f.readLine();
        }
        f.close();


        int v = 0;
        int v1,v2;
        while(text.indexOf(tagin + ">",v) != -1 || text.indexOf(tagin + " ",v) != -1) {
            v1 = text.indexOf(tagin + ">", v);
            v2 = text.indexOf(tagin + " ", v);
            if (v1 < v2) v = v1; else v = v2;
            if (v1 == -1) v = v2;
            if (v2 == -1) v = v1;
            System.out.println(getTag(text,tagin,tagout,v));
            v++;
        }
    }
    public static String getTag(String test, String tagin, String tagout, int off) {
        int indexIN;
        int indexOUT;
        int f = 1;
        int v = off;
        while (f > 0) {
            indexIN = test.indexOf(tagin + ">",v + 1);
            if (indexIN == -1) indexIN = test.indexOf(tagin + " ",v + 1);
            indexOUT = test.indexOf(tagout, v + 1);
            if (indexIN != -1 && indexIN < indexOUT) {
                f++; v = indexIN;
            }
            else {
                f--; v = indexOUT;
            }
        }
        return test.substring(off,v + tagout.length());
    }
}
