package com.ukyu.base.annotations;

/**
 * @author ukyu
 * @date 2020/11/29
 **/
public class Testable {
    void execute(){
        System.out.println("executing~");
    }

    void testExecute(){
        execute();
    }
}
