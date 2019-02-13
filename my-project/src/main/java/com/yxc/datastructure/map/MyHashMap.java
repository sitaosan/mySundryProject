package com.yxc.datastructure.map;

/**
 * 1、有一个Entry类（内部key,value、Entry）
 * 2、hash方法key的hashCode%默认长度
 * 3、put方法取key的hashCode，用这个int值取数组的Entry，如果为空就把新Entry放里没有就做比较
 * 4、get方法也一样
 * **/
public class MyHashMap {

    private Entry[] table;
    private int defaultLength = 16;//默认长度
    public MyHashMap(){
        this.table = new Entry[defaultLength];
    }
    /**
     * 先用key取hashCode，这个hashCode就是table的位置
     * **/
    public void put(Object key,Object value){
         Entry newEntry = new Entry(key,value,null);
         int index = hash(key);
         Entry entry = table[index];
         if(entry==null){
             table[index] = newEntry;
         }else{
             Object k = entry.getKey();
             //先比较hashcode再equals
             if(k.hashCode()==key.hashCode()&&k.equals(key)){//同一个键替代
                 entry.setValue(value);
                 table[index] = entry;
             }else{
                 newEntry.setNext(entry);
                 table[index] = newEntry;
             }
         }
    }
    public Object get(Object key){
        int index = hash(key);
        Entry entry = table[index];
        //先判断hashcode
        if(entry.getKey().hashCode()==key.hashCode()){
            if(entry.getKey().equals(key)){
                return entry.getValue();
            }
        }
        return null;
    }
    private int hash(Object key){
       int i = key.hashCode()%defaultLength;
       return i;
    }
    class Entry{
        final Object key;
        Object value;
        Entry next;
        Entry(Object key,Object value,Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Object getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }

        public Entry getNext() {
            return next;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public void setNext(Entry next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("key01","张三");
        myHashMap.put("key02","李四");
        myHashMap.put("key03","王五");
        myHashMap.put("key04","周六");
        System.out.println(myHashMap.get("key01"));
        }
    }
