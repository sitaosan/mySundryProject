package com.yxc.datastructure.linked;

import lombok.Data;

@Data
public class LinkedList {
    private Node head=null; //头节点
    private Node tail=null;//尾节点
    public LinkedList(){
        head = new Node();
        tail = new Node();
    }
    //添加
    public void add(Object value){
        Node node = new Node();
        node.setValue(value);
        if(null==head.getNext()){//链表第一次添加数据
            head = node;
            head.setNext(tail);
            tail.setPrev(node);
        }else{
            tail.getPrev().setNext(node);
            node.setPrev(tail.getPrev());
            tail.setPrev(node);
        }
    }
    //遍历
    public void print() {
        if(null==head){
            System.out.print("LinkedList is null ");
        }else{
            Node node = head;
            while(node != null) {
                System.out.print(node.getValue() + " ");
                node = node.getNext();
            }
        }
    }
    //获取头节点
    public Node getHead(){
        if(null==head)
            return null;
        return head;
    }
    public void print(Node node) {
        if(node == null) {
            return;
        }
        tail = node;
        while(tail != null) {
            System.out.print(tail.getValue() + " ");
            tail = tail.getNext();
        }
    }
    /**
     * null<---->1<--->2<---->3<---->null
     * 变成
     * null<--->3<--->2<--->1<---->null
     * 头变成尾向前推链表，
     * 1的下一个又2变成了null,
     * 1的上一个由null变成了2，
     * 2的上一个又1变成了3，
     * 2的下一个又3变成1，以此类推
     * * **/
    public  Node trunLinkedlist() {
        if(head == null || head.getNext() == null) {
            return head;
        }
        Node current = head;//当前节点
        Node newNode = null;//新节点
        Node next = null;//下一个节点
        while(current != null) {
            next = current.getNext();//获取当前节点的下一个节点
            current.setNext(newNode); //将当前节点指向前一个节点（1指向了null，2指向了3）
            newNode = current;//把当前节点赋值给新节点（头变成尾向前推链表）
            current = next;
            if (next == null) {//取到了最后一个，那么头尾互换，这个节点的上一个指向就应该是null，因为它变成了头
                newNode.setPrev(null);
                return newNode;
            } else {
                if (next.getNext() != null) {
                    newNode.setPrev(next.getNext().getPrev());
                    newNode.setNext(next.getPrev().getNext());
                } else {
                    newNode.setPrev(next);
                    newNode.setNext(current.getPrev().getNext());
                }
            }
        }
        return newNode;
    }
}
