package com.ukyu.algorithm;

import java.util.UUID;
import java.util.concurrent.*;

/**
 * 测试myMap
 * @author ukyu
 * @time 2021/7/17 22:49
 */
public class TestMyMap {
    public static final String NAME = "name";
    public static final String AGE = "age";
    public static final String SEX = "sex";
    public static final String CITY = "city";
    public static final String MY_HOME = "home";
    
    public static final String NAME_CH = "姓名";
    public static final String AGE_CH = "年龄";
    public static final String SEX_CH = "性别";
    public static final String CITY_CH = "所在城市";
    public static final String MY_HOME_CH = "家乡";

    public static void main(String[] args) throws InterruptedException {
        MyMap<String, Object> myMap = new MyMap<>(8);

        CountDownLatch latch = new CountDownLatch(4);
        ThreadFactory threadFactory = r -> new Thread(r, "myMap-test" + UUID.randomUUID());
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 8, 0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10), threadFactory);
        try {
            executor.execute(() -> {
                myMap.put(NAME, "ukyu");
                myMap.put(AGE, 23);
                myMap.put(SEX, "male");
                myMap.put(CITY, "CDC");
                myMap.put(MY_HOME, "CQC");
                // 插入一次空值
                myMap.put(null, null);
                latch.countDown();
            });

            executor.execute(() -> {
                myMap.put(NAME, "xxx");
                myMap.put(AGE, 32);
                myMap.put(SEX, "男");
                myMap.put(CITY, "成都");
                myMap.put(MY_HOME, "重庆");
                // 插入一次空值
                myMap.put(null, null);
                latch.countDown();
            });

            executor.execute(() -> {
                myMap.put(NAME_CH, "xxx");
                myMap.put(AGE_CH, 32);
                myMap.put(SEX_CH, "male");
                myMap.put(CITY_CH, "CDC");
                myMap.put(MY_HOME_CH, "CDC");
                latch.countDown();
            });

            executor.execute(() -> {
                myMap.put(NAME_CH, "ukyu");
                myMap.put(AGE_CH, 23);
                myMap.put(SEX_CH, "男");
                myMap.put(CITY_CH, "成都");
                myMap.put(MY_HOME_CH, "CQC");
                latch.countDown();
            });
            latch.await();

            System.out.println("删除前: \n" + getStringBuilder(myMap));
            System.out.println("删除前的size(): " + myMap.size());
            System.out.println("null: " + myMap.get(null) + "\n");

            System.out.println("删除age, 原有的值: " + myMap.remove(AGE));
            System.out.println("删除sex, 原有的值: " + myMap.remove(SEX));
            System.out.println("删除性别, 原有的值: " + myMap.remove(SEX_CH));
            System.out.println("删除姓名, 原有的值: " + myMap.remove(NAME_CH));
            System.out.println("删除后的size(): " + myMap.size());


            System.out.println("删除后: \n" + getStringBuilder(myMap));

            System.out.println("null: " + myMap.get(null));
        }finally {
            executor.shutdown();
        }
    }

    private static StringBuilder getStringBuilder(MyMap<String, Object> myMap) {
        StringBuilder builder = new StringBuilder(100);

        builder.append("name: ").append(myMap.get(NAME)).append(" age: ").append(myMap.get(AGE)).append(" sex: ").append(myMap.get(SEX)).append(" city: ").append(myMap.get(CITY)).append(" home: ").append(myMap.get(MY_HOME))
                .append("\n姓名: ").append(myMap.get(NAME_CH)).append(" 年龄 ").append(myMap.get(AGE_CH)).append(" 性别: ").append(myMap.get(SEX_CH)).append(" 所在城市: ").append(myMap.get(CITY_CH)).append(" 家乡: ").append(myMap.get(MY_HOME_CH));
        return builder;
    }
}
