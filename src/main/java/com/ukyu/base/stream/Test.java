package com.ukyu.base.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author ukyu
 * @date 2020/10/27
 **/
public class Test {
    public static void main(String[] args) {
        List<Person> list1 = new ArrayList<>();
        list1.add(new Person("ukyu", 1));
        list1.add(new Person("ukyu", 2));
        list1.add(new Person("xinxin", 1));
        list1.add(new Person("pig", 1));

        list1.stream().
                collect(Collectors.toMap(Person::getName, Person::getRuleId, (k1, k2) -> k2)).
                forEach((k,v) -> System.out.println(k + ": " + v));


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