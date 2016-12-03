package com.ariel.data_structures.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ariel.data_structures.LinkedList;
import com.ariel.data_structures.LinkedListNode;

public class LinkedListTest {

	private LinkedListNode n1, n2, n3;
	private LinkedList l;

	@Before
	public void init() {
		l = new LinkedList();
		n1 = new LinkedListNode(1, null);
		n2 = new LinkedListNode(2, null);
		n3 = new LinkedListNode(3, null);
	}

	@Test
	public void testGetFirst() {
		assertTrue(l.getFirst() == null);
		l.addFirst(n1);
		assertTrue(l.getFirst() == n1);
		l.addFirst(n2);
		assertTrue(l.getFirst() == n2);
	}

	@Test
	public void testRemoveFirst() {
		LinkedListNode n = l.removeFirst();
		assertTrue(n == null);
		l.insertFirst(n1);
		assertTrue(l.removeFirst() == n1);
		assertTrue(l.removeFirst() == null);
		assertTrue(l.getLast() == null);
		l.insertLast(n1);
		l.insertLast(n2);
		assertTrue(l.removeFirst() == n1);
		assertTrue(l.getFirst() == n2);
		assertTrue(l.getLast() == n2);
		assertTrue(l.removeFirst() == n2);
		assertTrue(l.getFirst() == null);
		assertTrue(l.getLast() == null);
		assertTrue(l.removeFirst() == null);
	}

	@Test
	public void testRemoveLast() {
		assertTrue(l.removeLast() == null);
		l.addFirst(n1);

		assertTrue(l.removeLast() == n1);
		assertTrue(l.getFirst() == null);
		assertTrue(l.getLast() == null);
		l.insertLast(n1);

		l.addLast(n2);
		assertTrue(l.removeLast() == n2);
		assertTrue(l.getFirst() == n1);
		assertTrue(l.getLast() == n1);
		assertTrue(l.getLast() == n1);
		l.addLast(n2);
		l.addLast(n3);
		assertTrue(l.removeLast() == n3);
		assertTrue(l.getLast().getNext() == null);
	}

	@Test
	public void testInsterFirst() {
		l.insertFirst(n1);

		assertTrue(l.getFirst() == n1);
		assertTrue(l.getLast() == n1);
		l.insertFirst(n2);
		assertTrue(l.getFirst() == n2);
		assertTrue(l.getLast() == n1);

	}

	@Test
	public void testInsertLast() {
		l.insertLast(n1);
		;
		assertTrue(l.getFirst() == n1);
		assertTrue(l.getLast() == n1);
		l.insertLast(n2);
		;
		assertTrue(l.getFirst() == n1);
		assertTrue(l.getLast() == n2);
	}

	@Test
	public void testGetBefore() {
		l.insertLast(n1);
		assertTrue(l.getBefore(n1) == null);
		l.insertLast(n2);
		assertTrue(l.getBefore(n2) == n1);
		assertTrue(l.getBefore(n1) == null);
	}

	@Test
	public void testIndexOf() {
		l.insertLast(n1);
		assertTrue(l.indexOf(n2) < 0);
		assertTrue(l.indexOf(n1) == 0);
		l.insertLast(n2);
		assertTrue(l.indexOf(n2) == 1);
		assertTrue(l.indexOf(n1) == 0);
	}

	@Test
	public void testGetAt() {
		LinkedListNode n = l.getAt(2);
		assertTrue(n == null);
		l.insertLast(n1);

		assertTrue(l.getAt(0) == n1);
		l.insertLast(n2);

		assertTrue(l.getAt(0) == n1);
		assertTrue(l.getAt(1) == n2);
	}

}
