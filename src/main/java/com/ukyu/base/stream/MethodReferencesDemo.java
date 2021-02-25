package com.ukyu.base.stream;

/**
 * 当使用lambda表达式时，若表达式没有做任何事却调用了方法，请使用方法引用，看上去更清晰
 * @author ukyu
 * @time 2021/2/25 23:19
 */
public class MethodReferencesDemo {

//
//Kind	                                               Example
//    Reference to a static method	                                                ContainingClass::staticMethodName
//    Reference to an instance method of a particular object	                    containingObject::instanceMethodName
//    Reference to an instance method of an arbitrary object of a particular type	ContainingType::methodName
//    Reference to a constructor	                                                ClassName::new
}
