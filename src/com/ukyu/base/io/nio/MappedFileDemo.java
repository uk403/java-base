package com.ukyu.base.io.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author ukyu
 * @date 2020/11/16
 **/
public class MappedFileDemo {
    static int size = 10485760;
    public static void main(String[] args) throws IOException {
        File file = new File("f:/t.txt");

        FileChannel fc = new RandomAccessFile(file, "rw").getChannel();
        MappedByteBuffer buffer = fc.map(FileChannel.MapMode.READ_WRITE, 0, file.length());
//        for(int i = 0; i < size; i++)
//        {
//            buffer.put((byte)'x');
//        }
//        System.out.println("写完了");
//
//        System.out.println(file.length());
        System.out.println(StandardCharsets.UTF_8.decode(buffer));


    }
}
