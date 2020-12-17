package com.ukyu.base.clone;

/**
 * Clone的学习
 * @author ukyu
 * @date 2020/12/17
 **/
public class CloneDemo {

    public static void main(String[] args) {

        // Object.clone() 是浅拷贝
        // 写一个深拷贝的方法，利用序列化
        Person p1 = new Person();
        Male m1 = new Male();
        m1.setAge(11);
        m1.setColor("黄皮肤");
        p1.setName("ukyu");
        p1.setRuleId(1);
        p1.setMale(m1);
        Person p2 = CloneUtils.clone(p1);
        System.out.println(p2);
        p2.getMale().setColor("白皮肤");
        System.out.println(p1);
        System.out.println(p2);

        try {
            // 全部都改变了
            Person p3 = (Person) p1.clone();
            System.out.println(p3);
            p3.getMale().setColor("黑皮肤");
            System.out.println(p1);
            System.out.println(p3);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }


}
