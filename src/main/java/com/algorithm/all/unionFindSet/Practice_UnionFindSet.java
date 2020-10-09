package com.algorithm.all.unionFindSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassNamePractice_UnionFindSet
 * @Description  并查集，用于多块区域的合并问题上
 * @Author Yao Xin
 * @Date2020/10/6 16:28
 **/
public class Practice_UnionFindSet<T> {
    /**
     * 节点
     * @param <T>
     */
    public static class Node<T>{
        private int value;
        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 用于存储当前节点的父节点，头节点的父节点是自身
     */
    public Map<Node<T>,Node<T>> parents = new HashMap<>();
    /**
     * 用于存储当前区域的大小，自由头节点会存
     */
    public Map<Node<T>,Integer> size = new HashMap<>();
    /**
     * 用于值与节点的转换
     */
    public Map<Integer,Node<T>> values = new HashMap<>();

    /**
     * 初始化，即将所有数据变为单独的集合
     * @param arr
     */
    public Practice_UnionFindSet(int[] arr) {
        for(int i=0;i<arr.length;i++){
            Node node = new Node(arr[i]);
            parents.put(node,node);
            size.put(node,1);
            values.put(arr[i],node);
        }
    }

    /**
     * 判断a、b是否在同一个集合之中
     * @param a
     * @param b
     * @return
     */
    public boolean isSameSet(int a,int b){
        Node<T> nodeA = values.get(a);
        Node<T> nodeB = values.get(b);
        if(nodeA==null||nodeB==null){
            return false;
        }
        return findParent(nodeA)==findParent(nodeB);
    }

    /**
     * 将a、b两个节点合并
     * @param a
     * @param b
     */
    public void union(int a,int b){
        Node<T> nodeA = values.get(a);
        Node<T> nodeB = values.get(b);
        if(nodeA==null||nodeB==null){
            return;
        }
        Node<T> parentA = findParent(nodeA);
        Node<T> parentB = findParent(nodeB);
        Integer sizeA = size.get(parentA);
        Integer sizeB = size.get(parentB);

        Node<T> bigNode = sizeA >= sizeB?parentA:parentB;
        Node<T> smallNode = bigNode == parentA?parentB:parentA;

        parents.put(smallNode,bigNode);
        size.put(bigNode,size.get(smallNode)+size.get(bigNode));
        size.remove(smallNode);
    }

    /**
     * 找到当前节点的父节点
     * @param node
     * @return
     */
    public Node<T> findParent(Node<T> node){
        Stack<Node> stack = new Stack<>();
        Node curr = node;
        while(curr!=parents.get(curr)){
            stack.push(curr);
            curr = parents.get(curr);
        }
        while (!stack.isEmpty()){
            Node pop = stack.pop();
            parents.put(pop,curr);
        }
        return curr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,4,6,3,7,2,5};
        Practice_UnionFindSet unionFindSet = new Practice_UnionFindSet(arr);
        unionFindSet.union(1,4);
        unionFindSet.union(1,6);
        System.out.println(unionFindSet.isSameSet(4,6));

        unionFindSet.union(2,3);
        unionFindSet.union(1,2);
        System.out.println(unionFindSet.isSameSet(2,4));

        System.out.println(unionFindSet.isSameSet(2,5));

    }
}
