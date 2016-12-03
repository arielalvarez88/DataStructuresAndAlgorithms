package com.ariel.data_structures.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ariel.data_structures.*;

public class StackTest {
	Stack q;
	Object o;

	@Before
	public void initQ() {
		this.q = new Stack();
		o = null;
	}

	@Test
	public void testPush() {
		q.push(1);
		assertTrue(q.size() == 1);
		q.push(2);

		assertTrue(q.size() == 2);
		q.pop();
		q.push(2);

		assertTrue(q.size() == 2);

	}

	@Test
	public void testPop() {
		q.push(1);
		Object o = q.pop();
		assertTrue(((Integer) o).equals(1));
		assertTrue(q.size() == 0);
		q.push(1);
		q.push(2);
		o = q.pop();
		assertTrue(((Integer) o).equals(2));
		assertTrue(q.size() == 1);
		q.pop();
		o = q.pop();
		assertTrue(o == null);

	}

	@Test
	public void testPeek() {
		q.push(1);
		o = q.peek();
		assertTrue(o.equals(1));
		assertTrue(q.size() == 1);
		q.push(2);
		;
		o = q.peek();
		assertTrue(o.equals(2));
		assertTrue(q.size() == 2);
		q.pop();
		q.pop();
		assertTrue(q.peek() == null);
		assertTrue(q.size() == 0);
	}

}
