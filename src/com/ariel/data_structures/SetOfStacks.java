
package com.ariel.data_structures;

public class SetOfStacks {

	Stack stacks;
	int threshold = 0, count = 0, stackCount = 1;
	Stack current;

	public SetOfStacks(int threshold) {
		stacks = new Stack();
		Stack first = new Stack();
		stacks.push(first);
		current = first;
		count = 0;
		this.threshold = threshold;

	}

	public Stack getStacks() {
		return stacks;
	}

	public void setStacks(Stack stacks) {
		this.stacks = stacks;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getStackCount() {
		return stackCount;
	}

	public void setStackCount(int stackCount) {
		this.stackCount = stackCount;
	}

	public Stack getCurrent() {
		return current;
	}

	public void setCurrent(Stack current) {
		this.current = current;
	}

	public int getThreshold() {
		return threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	public SetOfStacks() {
		this(2);
	}

	public void push(Object newO) {
		if (count >= threshold) {
			current = new Stack();
			count = 0;
			stackCount++;
			stacks.push(current);

		}
		current.push(newO);
		count++;
	}

	public Object pop() {
		
		Object result = current.pop();
		
		if (count <= 1 && stackCount > 1) {
			stacks.pop();
			current = (Stack) stacks.peek();
			count = threshold;
			stackCount--;
		} else if (count > 0) {
			count--;
		}
		
		return result;

		
	}

	public Object peek() {
		return current.peek();
	}

	public Object popAt(int idx) {
		int stackIdx = (int) idx / threshold;
		SetOfStacks temp = new SetOfStacks();
		int pos = idx % threshold;
		Object result;

		while(this.getStackCount()-1 > stackIdx) {
			temp.push(this.pop());
		}
		int countTotal = count;
		for (int i = 0; i < countTotal - pos; i++) {
			temp.push(this.pop());
		}
		result = temp.pop();
		while (temp.peek() != null) {
			this.push(temp.pop());
		}
		return result;
	}

}
