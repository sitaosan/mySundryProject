package com.yxc.concurrent;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThread implements Runnable {
    public void run() {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("thread:" + Thread.currentThread().getName() + ",time:" + sdf1.format(new Date()));
    }
}
