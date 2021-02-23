package com.ukyu.base.generics;

/**
 * @author ukyu
 * @time 2021/2/23 22:22
 */
public class MyNode extends Node<Integer> {
    public MyNode(Integer data) { super(data); }

    @Override
    public void setData(Integer data) {
        super.setData(data);
        System.out.println("MyNode.setData");
    }
}

class Node<T> {

    public T data;

    public Node(T data) { this.data = data; }

    public void setData(T data) {
        System.out.println("Node.setData");
        this.data = data;
    }
}
