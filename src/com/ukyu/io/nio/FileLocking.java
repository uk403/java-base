package com.ukyu.io.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * @author ukyu
 * @date 2020/11/16
 **/
public class FileLocking {
    public static void main(String[] args) throws IOException, InterruptedException {
        FileOutputStream fos = new FileOutputStream("f:/lock.txt");
        FileLock fl = fos.getChannel().lock();
        System.out.println(fl.isShared());
        System.out.println("Locked File");
        TimeUnit.MILLISECONDS.sleep(10000);
        fl.release();
        System.out.println("Released File");
        fos.close();


    }
}
