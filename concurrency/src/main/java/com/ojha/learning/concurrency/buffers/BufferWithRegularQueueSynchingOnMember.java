package com.ojha.learning.concurrency.buffers;

import java.util.LinkedList;
import java.util.Queue;

import com.ojha.learning.concurrency.Buffer;

public class BufferWithRegularQueueSynchingOnMember implements Buffer {

	private Queue<Integer> queue = new LinkedList<Integer>();
	private int capacity;
	
	private Integer lock; // more encapsulated and so better than using this

	public BufferWithRegularQueueSynchingOnMember(int capacity){
		this.capacity = capacity;
	}

	@Override
	public void put(int i) throws InterruptedException {
		synchronized(lock){
			while(queue.size() == capacity) {
	            wait();
	        }
	        queue.add(i);
	        notify();
		}
	}

	@Override
	public int get() throws InterruptedException {
		synchronized(lock){
			while(queue.isEmpty()) {
		            wait();
		    }
	
	        int toReturn = queue.remove();
	        notify();
	        return toReturn;
		}
	}


}
