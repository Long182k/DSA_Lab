package list;

public class MyStack<E> {
	
	SLinkedList<E> list = new SLinkedList<E>(); // We implement it by add to head, remove from head
	
	public boolean empty() {
		return list.size() == 0;
	}
	
	public E pop() {
		return list.remove(0);
	}
	
	public E peek() {
		return list.get(0);
	}
	
	public E push(E e) {
		list.add(0, e);
		return e;
	}

	public int search(E e) {
		int i = list.indexOf(e);
		return i<0? i : i + 1;
	}
}
