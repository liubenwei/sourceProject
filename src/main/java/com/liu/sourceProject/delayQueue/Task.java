package com.liu.sourceProject.delayQueue;

import lombok.Data;
import lombok.Getter;

import java.sql.SQLOutput;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

/**
 * 当MyDelayQueue的currentIndex扫到了Set<Task>,判断cycleNum是否等于0，如果相等 执行taskFunction
 */
@Getter
public class Task {
    /**
     * 当current Index第几圈扫到这个slot时 执行任务
     */
    private int cycleNum;
    private String codeString = UUID.randomUUID().toString();

    public void taskFunction(){
        System.out.println(new Date());
        System.out.println("asdfasdfasdfasd");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(codeString, task.codeString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeString);
    }

    public int getCycleNum() {
        return cycleNum;
    }

    public void setCycleNum(int cycleNum) {
        this.cycleNum = cycleNum;
    }
}
