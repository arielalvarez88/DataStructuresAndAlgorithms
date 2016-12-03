package com.ariel.problems.tests.problems;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.*;

import org.junit.Test;

import com.ariel.problems.StackAndQueues;

public class StackAndQueuesTest {

	@Test
	public void testSortAscending() {
		Stack<Integer> asc = new Stack<Integer>();
		Stack<Integer> a = new Stack<Integer>();
		Integer[] vals = { 0, 10, 5, 1, 8 };
		a.addAll(Arrays.asList());

		Stack<Integer> expected = new Stack<Integer>();				
		expected.add(0);
		expected.add(1);
		expected.add(5);
		expected.add(8);
		expected.add(10);

		assertTrue(StackAndQueues.sortAscending(a, asc).equals(expected));

	}

}
