package com.ukyu.base.io;

import java.io.*;

/**
 * @author ukyu
 * @date 2020/11/10
 **/
public class StreamTest {
    public static void main(String[] args) throws IOException {
        File file = new File("f:/stream.txt");
//        OutputStream out = new FileOutputStream(file);;
//        byte []b0 = "abcdefghijklmnopqrstuvwxyz".getBytes();
//        out.write(b0);
//        out.close();

        InputStream in = new FileInputStream(file);
        byte []b = new byte[(int)file.length()];
        int i = in.read(b);
        System.out.println(new String(b,0,i));

    }
}
