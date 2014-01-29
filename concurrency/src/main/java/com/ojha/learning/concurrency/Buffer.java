package com.ojha.learning.concurrency;

public interface Buffer {

	void put(int i) throws InterruptedException;
	int get() throws InterruptedException;
}
