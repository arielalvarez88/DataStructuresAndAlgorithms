package com.ariel.problems.tests;

import static org.junit.Assert.*;

import java.util.Stack;

import org.junit.Test;

import com.ariel.problems.StackAndQueues; 

public class StackAndQueuesTest {
	@Test
	public void testOrder() {
		Stack<Integer> s = new Stack<Integer>(), result;
		result = StackAndQueues.order(s);
		assertTrue(result.isEmpty());
		s.push(1);
		result = StackAndQueues.order(s);
		assertTrue(result.size() == 1);
		s.setSize(0);
		;
		s.push(2);
		s.push(1);
		result = StackAndQueues.order(s);
		assertTrue(result.peek() == 2);
		s.setSize(0);
		s.push(0);
		s.push(2);
		s.push(1);
		result = StackAndQueues.order(s);
		assertTrue(result.peek() == 2);
		result.pop();
		assertTrue(result.peek() == 1);

	}
}
