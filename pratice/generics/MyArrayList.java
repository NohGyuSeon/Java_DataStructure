package NGS.DataStructure.pratice.generics;

import java.util.Arrays;

public class MyArrayList<E> {

	private static final int INIT_CAPACITY = 10;
	private E[] theData;
	private int size;
	private int capacity = INIT_CAPACITY;

	public MyArrayList() {
		theData = (E[]) new Object[INIT_CAPACITY];
		size = 0;
	}

	public void add(int index, E newEntry) {
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}

		if (size >= capacity)
			reallocate();
		for (int i = size - 1; i >= index; i--)
			theData[i + 1] = theData[i];
		theData[index] = newEntry;
	}

	private void reallocate() {
		capacity *= 2;
		theData = Arrays.copyOf(theData, capacity);
	}

	public void add(E newEntry) {
		add(size, newEntry);
	}

	public int size() {
		return size;
	}

	public int indexOf(E newEntry) {
		for (int i = 0; i < size; i++) {
			if (theData[i].equals(newEntry)) {
				return i;
			}
		}
		return -1;
	}

	public E get(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return theData[index];
	}

	public E set(int index, E newValue) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}

		E oldValue = theData[index];
		theData[index] = newValue;
		return oldValue;
	}

	public E remove(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}

		E returnValue = theData[index];
		for (int i = index + 1; i < size; i++) {
			theData[i - 1] = theData[i];
		}
		size--;

		return returnValue;
	}

	public static void main(String[] args) {
		MyArrayList<String> test = new MyArrayList<>();

		test.add(1, "Hello");

	}

}
