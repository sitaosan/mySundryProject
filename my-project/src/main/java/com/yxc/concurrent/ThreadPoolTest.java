package com.yxc.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程ThreadPoolExecutor的核心参数
 * corePooleSize:核心线程数，能活跃的线程数，可以执行任务的线程，超过这个数了任务就进入阻塞队列
 * maximumPoolSize：麦克塞门，最大大小数表示线程中最多创建多少个线程
 * keepAliveTime：存活时间，线程不执行时多长时间回终止，当线程池中的数>corePooleSize时候，
 *                一个空闲线程达到这个时间就会终止，直到线程池中的数<corePoolSize
 * TimeUnit：就是个时间的粒度
 * workQueue：阻塞队列，存储用来等待执行的任务
 * threadFactory：用来创建线程的工厂
 * RejectedExecutionHandler handler ：拒绝处理任务的策略
 * */
public class ThreadPoolTest {
//    ThreadPoolExecutor threadPoolExecutor =  ThreadPoolExecutor(10,20,15, TimeUnit.MICROSECONDS,);
    ExecutorService fixedThreadExecutor = Executors.newFixedThreadPool(5);//固定大小的线程池
    ExecutorService scheduledThreadExecutor = Executors.newScheduledThreadPool(5);
    ExecutorService cacheThreadExecutor = Executors.newCachedThreadPool();//缓存线程池
    ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();//单线程化的线程池

    public void testFixedThreadExecutor() throws InterruptedException {
        executeThread(fixedThreadExecutor);
    }
    public void testSigleThreadExecutor() throws InterruptedException {
        executeThread(singleThreadExecutor);
    }
    public void testCacheTreadExecutor() throws InterruptedException {
        executeThread(cacheThreadExecutor);
    }
    private void executeThread(ExecutorService executorService) throws InterruptedException {
        for (int i = 0; i <10 ; i++) {
            executorService.submit(new MyThread());
            Thread.sleep(1000);
        }
        executorService.shutdown();
    }

}
