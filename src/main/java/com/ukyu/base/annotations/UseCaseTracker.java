package com.ukyu.base.annotations;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ukyu
 * @date 2020/11/30
 **/
public class UseCaseTracker {
    public static void trackUseCases(List<Integer> useCases, Class<?> cl) {
        for (Method m : cl.getDeclaredMethods()){
            UseCase us = m.getAnnotation(UseCase.class);
            if(us != null)
            {
                System.out.println("Found use case :" + us.id() + " " + us.description());
            }
            useCases.remove(new Integer(us.id()));
        }
        for(int i : useCases)
        {
            System.out.println("Missing use case-" + i);
        }

    }

    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        Collections.addAll(list, 48, 49, 50);
//        trackUseCases(list, PasswordUtils.class);

    }
}
