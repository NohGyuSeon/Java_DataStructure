package NGS.DataStructure.pratice.list3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MySingleLinkedList<T> implements Iterable {
	public Node<T> head;
	public int size = 0;
	
	public MySingleLinkedList() {
		head = null;
		size = 0;
	}
	
	private class Node<T> {
		public T data;
		public Node<T> next;
		
		public Node(T item) {
			data = item;
			next = null;
 		}
	}

	private void addFirst(T item) {
		Node<T> newNode = new Node<T>(item);
		newNode.next = head;
		head = newNode;
		size++;
	}
	
	private void addAfter(Node<T> before, T item) {
		Node<T> newNode = new Node<T>(item);
		newNode.next = before.next;
		before.next = newNode;
		size++;
	}
	
	private T removeFirst() {
		if (head == null) {
			return null;
		}
		T oldNode = head.data;
		head = head.next;
		size--;
		return oldNode;
	}
	
	private T removeAfter(Node<T> before) {
		if (head == null) {
			return null;
		}
		T oldNode = before.next.data;
		before.next = before.next.next;
		size--;
		return oldNode;
	}
	
	private int indexOf(T item) {
		Node<T> p = head;
		int index = 0;
		while(p != null) {
			if (p.data.equals(item)) {
				return index;
			}
			p = p.next;
			index++;
		}
		return -1;
	}
	
	private Node<T> getNode(int index) {
		if (index < 0 || index >= size) {
			return null;
		}
		Node<T> p = head;
		for (int i = 0; i < index; i++) {
			p = p.next;
		}
		return p;
	}
	
	private void add(int index, T item) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException(index);
		}
		if (index == 0) {
			addFirst(item);
		} else {
			Node<T> q = getNode(index-1);
			addAfter(q, item);
		}
	}
	
	private T remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(index);
		}
		if (index == 0) {
			return removeFirst();
		}
		Node<T> prev = getNode(index-1);
		return removeAfter(prev);
	}
	
	private boolean remove(T item) { 
		Node<T> p = head, q = null;
		while (p != null && !p.data.equals(item)) {
			q = p;
			p = p.next;
		}
		if (p == null) {
			return false;
		}
		if (q == null) {
			T tmp = removeFirst();
			return (tmp != null);
		} else {
			T tmp = removeAfter(q);
			return (tmp != null);
		}
	}
	
	private T get(int index) {
		if (index < 0 || index >= size) {
			return null;
		}
		return getNode(index).data;
	}

	@Override
	public Iterator iterator() {
		return new MyIterator();
	}
	
	private class MyIterator implements Iterator<T> {
		private Node<T> nextNode;

		public MyIterator() {
			nextNode = head;
		}

		@Override
		public boolean hasNext() {
			return (nextNode != null);
		}
		
		@Override
		public T next() {
			if (nextNode == null) {
				throw new NoSuchElementException();
			}
			T val = nextNode.data;
			nextNode = nextNode.next;
			return val;
		}
	}
	
	public static void main(String[] args) {
		MySingleLinkedList<String> list = new MySingleLinkedList<>();
		list.add(0, "Saturday");
		list.add(1, "Friday");
		list.add(0, "Monday");
		list.add(2, "Tuesday");
		
		String str = list.get(2);
		list.remove(2);
		int pos = list.indexOf("Friday");
		
		for(int i = 0; i <list.size; i++) {
			System.out.println(list.get(i));
		}
	}
	
}
