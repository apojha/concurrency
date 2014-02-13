package com.ojha.learning.concurrency.buffers;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.ojha.learning.concurrency.Buffer;

public class BufferThatNeverNeedsNotifyAll implements Buffer {

	private Lock lock = new ReentrantLock();
	private Condition valueAlreadySet = lock.newCondition();
	private Condition valueNotSetYet = lock.newCondition();
	
	private int currentlyHeldValue = 0;
	
	@Override
	public void put(int i) throws InterruptedException {
		lock.lock();
		try {
			while (currentlyHeldValue != 0){
				valueAlreadySet.await();
			}
			currentlyHeldValue = i;
			valueNotSetYet.signal();
		}
		finally{
			lock.unlock();
		}
	}

	@Override
	public int get() throws InterruptedException {
		lock.lock();
		try {
			while (currentlyHeldValue == 0){
				valueNotSetYet.await();
			}
			int valueToReturn = currentlyHeldValue;
			currentlyHeldValue = 0;
			valueAlreadySet.signal();
			
			return valueToReturn;
		}
		finally {
			lock.unlock();
		}
	}
}
