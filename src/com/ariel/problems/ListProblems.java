package com.ariel.problems;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

import com.ariel.data_structures.LinkedListNode;

public class ListProblems {

	public static Object getFirstCircle(LinkedListNode corrupted) {
		HashSet<Object> set = new HashSet<Object>();
		LinkedListNode n = corrupted;

		while (n != null) {

			if (set.contains(n)) {
				return n;
			}

			set.add(n);
			n = n.getNext();

		}

		return null;
	}

	public static LinkedList<Object> removeDuplicates(LinkedList<Object> l) {
		HashSet<Object> hs = new HashSet<Object>();
		LinkedList<Object> result = new LinkedList<Object>();

		for (Object o : l) {
			if (!hs.contains(o)) {
				result.add(o);
			}
			hs.add(o);
		}
		return result;
	}

	public static boolean isPalindrome(LinkedList<Object> l) {
		LinkedList<Object> lBackwards = ListProblems.reverse(l);
		return l.equals(lBackwards);
	}

	public static <T> LinkedList<T> reverse(LinkedList<T> l) {
		Iterator<T> backwards = l.descendingIterator();
		LinkedList<T> lBackwards = new LinkedList<T>();
		while (backwards.hasNext()) {
			lBackwards.add(backwards.next());
		}
		return lBackwards;
	}

	public static LinkedList<Integer> sum(LinkedList<Integer> a, LinkedList<Integer> b) {
		int reminder = 0, x = 0, y = 0, digit = 0;
		LinkedList<Integer> result = new LinkedList<Integer>();
		while (a.size() != 0 || b.size() != 0) {
			x = a.size() != 0 ? a.pop() : 0;
			y = b.size() != 0 ? b.pop() : 0;
			digit = (x + y + reminder) % 10;
			reminder = (int) (x + y + reminder) / 10;
			result.push(digit);
		}
		if (reminder != 0) {
			result.addFirst(reminder);
		}
		return ListProblems.reverse(result);
	}

	public static LinkedList<Integer> partition(LinkedList<Integer> l, int val) {
		LinkedList<Integer> partitionedList = new LinkedList<Integer>();
		for (Integer i : l) {
			if (i < val) {
				partitionedList.addFirst(i);
			} else {
				partitionedList.addLast(i);
			}
		}

		return partitionedList;
	}

	public static LinkedList<Integer> sumForward(LinkedList<Integer> n1, LinkedList<Integer> n2) {

		int reminder = 0, digit = 0;
		Iterator<Integer> i1 = n1.descendingIterator();
		Iterator<Integer> i2 = n2.descendingIterator();
		LinkedList<Integer> result = new LinkedList<Integer>();

		while (i1.hasNext() || i2.hasNext()) {
			Integer x = i1.hasNext() ? i1.next() : 0;
			Integer y = i2.hasNext() ? i2.next() : 0;

			digit = (x + y + reminder) % 10;
			reminder = (x + y + reminder) / 10;
			result.addFirst(digit);

		}
		if (reminder != 0) {
			result.addFirst(reminder);
			;

		}
		return result;
	}

	public static com.ariel.data_structures.LinkedList removeDuplicates(com.ariel.data_structures.LinkedList l,
			LinkedListNode n) {
		LinkedListNode c, next, prev = n;
		if (n == null) {
			return l;
		}
		c = n.getNext();
		while (c != null) {
			if (c.getValue() == n.getValue()) {
				next = c.getNext();
				if (next != null) {
					c.setValue(next.getValue());
					c.setNext(next.getNext());

				} else {
					prev.setNext(null);
					break;
				}
			} else {
				prev = c;
				c = c.getNext();
			}

		}
		return ListProblems.removeDuplicates(l, n.getNext());
	}

	public static <T> T findKElement(LinkedList<T> l, int k) {
		int count = 0;
		for (T el : l) {
			count++;
			if (count >= k) {
				return el;
			}
		}
		return null;
	}
}
