package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
    String file1 = args[0];
    String file2 = args[1];

    BufferedReader br = new BufferedReader(new FileReader(file1));
    BufferedWriter bw = new BufferedWriter(new FileWriter(file2));
    while (br.ready()) {
        String readedString = br.readLine();
        String[] readedWords  = readedString.split(" ");
        for (int i = 0; i < readedWords.length; i++) {
            Pattern pattern = Pattern.compile("[0-9]");
            Matcher matcher = pattern.matcher(readedWords[i]);
            if (matcher.find()) {
                bw.write(readedWords[i] + " ");
            }
        }
    }
        br.close();
        bw.close();
    }
}