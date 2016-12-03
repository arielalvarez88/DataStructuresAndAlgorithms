package com.ariel.data_structures;

import java.util.ArrayList;

public class Stack {
	private ArrayList arr = new ArrayList();

	public void push(Object o) {
		arr.add(arr.size(), o);
	}

	public Object pop() {
		Object last = this.peek();
		arr.remove(last);
		return last;
	}

	public Object peek() {
		if (arr.size() == 0) {
			return null;
		}
		return arr.get(arr.size() - 1);
	}
	
	public int size(){
		return arr.size();
	}

}
