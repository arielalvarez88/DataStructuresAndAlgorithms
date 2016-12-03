package com.ariel.data_structures.tests;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.ariel.data_structures.LinkedListNode;

public class LinkedListNodeTest {

	LinkedListNode fourth, third, second, first;

	@Before
	public void beforeEach() {
		fourth = new LinkedListNode(3, null);
		third = new LinkedListNode(2, null);
		second = new LinkedListNode(1, null);
		first = new LinkedListNode(0, null);
	}

	@Test
	public void testAppend() {

		first.appendToTail(second);
		second.appendToTail(third);
		third.appendToTail(fourth);
		fourth.appendToTail(null);

		LinkedListNode n = first;
		int i = 0;
		while (n.getNext() != null) {
			if (n.getValue() != i) {
				fail();
			}
			n = n.getNext();
			i++;
		}

	}

	@Test	
	public void testGetValue() {
		LinkedListNode n = new LinkedListNode(1, null);
		assertTrue(n.getValue() == 1);
	}

	@Test	
	public void testSetValue() {

		LinkedListNode n = new LinkedListNode(1, null);
		n.setValue(10);
		assertTrue(n.getValue() == 10);
	}

	@Test	
	public void testGetNext() {
		first.appendToTail(third);

		assertTrue(first.getNext() == third);
	}

	@Test		
	public void testFindNodeInIdx() {

		first.appendToTail(second);		
		first.appendToTail(third);
		first.appendToTail(fourth);

		assertTrue(LinkedListNode.findNodeInIdx(0, first) == first);
		assertTrue(LinkedListNode.findNodeInIdx(1, first) == second);
		assertTrue(LinkedListNode.findNodeInIdx(3, first) == fourth);

	}

	@Test	
	public void testDelete() {
		first.appendToTail(second);
		second.appendToTail(third);
		LinkedListNode.delete(first, third);
		assert (second.getNext() == null);
		assert (first.getNext() == second);

		second.appendToTail(third);

		LinkedListNode.delete(first, second);
		assert (first.getNext() == third);

		first.setNext(second);

		LinkedListNode newFirst = LinkedListNode.delete(first, first);

		assertTrue(newFirst == second);

		first.setNext(second);

		LinkedListNode.delete(first, third);

		assertTrue(second.getNext() == null);

	}

}
