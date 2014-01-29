package com.ojha.learning.concurrency.producerconsumer3;

import java.util.LinkedList;
import java.util.Queue;

import com.ojha.learning.concurrency.Buffer;

public class BufferWithRegularQueue implements Buffer {
	
	private Queue<Integer> queue = new LinkedList<Integer>();
	private int capacity;

	public BufferWithRegularQueue(int capacity){
		this.capacity = capacity;
	}

	@Override
	public void put(int i) throws InterruptedException {
		synchronized(this){
			while(queue.size() == capacity) {
	            wait();
	        }
	        queue.add(i);
	        notify();
		}
	}

	@Override
	public int get() throws InterruptedException {
		synchronized(this){
			while(queue.isEmpty()) {
		            wait();
		    }
	
	        int toReturn = queue.remove();
	        notify();
	        return toReturn;
		}
	}

}
