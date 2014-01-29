package com.ojha.learning.concurrency.producerconsumer1;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.ojha.learning.concurrency.Buffer;


public class BufferWithBlockingQueue implements Buffer {
	
	private BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(100);
	
	public void put(int i){
		queue.add(i);
	}
	
	public int get() throws InterruptedException {
		return queue.take();
	}
}

