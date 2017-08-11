package com.cxy.thread.lock2;


public class Test {

	public static void main(String[] args) throws Exception {
		MyService myService = new MyService();
		
		MyThreadA myThreadA = new MyThreadA(myService);
		myThreadA.start();
		
		Thread.sleep(3000);
		
		myService.signal();
		
	}
}
