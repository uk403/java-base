package com.ukyu.base.compare;

/**
 * @author ukyu
 * @date 2020/12/12
 **/
public class Student implements Comparable<Student>{

    private final String name;
    private Integer id;

    Student(String name, Integer id){
        this.name = name;
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public Integer getId(){
        return id;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.name.compareTo(o.name), 0);
    }

    public static void main(String[] args) {
        Student demo1 = new Student("a", 1);
        Student demo2 = new Student("b", 2);
        Student demo3 = new Student("b", 2);
        Student demo4 = new Student("c", 3);

        System.out.println(demo1.compareTo(demo2));
        System.out.println(demo2.compareTo(demo3));
        System.out.println(demo4.compareTo(demo2));

    }
}
