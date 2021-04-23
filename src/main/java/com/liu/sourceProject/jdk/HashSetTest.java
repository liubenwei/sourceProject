package com.liu.sourceProject.jdk;

import com.liu.sourceProject.delayQueue.Task;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
    public static void main(String[] args) {
        Set<Task> taskSet = new HashSet<>();
        Task task = new Task();
        taskSet.add(task);
//        taskSet.remove(task);
        task.setCycleNum(1);
        taskSet.remove(task);
        System.out.println(taskSet.size());
    }
}
