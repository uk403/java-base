package com.ukyu.io.practice;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * 移动文件
 */
@Slf4j
public class CopyFile {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Administrator\\Desktop\\123");

        String des = "C:\\Users\\Administrator\\Desktop\\source.sql";
        for (String str : file.list()){
            copy(des, "C:\\Users\\Administrator\\Desktop\\123\\" + str);
        }

    }

    private static void copy(String des, String source) throws IOException {
//        BufferedWriter out1 = new BufferedWriter(new FileWriter(source));
//        out1.write("string to be copied\n");
//        out1.close();
        InputStream in = new FileInputStream(source);
        OutputStream out = new FileOutputStream(des, true);
        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) > 0) {
            out.write(buf, 0, len);
        }
        log.info("{} 复制完毕", source);
        in.close();
        out.close();
    }
}
