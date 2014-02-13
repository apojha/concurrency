	package com.ojha.learning.concurrency.buffers;

import com.ojha.learning.concurrency.Buffer;

public class BufferWithNoQueue implements Buffer {

	private int currentlyHeldValue = 0;
	
	@Override
	public void put(int i) throws InterruptedException {
		synchronized(this){
			while (currentlyHeldValue != 0){
				wait();
			}
			
			currentlyHeldValue = i;
			notify();
		}
	}

	@Override
	public int get() throws InterruptedException {
		synchronized(this){
			while (currentlyHeldValue == 0){
				wait();
			}
			
			int valueToReturn = currentlyHeldValue;
			currentlyHeldValue = 0;
			notify();
			return valueToReturn;
		}
	}

}
