package com.ariel.data_structures;

public class MyQueue<T> {
	java.util.Stack <T> s1 = new java.util.Stack<T>(), s2= new java.util.Stack<T>();

	public void enqueue(T el) {
		if (s1.isEmpty()) {
			s2.push(el);

		} else {
			s1.push(el);
		}

	}

	public T dequeue() {
		T lastEl = null;
		java.util.Stack<T> empty, data;

		if (s1.isEmpty()) {
			empty = s1;
			data = s2;
		} else {
			empty = s2;
			data = s1;
		}
		while (!data.isEmpty()) {
			empty.push(data.pop());
		}
		lastEl = empty.pop();
		while (!empty.isEmpty()) {
			data.push(empty.pop());

		}
		return lastEl;
	}
	
	public boolean isEmpty(){
		return this.s1.isEmpty() && this.s2.isEmpty();
	}
	public int size(){
		return s1.size() + s2.size();
	}
	
	
}
