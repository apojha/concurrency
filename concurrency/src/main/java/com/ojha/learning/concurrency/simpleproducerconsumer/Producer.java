package com.ojha.learning.concurrency.simpleproducerconsumer;

public class Producer implements Runnable {

	private int lowerBound;
	private int upperbound;
	private Buffer buffer;
	
	public Producer(Buffer buffer, int lowerbound, int upperbound){
		this.lowerBound = lowerbound;
		this.upperbound = upperbound;
		this.buffer = buffer;
	}
	
	public void run() {
		for (int i=lowerBound; i<upperbound; i++){
			this.buffer.put(i);
		}
		
	}
}
