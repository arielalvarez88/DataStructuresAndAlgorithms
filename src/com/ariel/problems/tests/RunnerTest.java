package com.ariel.problems.tests;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.ariel.problems.Runner;

public class RunnerTest {

	@Test
	public void testWeaveElements() {

		LinkedList<Integer> arr = new LinkedList<Integer>(Arrays.asList(0, 10)),
				expected = new LinkedList<Integer>(Arrays.asList(0, 10));
		Runner.weaveElements(arr);
		assertTrue(arr.equals(expected));
		LinkedList<Integer> arr2 = new LinkedList<Integer>(Arrays.asList(0, 1, 10, 11)),
				expected2 = new LinkedList<Integer>(Arrays.asList(0, 10, 1, 11));

		Runner.weaveElements(arr2);
		assertTrue(arr2.equals(expected2));

		LinkedList<Integer> arr3 = new LinkedList<Integer>(Arrays.asList(0, 1, 2, 10, 11, 12)),
				expected3 = new LinkedList<Integer>(Arrays.asList(0, 10, 1, 11, 2, 12));

		Runner.weaveElements(arr3);
		assertTrue(arr3.equals(expected3));
	}

	@Test
	public void testGetFirstPosSecondGrp() {
		LinkedList<Integer> arr = new LinkedList<Integer>(Arrays.asList(0, 1, 2, 10, 11, 12));
		int middle = 0;
		middle = Runner.getFirstPosSecondGrp(arr);
		assertTrue(middle == 3);
		arr = null;
		LinkedList<Integer> arr2 = new LinkedList<Integer>(Arrays.asList( 0, 10 ));
		middle = Runner.getFirstPosSecondGrp(arr2);
		assertTrue(middle == 1);

	}

}
