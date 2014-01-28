package com.ojha.learning.concurrency.simpleproducerconsumer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SimpleBuffer implements Buffer {
	
	private BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(100);
	
	public void put(int i){
		queue.add(i);
	}
	
	public int get() {
		try {
			return queue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
			throw new RuntimeException("Interrupted queue here in your java buffer, puffy!");
		}
	}
}

