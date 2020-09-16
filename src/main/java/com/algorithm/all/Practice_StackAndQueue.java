package com.algorithm.all;

/**
 * @ClassNamePractice_StackAndQueue
 * @Description
 * @Author Yao Xin
 * @Date2020/9/16 9:07
 **/
public class Practice_StackAndQueue {
    //双向链表实现栈与队列
    public static void main(String[] args) {
        //双向链表实现栈
        MyStackWithList<Integer> myStack = new MyStackWithList<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        //双向链表实现队列
        MyQueueWithList<Integer> myQueueWithList = new MyQueueWithList();
        myQueueWithList.put(1);
        myQueueWithList.put(2);
        myQueueWithList.put(3);
        System.out.println(myQueueWithList.peek());
        System.out.println(myQueueWithList.poll());
        System.out.println(myQueueWithList.peek());
        //固定数组实现队列
        MyQueueWithArray<Integer> myQueueWithArray = new MyQueueWithArray<>(7);
        myQueueWithArray.put(1);
        myQueueWithArray.put(2);
        myQueueWithArray.put(3);
        myQueueWithArray.put(4);
        System.out.println(myQueueWithArray.peek());
        System.out.println(myQueueWithArray.poll());
        System.out.println(myQueueWithArray.peek());

    }

}

//双向链表实现的栈
class MyStackWithList<T>{
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    public void push(T a){
        DoubleNode<T> node = new DoubleNode(a);
        if(head==null||tail==null){
            head=node;
            tail=node;
        }else {
            node.pre = tail;
            tail.next = node;
            tail = node;
        }
    }
    public DoubleNode pop(){
        if(tail==null){
            return null;
        }
        DoubleNode node = tail;
        tail=tail.pre;
        tail.next=null;
        return node;
    }
    public T peek(){
        if(tail==null){
            return null;
        }
        return tail.getData();
    }
}

//双向链表实现队列
class MyQueueWithList<T>{
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    public void put(T value){
        DoubleNode<T> node = new DoubleNode<>(value);
        if(head==null||tail==null){
            head = node;
            tail = node;
        }else {
            tail.next = node;
            node.pre = tail;
            tail = node;
        }
    }

    public T poll(){
        if(head==null){
            return null;
        }else {
            DoubleNode<T> node = head;
            head = head.next;
            head.pre = null;
            return node.getData();
        }
    }

    public T peek(){
        if(head==null){
            return null;
        }else {
            return head.getData();
        }
    }
}

//固定数组实现栈
class MyQueueWithArray<T>{
    private T[] array;
    private int putIndex;
    private int pollIndex;
    private int size;
    private final int max;
    public MyQueueWithArray(int size) {
        //使用new T[size];编译通不过，只能这样转一下
        array = (T[]) new Object[size];
        putIndex = 0;
        pollIndex = 0;
        this.size = 0;
        max = size;
    }

    public void put(T value){
        if(size==max){
            throw new RuntimeException("队列已满，不能添加新元素");
        }
        array[putIndex] = value;
        putIndex=incraseIndex(putIndex);
        size++;
    }

    public T poll(){
        if(size==0){
            return null;
        }
        T result = array[pollIndex];
        array[pollIndex] = null;
        pollIndex=incraseIndex(pollIndex);
        size--;
        return result;
    }

    public T peek(){
        if(size==0){
            return null;
        }
        return array[pollIndex];
    }

    public int incraseIndex(int index){
        return index==max-1?0:index+1;
    }
}
