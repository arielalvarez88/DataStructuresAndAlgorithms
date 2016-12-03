package com.ariel.data_structures;

import org.w3c.dom.Node;

public class LinkedListNode {

	int value;
	LinkedListNode next;

	public LinkedListNode(int val, LinkedListNode next) {

		this.value = val;
		this.next = next;
	}

	public void appendToTail(LinkedListNode node) {
		LinkedListNode n = this;
		while (n.getNext() != null) {
			n = n.getNext();
		}
		n.next = node;
		

	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public LinkedListNode getNext() {
		return next;
	}

	/**
	 * Returns the new First element in the list. The list won't have the
	 * toDelete Node anymore.
	 * 
	 * @param head
	 * @param toDelete
	 * @return
	 */
	public static LinkedListNode delete(LinkedListNode head, LinkedListNode toDelete) {
		LinkedListNode n = head;
		if (toDelete == head) {
			return n.getNext();
		}
		while (n.getNext() != null) {
			if (n.getNext() == toDelete) {
				n.setNext(n.getNext().getNext());
				return head;
			}
			n = n.getNext();

		}

		return head;
	}

	public void setNext(LinkedListNode next) {
		this.next = next;
	}

	public static LinkedListNode findNodeInIdx(int idx, LinkedListNode first) {
		int currentIdx = 0;
		LinkedListNode current = first;
		while (current != null) {
			if (currentIdx == idx) {
				return current;
			}
			currentIdx++;
			current = current.getNext();
		}
		return null;
	}

}
