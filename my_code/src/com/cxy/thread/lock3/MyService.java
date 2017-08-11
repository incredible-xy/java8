package com.cxy.thread.lock3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class MyService {
	private Lock lock = new ReentrantLock();
	private Condition conditionA =lock.newCondition(); 
	private Condition conditionB =lock.newCondition(); 
	
	
	public void awaitA(){
		try {
			lock.lock();
			System.out.println("awaitAʱ��Ϊ��"+System.currentTimeMillis());
			conditionA.await();
			System.out.println("end awaitAʱ��Ϊ��"+System.currentTimeMillis());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	public void awaitB(){
		try {
			lock.lock();
			System.out.println("awaitBʱ��Ϊ��"+System.currentTimeMillis());
			conditionB.await();
			System.out.println("end awaitBʱ��Ϊ��"+System.currentTimeMillis());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}	
	
	public void signalA(){
		try {
			lock.lock();
			System.out.println("signalAʱ��Ϊ��"+System.currentTimeMillis());
			conditionA.signal();
		}finally {
			lock.unlock();
		}
	}
	public void signalB(){
		try {
			lock.lock();
			System.out.println("signalBʱ��Ϊ��"+System.currentTimeMillis());
			conditionA.signal();
		}finally {
			lock.unlock();
		}
	}
}
