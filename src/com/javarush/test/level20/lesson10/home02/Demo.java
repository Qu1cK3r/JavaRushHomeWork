package com.javarush.test.level20.lesson10.home02;

import java.io.*;

public class Demo
{
    public static void main(String[] args) throws Exception
    {
        Solution solution = new Solution();
        Solution.A b = solution.new B();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(baos);
        out.writeObject(b);
        out.flush();
        out.close();
        solution.getOriginalObject(new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray())));
    }
}
