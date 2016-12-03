package com.ariel.problems.tests;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Ignore;
import org.junit.Test;

import com.ariel.data_structures.LinkedListNode;
import com.ariel.problems.ListProblems;

public class ListProblemsTest {

	@Test
	@Ignore
	public void testGetFirstCircle() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testRemoveDuplicatesLinkedListOfObject() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testIsPalindrome() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testReverse() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testSum() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testPartition() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testSumForward() {
		fail("Not yet implemented");
	}

	@Test
	@Ignore
	public void testRemoveDuplicatesLinkedListLinkedListNode() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveDuplicates() {
		LinkedListNode n1 = new LinkedListNode(1, null), n2 = new LinkedListNode(2, null),
				n3 = new LinkedListNode(3, null), n22 = new LinkedListNode(2, null), n23 = new LinkedListNode(2, null),
				c;
		com.ariel.data_structures.LinkedList l = new com.ariel.data_structures.LinkedList();
		l.addLast(n1);
		l.addLast(n2);
		l.addLast(n3);
		l.addLast(n22);
		l.addLast(n23);
		l = ListProblems.removeDuplicates(l, l.getFirst());
		assertTrue(l.size() == 3);
		int count = 0;
		c = l.getFirst();
		while (c != null) {
			if (c.getValue() == 2) {
				count++;
			}
			c = c.getNext();
		}
		assertTrue(count == 1);
		l.clear();
		l.addLast(n1);
		l.add(n2);
		l.add(n22);
		l.add(n3);
		l.add(n23);
		l = ListProblems.removeDuplicates(l, l.getFirst());
		for (int i = 0; i < 3; i++) {
			assertTrue(i + 1 == l.getAt(i).getValue());
		}
		assertTrue(l.size() == 3);
		l.clear();
		l.add(n2);
		l.add(n22);
		l.add(n3);
		l = ListProblems.removeDuplicates(l, l.getFirst());
		assertTrue(l.getLast().getValue() == 3);
		assertTrue(l.getFirst().getValue() == 2);
		assertTrue(l.size() == 2);
				
	}

	@Test
	public void findKElementTest() {
		java.util.LinkedList<Integer> l = new java.util.LinkedList<Integer>();
		l.add(1);
		assertTrue(ListProblems.findKElement(l, 1).equals(1));
		l.addFirst(2);

		assertTrue(ListProblems.findKElement(l, 1).equals(2));
		assertTrue(ListProblems.findKElement(l, 2).equals(1));
		l.addLast(3);

		assertTrue(ListProblems.findKElement(l, 1).equals(2));
		assertTrue(ListProblems.findKElement(l, 2).equals(1));
		assertTrue(ListProblems.findKElement(l, 3).equals(3));

	}

}
