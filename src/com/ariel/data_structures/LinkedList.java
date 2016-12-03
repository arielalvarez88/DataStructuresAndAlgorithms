package com.ariel.data_structures;

public class LinkedList {

	private LinkedListNode first;
	private LinkedListNode last;

	public LinkedListNode getFirst() {
		return first;

	}

	public void setLastNode(LinkedListNode last) {
		if (this.last != null) {
			this.last.setNext(last);
		}
		this.last = last;
	}

	public LinkedListNode getLast() {
		return this.last;
	}

	public void setFirst(LinkedListNode first) {
		if (this.first != null) {
			first.setNext(this.first);
		}else{
			this.last = first;
		}
		this.first = first;
	}
	
	public void addFirst(LinkedListNode first) {
		this.setFirst(first);
	}

	public LinkedListNode removeFirst() {
		LinkedListNode prevFirst = this.first;
		if (this.first != null) {
			this.first = this.first.getNext();

		}
		if (prevFirst == this.last) {
			this.last = null;
			this.first = null;

		}
		return prevFirst;
	}

	public LinkedListNode removeLast() {
		LinkedListNode last = this.last;
		LinkedListNode beforeLast = this.getBefore(last);
		if (beforeLast != null) {
			beforeLast.setNext(null);

			this.last = beforeLast;
		} else {
			this.first = null;
			this.last = null;
		}

		return last;
	}

	public void insertFirst(LinkedListNode n) {
		n.setNext(this.first);
		if (this.first == null) {
			this.last = n;
		}
		this.first = n;
	}
	


	public void insertLast(LinkedListNode n) {
		if (this.last != null) {
			this.last.setNext(n);
		}else{
			this.first = n;
		}
		
		this.last = n;
	}
	
	public void addLast(LinkedListNode n) {
		this.insertLast(n);
	}
	
	public void add(LinkedListNode n) {
		this.insertLast(n);
	}

	public LinkedListNode getBefore(LinkedListNode n) {
		LinkedListNode current = this.first;
		while (current != null) {
			if (current.getNext() == n) {
				return current;
			}
			current = current.getNext();
		}
		return null;
	}

	public int indexOf(LinkedListNode n) {
		int pos = 0;
		LinkedListNode current = this.first;
		while (current != null) {
			if (current == n) {
				return pos;
			}
			pos++;
			current = current.getNext();
		}
		return -1;
	}

	public LinkedListNode getAt(int i) {
		LinkedListNode n = this.first;
		int idx = 0;
		while (n != null) {
			if (idx == i) {
				return n;
			}
			n = n.getNext();
			idx++;
		}
		return null;
	}
	
	public int size(){
		int size =0;
		LinkedListNode c = this.first;
		while(c!=null){
			size++;
			c=c.getNext();
		}
		
		return size;
		
		
	}
	
	public void clear(){
		this.first = null;
		this.last = null;
	}

}
