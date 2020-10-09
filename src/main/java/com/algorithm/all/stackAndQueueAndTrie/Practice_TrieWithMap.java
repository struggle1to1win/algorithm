package com.algorithm.all.stackAndQueueAndTrie;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassNamePractice_TrieWithMap
 * @Description
 * @Author Yao Xin
 * @Date2020/9/23 10:01
 **/
public class Practice_TrieWithMap {
    private Node root;
    public class Node{
        private int pass;
        private int end;
        private Map<Integer,Node> next;
        public Node() {
            this.pass = 0;
            this.end = 0;
            this.next = new HashMap<>();
        }
    }
    public Practice_TrieWithMap() {
        this.root = new Node();
    }

    public void insert(String word){
        Node node = root;
        char[] chars = word.toCharArray();
        for(int i=0;i<chars.length;i++){
            node.pass++;
            Integer index = (int)chars[i];
            if(!node.next.containsKey(index)){
                node.next.put(index,new Node());
            }
            node = node.next.get(index);
        }
        node.end++;
    }

    public int search(String word){
        Node node = root;
        char[] chars = word.toCharArray();
        for(int i=0;i<chars.length;i++){
            Integer index = (int)chars[i];
            if(!node.next.containsKey(index)){
                return 0;
            }
            node = node.next.get(index);
        }
        return node.end;
    }

    public static void main(String[] args) {
        Practice_TrieWithMap trie = new Practice_TrieWithMap();
        trie.insert("hello");
        trie.insert("word");
        trie.insert("hello");
        trie.insert("new");
        trie.insert("bee");
        trie.insert("become");
        System.out.println(trie.search("hello"));
        System.out.println(trie.search("bee"));
    }
}
