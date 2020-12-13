package com.ukyu.base.compare;

import java.util.Comparator;

/**
 * 按照Student的id进行排序
 * @author ukyu
 * @date 2020/12/12
 **/
public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getId().compareTo(o2.getId()), 0);
    }

    public static void main(String[] args) {
        StudentComparator d = new StudentComparator();
        Student d1 = new Student("a", 1);
        Student d2 = new Student("b", 2);
        Student d3 = new Student("b", 2);
        Student d4 = new Student("c", 3);

        System.out.println(d.compare(d1, d2));
        System.out.println(d.compare(d2, d3));
        System.out.println(d.compare(d4, d3));
    }

}
