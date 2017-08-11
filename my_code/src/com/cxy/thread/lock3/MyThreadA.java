package com.cxy.thread.lock3;

public class MyThreadA extends Thread{
	private MyService myService;

	public MyThreadA(MyService myService) {
		super();
		this.myService = myService;
	}
	
	@Override
	public void run() {
		myService.awaitA();
	}
	
}
