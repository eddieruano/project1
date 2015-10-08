/**
 * Eddie Ruano and Matt Piasecki
 * CPE 103 Fall 2015
 * Project 1
 *
 **/


import java.util.EmptyStackException;
import java.util.LinkedList;

/*	MyStack class contains linked list of type node based stack
 *	Methods include push,pop,peek,and isEmpty
 * */
public class MyStack<T> {
	private Node first;
	private LinkedList<Node> list;
	
	//constructs a new list and sets the first value to null
	public MyStack() {
		list = new LinkedList<Node>();
		first = null;
	}
	
	//Nested class node for linked list implementation
	private class Node {
		public T elem;
		public Node next;

		public Node(T e) {
		    this.elem = e;
		}
	}

	//adds item to list by creating a new node and setting that node to the first value of the list
	public void push(T item) {
		Node n = new Node(item);
		list.add(n);
	    n.next = first;
	    first = n;
	}

	//removes item from list by setting the first node in the list to the second
	//also returns the first node that was removed
	public T pop() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		} else {
			Node temp = first;
		    first = first.next;
		    return temp.elem;
		}

	}

	//returns the first node in the list
	public T peek() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException();
		} else {
			return first.elem;
		}
	}

	//returns true if the list is empty, false otherwise
	public boolean isEmpty() {
		return (first == null);
	}

}
