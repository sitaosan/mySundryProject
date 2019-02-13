package com.yxc.queue;

/**
 *队列是先进先出
 * 主要方法：
 * 1、入队： 通常命名为push()
 * 2、出队： 通常命名为pop()
 * 3、求队列中元素个数
 * 4、判断队列是否为空
 * 5、获取队首元素
 * 队列与栈一样是一种线性结构，链表作为底层的数据结构。
 * 有界队列
 * **/
public class MyLlinkedQueue {
     class Node{
       Node next;
       Object data;
       public Node(Object obj,Node next){
           this.next = next;
           this.data = obj;
       }
     }
     private Node head;
     private Node end;
     public void push(Object obj){
         Node node = new Node(obj,null);
         if(head==null){
             head = node;
             end = node;
         }else{
             end.next = node;
             end = node;
         }
     }
     public Object pop(){
         Node node = head;
         if(head==null){
             return "The Queue is empty";
         }else{
             head = head.next;
             return node.data;
         }
     }
    public static void main(String[] args) throws Exception {
        MyLlinkedQueue queue = new MyLlinkedQueue();
        for(int i=0;i<10;i++){
            Integer a = new Integer(i);
            System.out.print(a);
            queue.push(a);
        }
        System.out.println("");
        System.out.println("======取出的值======");
        for(int l=0;l<10;l++){
            System.out.print(queue.pop());
        }
    }
}
