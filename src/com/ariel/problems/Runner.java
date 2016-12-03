package com.ariel.problems;

import java.util.LinkedList;

public class Runner {

	public static LinkedList<Integer> weaveElements(LinkedList<Integer> arr) {
		int fast = 0, slow = 0, swap;

		slow = Runner.getFirstPosSecondGrp(arr);
		try {
			while (true) {
				swap = arr.get(fast);
				swap = arr.get(slow);
				arr.remove(slow);
				arr.add(fast + 1, swap);
				slow++;
				fast += 2;
			}

		} catch (IndexOutOfBoundsException err) {

		}
		return arr;

	}

	public static int getFirstPosSecondGrp(LinkedList<Integer> arr) {
		int fast = 1, slow = 0, test = 0;
		try {

			while (true) {
				slow++;
				fast = fast + 2;
				test = arr.get(fast);

			}

		} catch (IndexOutOfBoundsException e) {

		}
		return slow;
	}

}
