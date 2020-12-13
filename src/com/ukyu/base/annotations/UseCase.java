package com.ukyu.base.annotations;

import java.lang.annotation.*;

/**
 * @author ukyu
 * @date 2020/11/29
 **/
// 应用在哪个地方
@Target(ElementType.METHOD)
// 哪一个级别可用
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
    int id();
    String description() default "no description";
}
