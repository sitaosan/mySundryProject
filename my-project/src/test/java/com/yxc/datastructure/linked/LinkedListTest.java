package com.yxc.datastructure.linked;

import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {

    private LinkedList linkedList;

    @Before
    public void init(){
        linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println("打印链表：");
        linkedList.print();
        System.out.println(" ");
    }
    @Test
    public void trunLinkedlistTest(){
        Node node = linkedList.trunLinkedlist();
        System.out.println("翻转以后：");
        linkedList.print(node);
    }
}
