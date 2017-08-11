package com.cxy.thread.lock1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lockd的入门案例
 */
public class MyService {
	private Lock lock = new ReentrantLock();
	
	public void TestMethod(){
		lock.lock();
		for(int i=1;i<4;i++){
			System.out.println("threadName:"+Thread.currentThread().getName()+":"+i);
		}
		lock.unlock();
	}
}
