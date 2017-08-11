package com.cxy.concurrentHashMap;

import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.internal.runners.statements.RunAfters;

public class Test {
	public static void main(String[] args) throws InterruptedException {
		 HashMap<String, String> map = new HashMap<String, String>(2); 
		 
		 Thread t =new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<100000;i++){
					new Thread(new Runnable() {
						@Override
						public void run() {
							map.put(UUID.randomUUID().toString(), "");
							
						}
					}).start();
				}
			}
		});
		t.start();
		t.join();
		//System.out.println(map.toString());
		
	}
	
	
	@org.junit.Test
	public void HashMapTest() throws InterruptedException{
		//new ConcurrentHashMap<>()
		
	}
	
}
