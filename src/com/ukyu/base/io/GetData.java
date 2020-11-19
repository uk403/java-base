package com.ukyu.base.io;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * 对ByteBuffer的测试
 * @author ukyu
 * @date 2020/11/15
 **/
public class GetData {
    private final static int BSIZE = 1024;
    public static void main(String[] args) {
        // 自动分配0
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        bb.asShortBuffer().put((short)91991);
        // 注意类型转化会截取或改变结果
        System.out.println(bb.getShort());
        // 不同的机器会使用不同的字节排序方式
        // 低位优先，重要的字节放在地址最高的储存单元上,反之
        bb.order(ByteOrder.BIG_ENDIAN);

    }
}
