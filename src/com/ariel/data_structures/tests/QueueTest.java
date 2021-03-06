package com.ariel.data_structures.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ariel.data_structures.Queue;

public class QueueTest {
	private Queue<Object> q;
	Object o1, o2, o3;

	@Before
	public void init() {
		q = new Queue<Object>();
		o1 = new Object();
		o2 = new Object();
		o3 = new Object();
	}

	@Test
	public void enqueueTest() {
		q.enqueue(o1);
		assertTrue(!q.isEmpty());
		assertTrue(q.getFirst() == o1);
		q.enqueue(o2);
		assertTrue(q.getFirst() == o1);
		assertTrue(q.getLast() == o2);

		assertTrue(q.size() == 2);

	}

	@Test
	public void dequeueTest() {
		q.enqueue(o1);

		Object o = q.dequeue();
		assertTrue(o == o1);
		assertTrue(q.isEmpty());
		q.enqueue(o1);
		q.enqueue(o2);
		o = q.dequeue();
		assertTrue(o == o1);
		assertTrue(q.dequeue() == o2);

		assertTrue(q.isEmpty());
	}
}
