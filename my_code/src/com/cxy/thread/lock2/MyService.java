package com.cxy.thread.lock2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class MyService {
	private Lock lock = new ReentrantLock();
	private Condition condition =lock.newCondition(); 
	
	
	public void await(){
		try {
			lock.lock();
			System.out.println("await时间为："+System.currentTimeMillis());
			condition.await();
			System.out.println("唤醒后继续执行");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	public void signal(){
		try {
			lock.lock();
			System.out.println("signal时间为："+System.currentTimeMillis());
			condition.signal();
		}finally {
			lock.unlock();
		}
	}
}
