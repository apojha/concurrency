package com.ojha.learning.concurrency.simpleproducerconsumer;

public class Consumer implements Runnable {

	private Buffer buffer;
	private int totalNumberOfMessagesToConsume;
	
	public Consumer(Buffer buffer, int totalNumberOfMessagesToConsume){
		this.buffer = buffer;
		this.totalNumberOfMessagesToConsume = totalNumberOfMessagesToConsume;
	}

	public void run() {
		for (int i = 0; i < totalNumberOfMessagesToConsume; i++){
			int nextNumber;
			nextNumber = buffer.get();
			System.out.println(nextNumber);
		} 
	}
}
