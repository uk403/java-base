package com.ukyu.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @author ukyu
 * @date 2020/11/15
 **/
public class ChannelTest {
    public static void main(String[] args) throws IOException {
        File file = new File("f:/channel.txt");
        FileChannel fc = new FileOutputStream(file).getChannel();
        fc.write(ByteBuffer.wrap("hello world!".getBytes()));
        fc.close();
        fc = new FileInputStream(file).getChannel();
        ByteBuffer buff = ByteBuffer.allocate(1024);
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());

        // 倒带
        buff.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println(encoding + " " + Charset.forName(encoding).decode(buff));


    }
}
