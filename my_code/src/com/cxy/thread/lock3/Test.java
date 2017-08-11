package com.cxy.thread.lock3;


public class Test {

	public static void main(String[] args) throws Exception {
		MyService myService = new MyService();
		
		MyThreadA myThreadA = new MyThreadA(myService);
		MyThreadB myThreadB = new MyThreadB(myService);
		myThreadA.start();
		myThreadB.start();
		
		Thread.sleep(3000);
		
		myService.signalA();
		
	}
}
