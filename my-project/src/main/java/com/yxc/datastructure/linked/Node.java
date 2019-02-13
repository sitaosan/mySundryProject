package com.yxc.datastructure.linked;

import lombok.Data;

@Data
public class Node {
    private Object value;//值
    private Node prev = null;//上指向
    private Node next = null;//下指向
    public String toString(){
        return value.toString();
    }
}
