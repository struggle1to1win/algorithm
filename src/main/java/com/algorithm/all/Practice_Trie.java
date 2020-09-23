package com.algorithm.all;

/**
 * @ClassNamePractice_Trie
 * @Description  字典树、前缀树
 * @Author Yao Xin
 * @Date2020/9/23 9:04
 **/
public class Practice_Trie {
    //根节点
    private Node root = new Node();

    /**
     * 节点：包含属性：pass通过数，end结尾数，另外还有可能存在的26个节点
     * 节点相当于目的地（可以理解为字符之间的间隔），每个字符为路径（节点中26个子节点的引用）
     * 下一字符串在next中引用为空时，说明没有此字符串，添加此引用后，相当于走过了这个字符串，就在指向的节点加一，代表已到达
     */
    public class Node{
        private int pass;
        private int end;
        private Node[] next;
        public Node() {
            this.pass = 0;
            this.end = 0;
            this.next = new Node[26];
        }
    }

    //插入一个字符串
    public void insert(String word){
        if(word==null){
            return;
        }
        Node node = root;
        char[] chars = word.toCharArray();
        for(int i=0;i<chars.length;i++){
            int index = chars[i]-'a';
            node.pass++;
            if(node.next[index]==null){
                node.next[index]=new Node();
            }
            node = node.next[index];
        }
        node.end++;
    }

    //查询一个字符串出现次数
    public int search(String word){
        char[] chars = word.toCharArray();
        Node node = root;
        for(int i=0;i<chars.length;i++){
            int index = chars[i]-'a';
            if(node.next[index]==null){
                return 0;
            }
            node = node.next[index];
        }
        return node.end;
    }

    //字符串为前缀出现的次数
    public int preNum(String str){
        char[] chars = str.toCharArray();
        Node node = root;
        for(int i=0;i<chars.length;i++){
            int index = chars[i]-'a';
            if(node.next[index]==null){
                return 0;
            }
            node = node.next[index];
        }
        return node.pass;
    }

    //删除字符
    public void delete(String str){
        if(search(str)==0){
            return;
        }
        char[] chars = str.toCharArray();
        Node node = root;
        for(int i=0;i<chars.length;i++){
            int index = chars[i]-'a';
            node.pass--;
            if(node.next[index].pass-1==0){
                node.next[index]=null;
                return;
            }
            node = node.next[index];
        }
        node.end--;
    }

    public static void main(String[] args) {
        Practice_Trie trie = new Practice_Trie();
        trie.insert("hello");
        trie.insert("word");
        trie.insert("hello");
        trie.insert("new");
        trie.insert("bee");
        trie.insert("become");
        System.out.println(trie.search("hello"));
        System.out.println(trie.search("bee"));
        System.out.println(trie.preNum("be"));
        trie.delete("bee");
        System.out.println(trie.preNum("be"));
        System.out.println(trie.search("become"));

    }
}
