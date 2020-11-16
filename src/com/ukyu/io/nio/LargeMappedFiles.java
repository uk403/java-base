package com.ukyu.io.nio;

import sun.security.util.Length;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 内存映射文件
 * @author ukyu
 * @date 2020/11/15
 **/
public class LargeMappedFiles {
    static int length = 0x8FFFFFF;

    public static void main(String[] args) throws IOException {
        MappedByteBuffer buffer =
                new RandomAccessFile("f:/mapped.dat","rw").
                        getChannel().map(FileChannel.MapMode.READ_WRITE,0,length);
        for(int i = 0; i < length; i++)
        {
            buffer.put((byte)'x');
        }
        for(int i = length/2; i < length/2 + 6; i++)
        {
            System.out.print((char)buffer.get(i));
        }
    }
}
