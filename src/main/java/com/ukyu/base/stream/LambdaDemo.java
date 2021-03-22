package com.ukyu.base.stream;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * lambda表达式
 * 参考 https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 *
 * @author ukyu
 * @date 2021/2/25
 **/
public class LambdaDemo {
    public static void main(String[] args) {
//        匿名类看起来很丑，lambda表达式让它看起来更加的紧凑(compactly)
//        functional interface是只包含一个抽象方法的接口;
//        一个functional interface可以包含一个或多个默认方法或静态方法
//        只有一个抽象方法，当你实现它时，可以省略其方法名，就可以使用lambda表达式
        List<Person> roster = new ArrayList<>(10);
        processPersonsWithFunction(
                roster,
                p -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );
//       聚合操作替换这些action
        roster.stream()
                .filter(
                        p -> p.getGender() == Person.Sex.MALE
                                && p.getAge() >= 18
                                && p.getAge() <= 25)
                .map(Person::getEmailAddress)
                .forEach(System.out::println);



    }

    public static void processPersonsWithFunction(
            List<Person> roster,
            Predicate<Person> tester,
            Function<Person, String> mapper,
            Consumer<String> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }
}

@Data
class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;
    int age;

//    省略getter、setter
}