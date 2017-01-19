package com.javarush.test.level19.lesson10.bonus01;

import java.util.ArrayList;
import java.util.List;
import java.io.*;


/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
               строка0            ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
               строка5            ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        BufferedReader file1 = new BufferedReader(new FileReader(filename1));
        BufferedReader file2 = new BufferedReader(new FileReader(filename2));
        ArrayList<String> file1List = new ArrayList<>();
        ArrayList<String> file2List = new ArrayList<>();
        while (file1.ready()) {
            file1List.add(file1.readLine());
        }

        while (file2.ready()) {
            file2List.add(file2.readLine());
        }
        reader.close();
        file1.close();
        file2.close();
        while (!file1List.isEmpty() && !file2List.isEmpty()) {
            if (file1List.get(0).equals(file2List.get(0))) {
                lines.add(new LineItem(Type.SAME, file1List.get(0)));
                file1List.remove(0);
                file2List.remove(0);
            } else if (file1List.get(0).equals(file2List.get(1))) {
                lines.add(new LineItem(Type.ADDED, file2List.get(0)));
                file2List.remove(0);
            } else if (file1List.get(1).equals(file2List.get(0))) {
                lines.add(new LineItem(Type.REMOVED, file1List.get(0)));
                file1List.remove(0);
            } else {
            }
        }
        if (file1List.size() != 0 && file2List.size() == 0){
            lines.add((new LineItem(Type.REMOVED, file1List.get(0))));
            file2List.remove(0);
        } else if (file1List.size() == 0 && file2List.size() != 0) {
            lines.add((new LineItem(Type.ADDED, file2List.get(0))));
            file2List.remove(0);
        }
       /* System.out.println(file1List.size() + " " + file2List.size());
        for (LineItem strLine : lines) {
            System.out.println(strLine.type + " " + strLine.line);
        }*/
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
