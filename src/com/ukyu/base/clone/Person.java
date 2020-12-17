package com.ukyu.base.clone;

import java.io.Serializable;

/**
 * @author ukyu
 */
public class Person implements Cloneable, Serializable {

    private String name;

    private Integer ruleId;

    /**
     * 对象都要实现Serializable接口
     */
    private Male male;

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

    public void setMale(Male male) {
        this.male = male;
    }

    public Male getMale() {
        return this.male;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", ruleId=" + ruleId +
                ", male=" + male +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}