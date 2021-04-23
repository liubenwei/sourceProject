package com.liu.sourceProject.delayQueue;

import java.util.Date;

public class PrintDateRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(new Date());
    }
}
