package com.algorithm.all;

/**
 * @ClassNamePractice_MyHeap
 * @Description 使用数组实现虚拟的二叉树就是堆
 * @Author Yao Xin
 * @Date2020/9/18 11:03
 **/
public class Practice_MyHeap {
    private int[] arr;
    private int heapSize;
    private final int limit;

    public Practice_MyHeap(int limit) {
        this.limit = limit;
        arr = new int[limit];
        heapSize = 0;
    }

    public void sort(){
        while(heapSize!=1){
            swap(0,--heapSize);
            heapify(0);
        }
        heapSize = limit;
    }

    public void put(int value){
        if(limit==heapSize){
            throw new RuntimeException("满了，弟弟");
        }
        arr[heapSize]=value;
        heapInsert(heapSize++);
    }

    public void heapInsert(int index){
        while(arr[index]>arr[(index-1)/2]){
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
        int largest = right>=heapSize||arr[left]>arr[right]?left:right;
        largest = arr[largest]>arr[index]?largest:index;
        if(largest != index){
            swap(largest,index);
            heapify(largest);
        }else return;
    }

    public void swap(int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void print(){
        for(int i=0;i<heapSize;i++){
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Practice_MyHeap heap = new Practice_MyHeap(7);
        heap.put(12);
        heap.put(14);
        heap.put(2);
        heap.put(8);
        heap.put(22);
        heap.put(10);
        heap.put(55);
        heap.print();
        System.out.println("==========================================");
        heap.sort();
        heap.print();
    }
}
