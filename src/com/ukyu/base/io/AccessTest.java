package com.ukyu.base.io;

import java.io.*;

/**
 * @author ukyu
 * @date 2020/11/8
 **/
public class AccessTest {
    public static void main(String[] args) {

        RandomAccessFile raf = null;
        try {
            File file = new File("C:\\Users\\ukyu\\Desktop\\test.txt");
            file.createNewFile();
            raf = new RandomAccessFile(file, "rw");
            byte []buffer = new byte[2];
            int len = 0;
            String str1 = "晴天，阴天，多云，小雨，大风，中雨，小雪，雷阵雨";
            String str2 = new String(str1.getBytes("GB2312"));
            raf.writeBytes(str2);
            System.out.println("当前文件指针的位置：" + raf.getFilePointer());
            // 移动文件指针
            raf.seek(6);
            System.out.println("从文件头跳过6个字节，现在文件内容如下：");
            while((len=raf.read(buffer,0,2))!=-1)
            {
                System.out.println(new String(buffer,0,len));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(raf!=null)
            {
                try {
                    raf.close();
                } catch (IOException e) {

                }
            }
        }
    }
}
