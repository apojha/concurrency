package com.ojha.learning.concurrency;


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
			try {
				this.buffer.put(i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
