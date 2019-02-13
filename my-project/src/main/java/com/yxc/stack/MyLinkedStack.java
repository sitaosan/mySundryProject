package com.yxc.stack;

public class MyLinkedStack {
    class Node{
     Node next;
     Object data;
     public Node(Object obj,Node next){
         this.data = obj;
         this.next = next;
     }
    }
    private int maxSize;//最大限制
    private Node head;
    private Node end;
    private int size;

    public MyLinkedStack(int size){
        this.maxSize = size;
        this.size = 0;
    }
    public void push(Object obj){
        if(size>maxSize){//超出最大值
            System.out.print(" The Stack is max size");
        }else{
            Node node = new Node(obj,null);
            if(size==0){
                head = node;
                end = node;
            }else{
                node.next = head;
                head = node;
            }
            size++;
        }
    }
    public Object pop(){
        if(size==0){//栈为空
            return "The Stack is empty";
        }else{
            Node node = head;
            head = head.next;
            size--;
            return node.data;
        }
    }
    public static void main(String[] args){
        MyLinkedStack myLinkedStack = new MyLinkedStack(10);
        for(int i=0;i<10;i++){
            Integer a = new Integer(i);
            System.out.print(a);
            myLinkedStack.push(a);
        }
        System.out.println("");
        System.out.println("======取出来的值========");
        for(int l=0;l<10;l++){
            System.out.print(myLinkedStack.pop());
        }
    }
}
