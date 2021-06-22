package com.ukyu.algorithm;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ukyu
 */
@Data
@Slf4j
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
            if(ch == ' '){
                continue;
            }
            if (p.child.get(ch) == null) {
                p.child.put(ch, new Node());
            }
            p = p.child.get(ch);
        }
        size++;
        p.isWord = true;
    }

    /**
     * 存放trie树中查询到的联想词
     */
    private List<String> list = new ArrayList<>();

    /**
     * 根据前缀查找
     * @param prefix 前缀
     */
    public List<String> prefixMatching(String prefix, Node node){


        for(char ch : prefix.toCharArray()){
            if(node.child.get(ch) == null) {
                log.info("没有{}的联想词", prefix);
                return list;
            }
            node = node.child.get(ch);
        }
        // 搜索
        dfs(node, new StringBuilder(prefix));
        return list;
    }

    private void dfs(Node node, StringBuilder str) {
        if(node.isWord){
            list.add(str.toString());
        }
        if (node.child.size() == 0) {
            return;
        }

        // 回溯
        for(char ch: node.child.keySet()){

            dfs(node.child.get(ch), new StringBuilder(str + "" + ch));
//            str.deleteCharAt(str.length() - 1);
        }

    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        long start = System.currentTimeMillis();
        trie.insert("易方达蓝筹精选混合");
        trie.insert("易方达上证50增强A");
        trie.insert("易方达中小盘混合");
        trie.insert("易方达国防军工混合");
        trie.insert("易方达供给改革混合");
        trie.insert("易方达瑞恒混合");
        trie.insert("易方达中盘成长混合");
        trie.insert("易方达稳健收益债券B");
        trie.insert("易方达医疗保健行业混合");
        trie.insert("易方达中证红利ETF联接C");
        trie.insert("易方达新收益混合A");
        trie.insert("易方达现金增利货币B");
        trie.insert("博时沪港深成长企业混合 ");
        trie.insert("博时科技创新混合A");
        trie.insert("博时产业新动力混合A ");
        // 使用redis 保存这个树
        log.info("耗时: {}", System.currentTimeMillis() - start);


        start = System.currentTimeMillis();

        // 从redis中，获取这个树
        String prefix = "博";
        trie.prefixMatching(prefix, trie.root);
        log.info("耗时: {}", System.currentTimeMillis() - start);
        log.info("{} 的联想词 {}", prefix, trie.list);

    }



}
