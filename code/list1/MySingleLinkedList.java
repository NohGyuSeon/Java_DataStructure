package NGS.DataStructure.code.list1;

public class MySingleLinkedList<T> {
	
	public Node<T> head;
	public int size = 0;
	
	public MySingleLinkedList() {
		head = null;
		size = 0;
	}
	
	/*
	 * 새로운 노드를 만들고 추가할 데이터를 저장한다.
	 * 새로운 노드의 next 필드가 현재의 head 노드를 가리키도록 한다.
	 * 새로운 노드를 새로운 head 노드로 한다.
	 */
	public void addFirst(T item) {
  		Node<T> newNode = new Node<T>(item);
		newNode.next = head;
		head = newNode;
		size++;
	}

	/*
	 * 새로운 노드를 만들고 데이터를 저장한다.
	 * 새로운 노드의 next 필드가 before의 다음 노드를 가리키도록 한다.
	 * 새로운 노드를 before의 다음 노드로 만든다.
	 */
	public void addAfter(Node<T> before, T item) {
		Node<T> newNode = new Node<T>(item);
		newNode.next = before.next;
		before.next = newNode;
		size++;
	}
	
	// head가 null이 아니라면 head가 현재 head 노드의 다음 노드를 가리키게 만든다.
	public T removeFirst() {
		if (head == null) {
			return null;
		}
		T oldNode = head.data;
		head = head.next;
		size--;
		return oldNode;
	}
	
	// before의 다음 노드가 null이 아니라면 before의 next 필드가 
	// 현재 next 노드의 다음 노드를 가리키게 만든다.
	public T removeAfter(Node<T> before) {
		if (head == null) {
			return null;
		}
		T oldNode = before.next.data;
		before.next = before.next.next;
		size--;
		return oldNode;
	}
	
	public int indexOf(T item) {
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
	
	// 연결리스트의 index번째 노드의 주소를 반환한다.
	public Node<T> getNode(int index) {
		if (index < 0 || index >= size) {
			return null;
		}
		Node<T> p = head;
		for (int i = 0; i < index; i++) {
			p = p.next;
		}
		return p;
	}
	
	public void add(int index, T item) {
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
	
	public T remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(index);
		}
		if (index == 0) {
			return removeFirst();
		}
		Node<T> prev = getNode(index-1);
		return removeAfter(prev);
	}
	
	// 입력된 스트링을 저장한 노드를 찾아 삭제한다. 삭제된 노드에 저장된 스트링을 반환한다.
	// 삭제할 노드를 찾았음. 하지만 노드를 삭제하기 위해서는 삭제할 노드가 아니라 직전 노드의 주소가 필요함.
	public T remove(T item) {
		Node<T> p = head;
		Node<T> q = null;
		while (p != null && !p.data.equals(item)) {
			q = p;
			p = p.next;
		}
		if (p == null) {
			return null;
		}
		if (q == null) {
			return removeFirst();
		} else {
			return removeAfter(q);
		}
	}
	
	public T get(int index) {
		if (index < 0 || index >= size) {
			return null;
		}
		return getNode(index).data;
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
