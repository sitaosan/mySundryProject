package com.yxc.queue;

/**
 *队列是先进先出
 * 主要方法：
 * 1、入队： 通常命名为push()
 * 2、出队： 通常命名为pop()
 * 3、求队列中元素个数
 * 4、判断队列是否为空
 * 5、获取队首元素
 * 队列与栈一样是一种线性结构，因此以常见的线性表如数组、链表作为底层的数据结构。
 * 有界队列
 * **/
public class MyArrayQueue {

    private int head;
    private int end;
    private int size;
    private Object[] objs;
    public MyArrayQueue(int size){
        head = 0 ;
        end = 0;
        objs = new Object[size];
        this.size = size;
    }
    public void push(Object obj){
        if(head==(size-1)){
            System.out.print("The queue is full");
        }else{
            objs[end] = obj;
            end = (end+1)%size;
        }
    }
    public Object pop(){
        if(head==end&&objs[end]==null){
            return "The queue is empty";
        }else{
            Object obj = objs[head];
            objs[head] = null;
            head = (head+1)%size;
            return obj;
        }
    }

    public static void main(String[] args) throws Exception {
        MyArrayQueue queue = new MyArrayQueue(10);
        for(int i=0;i<10;i++){
            Integer a = new Integer(i);
            queue.push(a);
        }

        for(int l=0;l<11;l++){
            System.out.print(queue.pop());
        }
    }
}
