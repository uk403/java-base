package com.ukyu.algorithm;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Trie {

    private class Node {
        public boolean isWord;
        public Map<Character, Node> child;

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.child = new HashMap<>();
        }

        public Node() {
            this(false);
        }
    }

    /**
     * 完整的词的个数
     */
    private int size;

    private Node root;

    public Trie(){
        root = new Node();
        size = 0;
    }

    /**
     * 插入word
     * @param word 关键字
     */
    public void insert(String word){
        Node p = root;
        for(char ch : word.toCharArray()){
            if (p.child.get(ch) == null) {
                p.child.put(ch, new Node());
            }
            p = p.child.get(ch);
        }
        size++;
        p.isWord = true;
    }

    /**
     * 根据前缀查找
     * @param prefix 前缀
     */
    public List<String> prefixMatching(String prefix){
        List<String> list = new ArrayList<>();


    }


}
