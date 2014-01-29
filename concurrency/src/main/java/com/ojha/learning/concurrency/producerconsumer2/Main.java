package com.ojha.learning.concurrency.producerconsumer2;

import com.ojha.learning.concurrency.Buffer;
import com.ojha.learning.concurrency.Consumer;
import com.ojha.learning.concurrency.Producer;

public class Main {

	public static void main(String... args){
		
		Buffer buffer = new BufferWithNoQueue();
		
		Thread producer = new Thread(new Producer(buffer, 1, 5));
		Thread consumer = new Thread(new Consumer(buffer, 4));
		
		producer.start();
		consumer.start();
	}
	
}
