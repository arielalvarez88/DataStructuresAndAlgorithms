package com.ariel.problems.tests.problems;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.w3c.dom.ls.LSInput;

import com.ariel.data_structures.LinkedListNode;
import com.ariel.problems.ListProblems;

public class ListProblemsTest {

	LinkedListNode first = new LinkedListNode(1, null);
	LinkedListNode second = new LinkedListNode(2, null);
	LinkedListNode third = new LinkedListNode(3, null);

	@Test
	public void testGetFirstCircle() {
		LinkedListNode first = new LinkedListNode(1, null);
		LinkedListNode second = new LinkedListNode(2, null);
		LinkedListNode third = new LinkedListNode(3, null);

		first.appendToTail(second);
		first.appendToTail(third);
		first.appendToTail(first);

		LinkedListNode firstInLoop = (LinkedListNode) ListProblems.getFirstCircle(first);
		assertTrue(firstInLoop == first);
	}

	@Test
	public void removeDuplicatesTest() {
		LinkedList<Object> l = new LinkedList<Object>(), noDuplicates = new LinkedList<Object>();
		l.add(1);
		l.add(2);
		l.add(1);
		l.add(3);
		l.add(2);
		noDuplicates = ListProblems.removeDuplicates(l);

		assertTrue(noDuplicates.pop().equals(1));
		assertTrue(noDuplicates.pop().equals(2));
		assertTrue(noDuplicates.pop().equals(3));

	}

	@Test
	public void isPalindrome() {
		LinkedList<Object> l = new LinkedList<Object>();
		l.add('b');
		l.add('o');
		l.add('o');
		l.add('b');
		assertTrue(ListProblems.isPalindrome(l));
		l.add('a');
		assertTrue(!ListProblems.isPalindrome(l));
		l.clear();
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(2);
		l.add(1);
		assertTrue(ListProblems.isPalindrome(l));

	}

	@Test
	public void sumTest() {
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		l1.addLast(7);
		l1.addLast(1);
		l1.addLast(6);

		l2.addLast(5);
		l2.addLast(9);
		l2.addLast(2);

		LinkedList<Integer> result = ListProblems.sum(l1, l2);
		System.out.print(result);
		assertTrue(result.removeFirst().equals(2));
		assertTrue(result.removeFirst().equals(1));
		assertTrue(result.removeFirst().equals(9));

	}

	@Test
	public void partitionTtest() {
		LinkedList<Integer> l = new LinkedList<Integer>(), result;

		l.add(5);
		l.add(6);
		l.add(1);

		result = ListProblems.partition(l, 5);
		assertTrue(result.get(0).equals(1));
		l.add(3);
		l.add(2);
		l.add(4);
		result = ListProblems.partition(l, 6);
		assertTrue(result.getLast().equals(6));
		result = ListProblems.partition(l, 4);
		assertTrue(result.get(0) < 4);
		assertTrue(result.get(1) < 4);
		assertTrue(result.get(2) < 4);
	}

	@Test
	public void sumForwardTest(){
		LinkedList<Integer> n1 = new LinkedList<Integer>();
		n1.add(1);
		n1.add(1);
		n1.add(9);
		n1.add(1);
		LinkedList<Integer> n2 = new LinkedList<Integer>();
		n2.add(9);
		n2.add(9);
		n2.add(9);
		LinkedList<Integer>result = ListProblems.sumForward(n1, n2);
		LinkedList<Integer>expected = new LinkedList<Integer>();
		Integer[] vals = {2,1,9,0};
		expected.addAll(Arrays.asList(vals));
		assertTrue(result.equals(expected));
	}

}
