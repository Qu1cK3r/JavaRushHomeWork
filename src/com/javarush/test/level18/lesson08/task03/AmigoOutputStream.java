package com.javarush.test.level18.lesson08.task03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.*;

/* AmigoOutputStream
1 Измените класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream.
 Используйте наследование.
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 вызвать метод flush()
2.2 дописать следующий текст [JavaRush © 2012-2013 All rights reserved.], используйте метод
getBytes()
2.3 закрыть поток методом close()
*/

public class AmigoOutputStream extends FileOutputStream{
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream foStream;

    public AmigoOutputStream (FileOutputStream foStream) throws FileNotFoundException{
        super(fileName);
        this.foStream = foStream;
    }

    public void write(int b) throws IOException{
        foStream.write(b);
    }
    public void write(byte[] b) throws IOException{
        foStream.write(b);
    }
    public void write(byte[] b, int off, int len) throws IOException{
        foStream.write(b,off,len);
    }
    public void flush() throws IOException{
        foStream.flush();
    }
    public void finalize() throws IOException{
        super.finalize();
    }
    public void close() throws IOException{
        flush();
        String s="JavaRush © 2012-2013 All rights reserved.";
        write(s.getBytes());
        foStream.close();
    }
    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}

