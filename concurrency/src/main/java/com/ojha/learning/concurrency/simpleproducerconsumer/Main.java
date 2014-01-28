package com.ojha.learning.concurrency.simpleproducerconsumer;

public class Main {
	
	public static void main(String... args){
		Buffer buffer = new SimpleBuffer();
		
		Thread producer = new Thread(new Producer(buffer, 0, 20));
		Thread consumer = new Thread(new Consumer(buffer, 20));
		
		producer.start();
		consumer.start();
	}

}
