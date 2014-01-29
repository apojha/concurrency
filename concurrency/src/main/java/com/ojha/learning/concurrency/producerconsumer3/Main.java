package com.ojha.learning.concurrency.producerconsumer3;

import com.ojha.learning.concurrency.Buffer;
import com.ojha.learning.concurrency.Consumer;
import com.ojha.learning.concurrency.Producer;

public class Main {

public static void main(String... args){
		
		Buffer buffer = new BufferWithRegularQueue(3);
		
		Thread producer = new Thread(new Producer(buffer, 1, 5));
		Thread consumer = new Thread(new Consumer(buffer, 4));
		
		producer.start();
		consumer.start();
	}
}
