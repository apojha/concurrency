package com.ojha.learning.concurrency.producerconsumer1;

import com.ojha.learning.concurrency.Buffer;
import com.ojha.learning.concurrency.Consumer;
import com.ojha.learning.concurrency.Producer;

public class Main {
	
	public static void main(String... args){
		Buffer buffer = new BufferWithBlockingQueue();
		
		Thread producer = new Thread(new Producer(buffer, 0, 20));
		Thread consumer = new Thread(new Consumer(buffer, 20));
		
		producer.start();
		consumer.start();
	}

}
