package list;

public class MyQueue<E> {
	SLinkedList<E> list = new SLinkedList<E>(); // We implement it by add to tail, remove from head
	
	public boolean empty() {
		return list.size() == 0;
	}
	
	public E dequeue() {
		return list.remove(0);
	}
	
	public E peek() {
		return list.get(0);
	}
	
	public E enqueue(E e) {
		list.add(e);
		return e;
	}
}
