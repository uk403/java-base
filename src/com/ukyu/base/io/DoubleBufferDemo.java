package com.ukyu.base.io;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;

/**
 * @author ukyu
 * @date 2020/11/15
 **/
public class DoubleBufferDemo {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(1024);
        DoubleBuffer db = bb.asDoubleBuffer();
        db.put(new double[]{1,2,3,2,1});
        db.flip();
        while(db.hasRemaining())
        {
            System.out.print(db.get() + " ");
        }
    }
}
