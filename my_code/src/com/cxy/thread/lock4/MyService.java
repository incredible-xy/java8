package com.cxy.thread.lock4;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class MyService {
	private Lock lock;
	public MyService(boolean isFair) {
		this.lock = new ReentrantLock(isFair);
	}
	public void serviceMethod(){
		try {
			lock.lock();
			System.out.println(Thread.currentThread().getName()+"»ñµÃËø¶¨");
		} finally {
			lock.unlock();
		}
	}
}
