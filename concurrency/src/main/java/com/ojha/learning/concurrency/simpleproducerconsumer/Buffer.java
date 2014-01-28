package com.ojha.learning.concurrency.simpleproducerconsumer;

public interface Buffer {

	void put(int i);
	int get();
}
