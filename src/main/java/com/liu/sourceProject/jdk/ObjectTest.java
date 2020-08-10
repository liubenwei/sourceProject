package com.liu.sourceProject.jdk;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liu
 * @Date 2020/8/10 15:18
 */
public class ObjectTest {
	public static void main(String[] args) {
		WaitTest waitTest = new WaitTest();
		waitTest.start();

		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		waitTest.interrupt();
		System.out.println("mian 结束");
	}
}

class WaitTest extends Thread {
	@Override
	public void run() {



		synchronized (this){
			try {
				wait(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		System.out.println("wait结束");
	}
}
