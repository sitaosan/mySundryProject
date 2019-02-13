package com.yxc.list;

import java.util.ArrayList;
import java.util.List;

public class MyArrayList {
    private static final int DEFAULT_SIZE = 10;//默认大小
    private int size;//数组长度
    private Object[] list;//默认数组

    public MyArrayList(){
        this.list = new Object[DEFAULT_SIZE];
    }
    public void add(Object value){
        if(size==DEFAULT_SIZE){//数组已经满了，就重新创建一个数组
            Object[] ll = new  Object[DEFAULT_SIZE*2];
            for (int i = 0; i <list.length ; i++) {
                ll[i] = list[i];
            }
            this.list = null;
            this.list = ll;
        }
        list[size++] = value;
    }
    public void remove(int index){
       if(index==size){//删除尾部
           this.list[index]=null;
       }else if(index<size){//删除中间的
           Object[] ll = new Object[this.list.length-1];
           int temp = 0;
           for (int i = 0; i < list.length; i++) {
               if(index==i){
                   continue;
               }
               ll[temp]=list[i];
               temp++;
           }
           this.list = null;
           this.list = ll;
       }
        this.size--;
    }
    public void remove(Object value){
        for (int i = 0; i < list.length; i++) {
            Object obj = list[i];
            if(obj.equals(value)){
                remove(i);
                break;
            }
        }
    }
    public Object get(int index) throws Exception {
        if(index<size){
            return this.list[index];
        }
        throw new Exception("下标越界");
    }
    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<String>();
        MyArrayList myArrayList = new MyArrayList();
        for (int i = 0; i <12 ; i++) {
            myArrayList.add(i+"");
        }
        myArrayList.remove("5");
        for (int i = 0; i <11 ; i++) {
            System.out.print(myArrayList.get(i));
            System.out.print(",");
        }
        list.wait();
        list.notify();
    }
}
