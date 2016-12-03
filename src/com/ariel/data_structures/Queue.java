package com.ariel.data_structures;

public class Queue<T> extends java.util.LinkedList<T> {

	

	public void enqueue(T enqueue) {
		this.addLast(enqueue);
	}

	public T dequeue() {
		return this.removeFirst();
	}
}
