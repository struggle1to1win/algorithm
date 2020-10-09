package com.algorithm.all.unionFindSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassNamePractice_IsSameUser
 * @Description
 * @Author Yao Xin
 * @Date2020/10/9 11:23
 **/
public class Practice_IsSameUser {

    public static class Student{
        private String bilibiliAccount;
        private String companyAccount;
        private String mobile;

        public Student(String bilibiliAccount, String companyAccount, String mobile) {
            this.bilibiliAccount = bilibiliAccount;
            this.companyAccount = companyAccount;
            this.mobile = mobile;
        }

        public String getBilibiliAccount() {
            return bilibiliAccount;
        }

        public String getCompanyAccount() {
            return companyAccount;
        }

        public String getMobile() {
            return mobile;
        }
    }

    public static class UnionFindSet<T>{
        public static class Node<T>{
            private T value;
            public Node(T value) {
                this.value = value;
            }
        }
        private Map<Node<T>,Node<T>> parents = new HashMap<>();
        private Map<Node<T>,Integer> size = new HashMap<>();
        private Map<T,Node<T>> values = new HashMap<>();

        public UnionFindSet(T[] nodes) {
            if (nodes==null||nodes.length==0){
                throw new RuntimeException("参数不能为空");
            }
            for(int i=0;i<nodes.length;i++){
                Node<T> curr = new Node<>(nodes[i]);
                parents.put(curr,curr);
                size.put(curr,1);
                values.put(nodes[i],curr);
            }
        }

        public void andNode(T t){
            Node<T> curr = new Node<>(t);
            parents.put(curr,curr);
            size.put(curr,1);
            values.put(t,curr);
        }

        public boolean isSameSet(T a,T b){
            Node<T> nodeA = values.get(a);
            Node<T> nodeB = values.get(b);
            if(nodeA==null||nodeB==null){
                throw new RuntimeException("a或b不在集合中");
            }
            Node<T> parentSet = findParentSet(a);
            Node<T> parentSet1 = findParentSet(b);
            return parentSet == parentSet1;
        }

        public Node<T> union(T a,T b){
            Node<T> nodeA = values.get(a);
            Node<T> nodeB = values.get(b);
            if(nodeA==null||nodeB==null){
                throw new RuntimeException("a或b不在集合中");
            }

            Node<T> parentA = parents.get(nodeA);
            Node<T> parentB = parents.get(nodeB);

            Integer sizeA = size.get(parentA);
            Integer sizeB = size.get(parentB);

            Node<T> bigNode = sizeA>sizeB?parentA:parentB;
            Node<T> smallNode = bigNode==parentA?parentB:parentA;

            parents.put(smallNode,bigNode);
            size.put(bigNode,size.get(smallNode)+size.get(bigNode));
            size.remove(smallNode);
            return bigNode;
        }

        public Node<T> findParentSet(T a){
            Stack<Node<T>> path = new Stack<>();
            Node<T> curr = values.get(a);
            while(curr!=parents.get(curr)){
                path.push(curr);
                curr = parents.get(curr);
            }
            while(!path.isEmpty()){
                parents.put(path.pop(),curr);
            }
            return curr;
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student("b1","c1","m1");
        Student student2 = new Student("b2","c1","m3");
        Student student3 = new Student("b1","c2","m2");
        Student student4 = new Student("b4","c4","m4");
        Student student5 = new Student("b5","c4","m5");
        Student student6 = new Student("b5","c6","m6");
        Student[] students = new Student[]{student1,student2,student3,student4,student5,student6};

        Map<String,Student> bilibiliMap = new HashMap<>();
        Map<String,Student> companyMap = new HashMap<>();
        Map<String,Student> mobileMap = new HashMap<>();

        UnionFindSet<Student> unionFindSet = new UnionFindSet<>(students);
        for(Student curr:students){
            //unionFindSet.andNode(curr);
            if(bilibiliMap.containsKey(curr.getBilibiliAccount())){
                Student student = bilibiliMap.get(curr.getBilibiliAccount());
                unionFindSet.union(curr,student);
            }else {
                bilibiliMap.put(curr.getBilibiliAccount(),curr);
            }

            if(companyMap.containsKey(curr.getCompanyAccount())){
                Student student = companyMap.get(curr.getCompanyAccount());
                unionFindSet.union(curr,student);
            }else {
                companyMap.put(curr.getCompanyAccount(),curr);
            }

            if(mobileMap.containsKey(curr.getMobile())){
                Student student = mobileMap.get(curr.getMobile());
                unionFindSet.union(curr,student);
            }else {
                mobileMap.put(curr.getMobile(),curr);
            }
        }

        System.out.println("s1与s2:" + unionFindSet.isSameSet(student1,student2));
        System.out.println("s2与s4:" + unionFindSet.isSameSet(student2,student4));

    }
}
