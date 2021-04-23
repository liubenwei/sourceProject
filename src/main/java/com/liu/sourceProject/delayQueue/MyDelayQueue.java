package com.liu.sourceProject.delayQueue;

import io.netty.util.HashedWheelTimer;
import javafx.scene.control.TableColumn;

import java.util.*;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 设计思路：
 * 在new MyDelayQueue的时候，需要传两个参数，扫描的单位 和扫描时间
 * taskSetArray是一个环形数组,里面存放了Set<Task>，大小为扫描时间
 * currentIndex默认为0，每隔一个时间单位，currentIndex会加1，然后会扫描currentIdnex下标的Set<Task>
 *
 *
 * @see HashedWheelTimer
 */
public class MyDelayQueue {
    private int size;
    private Set<Task> taskSet;
    private int currentIndex;
    private Set<Task>[] taskSetArray;
    /**
     * 移动队列的线程池
     */
    ScheduledExecutorService scheduledExecutorService;
    ScheduledExecutorService worker;
    public MyDelayQueue(int size, TimeUnit timeUnit){
        this.size = size;
        taskSet = new HashSet<>(size);
        int[] ar = new int[1];
        taskSetArray = new HashSet[size];
        scheduledExecutorService = new ScheduledThreadPoolExecutor(1);
        worker = new ScheduledThreadPoolExecutor(1);
        scheduledExecutorService.scheduleAtFixedRate(new RemoveIndexRunnable(0,size,taskSetArray),1,1,timeUnit);
    }

    public static void main(String[] args) {
//        ScheduledThreadPoolExecutor scheduledExecutorService1 = new ScheduledThreadPoolExecutor(1);
//        scheduledExecutorService1.scheduleAtFixedRate(new PrintDateRunnable(),1,1,TimeUnit.SECONDS);
        MyDelayQueue myDelayQueue = new MyDelayQueue(60,TimeUnit.SECONDS);
        for(int i =0 ; i < 1; i++){
            Task task = new Task();
            myDelayQueue.addTask(task,i);
        }
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i =0 ; i < 30; i++){
            Task task = new Task();
            myDelayQueue.addTask(task,i +60);
        }
    }

    /**
     * 添加任务
     * @param task 任务
     * @param time 多少个时间单位后执行
     * @return
     */
    public boolean addTask(Task task, int time){
        int index = time % size;
        task.setCycleNum(time / size);
        if(taskSetArray[index] == null){
            taskSetArray[index] =new HashSet<>();
        }
        taskSetArray[index].add(task);
        return  true;
    }
}
