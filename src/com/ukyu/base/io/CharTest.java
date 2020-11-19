package com.ukyu.base.io;

import java.io.*;

/**
 * @author ukyu
 * @date 2020/11/10
 **/
public class CharTest {
    public static void main(String[] args) throws IOException {
        File file = new File("f:/char.txt");
        Writer out = new FileWriter(file);
        String str = "Hello world!!";
        out.write(str);
        out.close();

        Reader in = new FileReader(file);
        char []ch = new char[(int)file.length()];
        int i = in.read(ch);
        if(i==-1)
        {
            System.out.println("文件为空");
        }
        else {
            System.out.println(file.length());
            System.out.println(i);
            System.out.println(new String(ch,0,i));
        }
    }
}
