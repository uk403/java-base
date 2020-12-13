package com.ukyu.base.enumtest;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author ukyu
 * @date 2020/11/26
 **/
public enum  ConstantsSpecificMethod {
    DATE_TIME{
        @Override
        String getInfo() {
            return DateFormat.getDateInstance().format(new Date());
        }
    },
    VERSION{
        @Override
        String getInfo() {
            return System.getProperty("java.version");
        }
    };
    abstract String getInfo();

    public static void main(String[] args) {
        for(ConstantsSpecificMethod csm : values())
        {
            System.out.println(csm.getInfo());
        }
    }
}