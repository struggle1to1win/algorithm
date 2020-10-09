package com.algorithm.all.stackAndQueueAndTrie;

/**
 * @ClassNamePractice_StackQueueTrans
 * @Description 堆栈互转
 * @Author Yao Xin
 * @Date2020/9/16 10:49
 **/
public class Practice_StackQueueTrans {
    public static void main(String[] args) {
        //队列实现栈
        /*StackUseQueue<Integer> stack1 = new StackUseQueue<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        System.out.println(stack1.pop());
        System.out.println(stack1.pop());
        stack1.push(4);
        System.out.println(stack1.pop());*/
        //栈实现队列
        QueueUseStack<Integer> queue = new QueueUseStack();
        queue.put(1);
        queue.put(2);
        queue.put(3);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        queue.put(4);
        System.out.println(queue.poll());
        //O(1)获取最小值

        StackGetMin stack1 = new StackGetMin();
        stack1.push(4);
        stack1.push(2);
        stack1.push(3);
        stack1.push(2);
        stack1.push(4);
        stack1.push(1);

        System.out.println(stack1.getMin());
        stack1.poll();
        System.out.println(stack1.getMin());
        stack1.poll();
        System.out.println(stack1.getMin());
        stack1.poll();
        System.out.println(stack1.getMin());
        stack1.poll();
        System.out.println(stack1.getMin());
    }
}

//队列实现栈
class StackUseQueue<T>{
    private MyQueueWithList<T> queueOne = new MyQueueWithList<>();
    private MyQueueWithList<T> queueTwo = new MyQueueWithList<>();

    public void push(T value){
        queueOne.put(value);
    }

    public T pop(){
        if(queueOne.size()==0){
            return null;
        }else if(queueOne.size()==1){
            return queueOne.poll();
        }else {
            while(queueOne.size()!=1){
                queueTwo.put(queueOne.poll());
            }
            T poll = queueOne.poll();
            queueOne = queueTwo;
            queueTwo = new MyQueueWithList<>();
            return poll;
        }
    }
}

//栈实现队列
class QueueUseStack<T>{
    private MyStackWithList<T> left = new MyStackWithList<>();
    private MyStackWithList<T> right = new MyStackWithList<>();

    public void put(T value){
        left.push(value);
    }

    public T poll(){
        if(right.peek()==null){
            while(left.peek()!=null){
                right.push(left.pop());
            }
        }
        return right.pop();
    }
}

//实现一个栈，put/poll/getMin
class StackGetMin{
    private MyStackWithList<Integer> data = new MyStackWithList<>();
    private MyStackWithList<Integer> min = new MyStackWithList<>();

    public void push(Integer value){
        data.push(value);
        if(min.peek()==null){
            min.push(value);
        }else if(value<min.peek()){
            min.push(value);
        }else {
            min.push(min.peek());
        }
    }

    public Integer poll(){
        min.pop();
        return data.pop();
    }

    public Integer getMin(){
        return min.peek();
    }
}
