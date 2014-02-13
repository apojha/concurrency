package com.ojha.learning.concurrency;

import com.ojha.learning.concurrency.buffers.BufferWithRegularQueue;

public class Main {
	
	public static void main(String... args) throws InterruptedException{
		Buffer buffer = new BufferWithRegularQueue(4);
		
		Thread producer1 = new Thread(new Producer(buffer, 1, 3));
		Thread producer2 = new Thread(new Producer(buffer, 3, 5));
		Thread consumer = new Thread(new Consumer(buffer, 4));
		
		producer1.start();
		producer2.start();
		consumer.start();
		
		
	}

}
