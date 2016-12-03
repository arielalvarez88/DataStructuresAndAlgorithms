package com.ariel.problems;

import java.util.Stack;

public class StackAndQueues {

	public static Stack<Integer> sortAscending(Stack<Integer> ori, Stack<Integer> asc) {
		Integer smallest = null;

		int size = 0;
		Integer current;

		while (!ori.isEmpty()) {
			size++;
			current = ori.pop();
			if (smallest == null || current < smallest) {
				smallest = current;
			}
			asc.push(current);
		}
		for (int i = 0; i < size; i++) {
			current = asc.pop();
			if (current == smallest) {
				continue;
			}
			ori.push(current);
		}
		asc.push(smallest);
		if (ori.isEmpty()) {
			return asc;
		}
		return StackAndQueues.sortAscending(ori, asc);
	}

	public static Stack<Integer> order(Stack<Integer> ori) {
		Stack<Integer> result = new Stack<Integer>();
		return StackAndQueues.order(ori, result);

	}

	public static Stack<Integer> order(Stack<Integer> ori, Stack<Integer> result) {
		int count = 0;
		Integer min = null, val = null;

		while (!ori.isEmpty()) {
			val = ori.pop();
			count++;
			if (min == null || val < min) {
				min = val;
			}
			result.push(val);

		}
		for (int i = 0; i < count; i++) {
			if (result.peek() == min) {
				result.pop();

			} else {
				ori.push(result.pop());

			}

		}

		if (count <= 0) {
			return result;
		} else {
			result.push(min);
			return StackAndQueues.order(ori, result);
		}
	}

}
