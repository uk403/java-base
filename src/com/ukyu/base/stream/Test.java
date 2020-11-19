package com.ukyu.base.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author ukyu
 * @date 2020/10/27
 **/
public class Test {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("2020-09-01");
        list1.add("2020-08-02");
        list1.add("2020-01-14");
        list1.add("2020-10-11");
        list1.add("2020-07-11");
        list1 = list1.stream().sorted(String::compareTo).collect(Collectors.toList());
        System.out.println(list1);

    }
}
class Person{
    private String name;
    private Integer ruleId;
    public Person(String name, Integer ruleId){
        this.name = name;
        this.ruleId = ruleId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", ruleId=" + ruleId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(ruleId, person.ruleId);
    }

//    @Override
//    public int hashCode() {
//        return 1;
//    }
}