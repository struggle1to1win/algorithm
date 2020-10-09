package com.algorithm.all.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @ClassNamePractice_MyHeapGen
 * @Description 使用对结构实现对象的排序
 * @Author Yao Xin
 * @Date2020/9/21 11:03
 **/
public class Practice_MyHeapGen<T> {
    private ArrayList<T> arr;
    private HashMap<T,Integer> map = new HashMap();
    private int limit;
    private int heapSize;
    private Comparator<T> comparator;

    public Practice_MyHeapGen(int limit,Comparator comparator) {
        arr = new ArrayList(limit);
        this.limit = limit;
        this.heapSize = 0;
        this.comparator = comparator;
    }

    public void push(T value){
        if(heapSize==limit){
            throw new RuntimeException("满了，弟弟");
        }
        arr.add(value);
        map.put(value,heapSize);
        heapInsert(heapSize++);
    }

    public void resign(T value){
        int index = map.get(value);
        heapInsert(index);
        heapify(index);
    }

    public T pop(){
        if(isEmpty()){
            return null;
        }
        T result = arr.get(0);
        swap(0,--heapSize);
        heapify(0);
        arr.remove(heapSize);
        map.remove(heapSize);
        return result;
    }

    public boolean isEmpty(){
        return heapSize==0;
    }

    public void  heapInsert(int index){
        while (comparator.compare(arr.get(index),arr.get((index-1)/2))>0){
            swap(index,(index-1)/2);
            index = (index-1)/2;
        }
    }

    public void heapify(int index){
        int left = index<<1|1;
        if(left>=heapSize){
            return;
        }
        int right = left+1;
        int largest = right>=heapSize||comparator.compare(arr.get(left),arr.get(right))>0?left:right;
        largest = comparator.compare(arr.get(largest),arr.get(index))>0?largest:index;
        if(index!=largest){
            swap(index,largest);
            heapify(largest);
        }
    }

    private void swap(int i,int j){
        T o1 = arr.get(i);
        T o2 = arr.get(j);
        arr.set(i, o2);
        arr.set(j, o1);
        map.put(o1, j);
        map.put(o2, i);
    }

    public static void main(String[] args) {
        Student s1 = new Student(12,1,90);
        Student s2 = new Student(18,2,100);
        Student s3 = new Student(13,3,70);
        Student s4 = new Student(44,4,60);
        Student s5 = new Student(22,5,55);
        Student s6 = new Student(22,6,55);
        Student s7 = new Student(22,7,43);
        Student s8 = new Student(22,8,101);
        Practice_MyHeapGen<Student> heap = new Practice_MyHeapGen<>(8,new AgeComparator());
        heap.push(s1);
        heap.push(s2);
        heap.push(s3);
        heap.push(s4);
        heap.push(s5);
        heap.push(s6);
        heap.push(s7);
        heap.push(s8);
        while (!heap.isEmpty()){
            System.out.println(heap.pop().toString());
        }
        System.out.println("=================================");

        heap.push(s1);
        heap.push(s2);
        heap.push(s3);
        heap.push(s4);
        heap.push(s5);
        heap.push(s6);
        heap.push(s7);
        heap.push(s8);
        s6.age=52;
        heap.resign(s6);
        while (!heap.isEmpty()){
            System.out.println(heap.pop().toString());
        }
    }

    public static class Student{
        public int age;
        public int name;
        public int score;

        public Student(int age, int name, int score) {
            this.age = age;
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return "student(age="+age+",name="+name+",score="+score+")";
        }
    }

    public static class AgeComparator implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            return o1.age-o2.age;
        }
    }

    public static class ScoreComparator implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            return o1.score-o2.score;
        }
    }
}




