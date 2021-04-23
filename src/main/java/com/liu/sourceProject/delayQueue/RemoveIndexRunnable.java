package com.liu.sourceProject.delayQueue;

import lombok.Data;

import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

@Data
public class RemoveIndexRunnable  implements Runnable{
    private int currentIndex;
    private int size;
    private Set<Task>[] taskSetArray;
    /**
     * 当前指向 队列的索引
     * @param currentIndex
     */
    public  RemoveIndexRunnable(int currentIndex, int size,  Set<Task>[] taskSetArray){
        this.currentIndex = currentIndex;
        this.size  = size;
        this.taskSetArray  = taskSetArray;
    }
    @Override
    public void run() {
//        System.out.println("开始执行调度方法");
        Set<Task> tasks = taskSetArray[currentIndex];
        if(Objects.nonNull(tasks)){
            Iterator<Task> iterator = tasks.iterator();
            while(iterator.hasNext()){
                Task task = iterator.next();
                if(task.getCycleNum() == 0){
                    task.taskFunction();
                    System.out.println(currentIndex+"_" + task.getCodeString());
                    iterator.remove();
                }else{
                    task.setCycleNum(task.getCycleNum() - 1);
                }
            }
        }

        currentIndex = currentIndex + 1;
        currentIndex = currentIndex % size;

    }
}
