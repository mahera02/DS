package org.linklist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkList<E> implements Iterable {

	// inner class represents a node in our linklist
	public class Node<E> {

		Node<E> next;
		E data;

		public Node(E data) {
			this.next = null;
			this.data = data;
		}
	}

	class IteratorHelper implements Iterator<E> {

		Node<E> index;

		public IteratorHelper() {
			index = head;
		}

		@Override
		public boolean hasNext() {
             if(index == null)
			return false;
             else 
            	 return true;
		}

		@Override
		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			E val = index.data;
			index = index.next;
			return val;
		}

	}
	/*
	 * // boundary conditions for datastructures 1. Empty Data structure 2. Single
	 * element in DS 3. Adding/removing in the beginning of DS 4. Adding/removing
	 * from the end of DS 5. working in the middle
	 */

	private Node<E> head;
	private Node<E> tail;
	private int currentSize;

	public MyLinkList() {
		this.head = null;
		this.currentSize = 0;
	}

	// adding in the empty linklist when head points to null
	public void addFirst(E obj) {
		Node<E> node = new Node<E>(obj);
		if (head == null) {
			head = tail = node;
			currentSize++;
			return;
		}
		node.next = head;
		head = node;
		currentSize++;

	}

	// adding at the end of linklist (assume we have three nodes)
	public void addLast(E obj) {
		Node<E> node = new Node<E>(obj);
		if (head == null) {
			head = node;
			currentSize++;
			return;
		}
		/*
		 * Using below code gives us O(n) complexity because tmp points to head and we
		 * traverse all nodes till end . 
		 * Node<E> tmp = head; while (tmp.next != null) {
		 * tmp = tmp.next; } tmp.next = node; currentSize++;
		 */
	}

	// adding at the end of linklist (assume we have three nodes)
	// Complexity O(1)
	public void addLastAlternativeMethod(E obj) {
		Node<E> node = new Node<E>(obj);
		if (head == null) {
			head = tail = node;
			currentSize++;
			return;
		}
		tail.next = node;
		tail = node;
		currentSize++;

	}

	public E removeFirst() {
		if (head == null) {
			return null;
		}
		E tmp = head.data;
		// when we have only one element in the list
		if (head == tail) {
			head = tail = null;
		} else {
			head = head.next;
		}
		currentSize--;
		return tmp;
	}

	public E removeLast() {
		if (head == null) {
			return null;
		}
		// when we have only one element in the list
		if (head == tail) {
			head = tail = null;
			currentSize--;
			return null;
		}
		Node<E> previous = null;
		Node<E> current = head;
		while (current != tail) {
			previous = current;
			current = current.next;
		}
		previous.next = null;
		tail = previous;
		currentSize--;
		return current.data;
	}
	
	public int getCurrentSize() {
		return currentSize;
	}

	@SuppressWarnings("unchecked")
	public E remove(E obj) {
		Node<E> previous = null;
		Node<E> current = head;
		while(current !=null) {
			if((((Comparable<E>)obj).compareTo(current.data))==0) {
				if(current == head) {
					head = tail = null;
					return current.data;
				}
				if(current ==tail) {
					tail = previous;
					return current.data;
				}
				currentSize--;
				previous.next =current.next;
				return current.data;
			}
			previous = current;
			current = current.next;
		}
		return null;
	}

	public boolean contains(E obj) {
		Node<E> current = head;
		while (current != null) {
			if ((((Comparable<E>) obj).compareTo(current.data)) == 0) {
				return true;
			}
			current = current.next;
		}
	return false;
	}
	
	public E peekFirst() {
		if(head ==null) {
			return null;
		}
		return head.data;
	}
	
	//O(1) complexity
	public E peekLast() {
		if(tail==null)
			return null;
		return tail.data;
	}

	@Override
	public Iterator<E> iterator() {
		return new IteratorHelper();
	}

}
