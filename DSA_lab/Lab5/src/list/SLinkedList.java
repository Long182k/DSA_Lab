package list;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SLinkedList<E> implements List<E> {
	
	private Node<E> head, tail;
	private int size;
	
	public SLinkedList(){
		head = new Node<>(null, null);
		tail = new Node<>(null, null);
		head.next = tail; 
		tail.next = head;
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public void clear() {
		while(!isEmpty())
			removeAfter(head);
	}


	private void checkValidIndex(int index){
		if((index < 0) || (index >= size) ){
			String message = String.format("Invalid index (=%d)", index);
			throw new IndexOutOfBoundsException(message);
		}
	}
	
	private Node<E> getDataNode(int index) {
		checkValidIndex(index);
		Node<E> curNode = head.next;
		int runIndex = 0;
		while(curNode != tail){
			if(index == runIndex) break;
			runIndex += 1;
			curNode = curNode.next;
		}
		return curNode;
	}
	
	private Node<E> getNode(int index) {
		if((index < -1) || (index >= size) ){
			String message = String.format("Invalid index (including head) (=%d)", index);
			throw new IndexOutOfBoundsException(message);
		}
		Node<E> curNode = head;
		int runIndex = -1;
		while(curNode != tail){
		if(index == runIndex) break;
			runIndex += 1;
			curNode = curNode.next;
		}
		return curNode;
	}
	
	private void addAfter(Node<E> afterThis, Node<E> newNode){
		newNode.next = afterThis.next;
		afterThis.next = newNode;
		if(newNode.next == tail) tail.next = newNode;
		size += 1;
	}

	public void add(int index, E element) {
		Node<E> prevNode = getNode(index-1);
		Node<E> newNode = new Node<>(null, element);
		addAfter(prevNode, newNode);
	}
	
	public boolean add(E e) {
		Node<E> newNode = new Node<E>(null, e);
		Node<E> lastNode = tail.next;
		addAfter(lastNode, newNode);
		return true;
	}
	
	private Node<E> removeAfter(Node<E> afterThis){
		Node<E> removedNode = afterThis.next;
		afterThis.next = removedNode.next;
		if(removedNode.next == tail) tail.next = afterThis;
		removedNode.next = null;
		size --;
		return removedNode;
	}
	
	public boolean remove(Object o) {
		Node<E> prevNode = head;
		Node<E> curNode = head.next;
		boolean found = false;
		while(curNode != tail){
			if(curNode.element.equals(o)){
				found = true;
				removeAfter(prevNode);
				break;
			}
			curNode = curNode.next;
			prevNode = prevNode.next;
		}
		return found;
	}
	
	public E remove(int index) {
		if(size == 0){
			String message = String.format("Remove at %d, but the list is empty", index);
			throw new IndexOutOfBoundsException(message);
		}
		Node<E> prevNode = getNode(index-1);
		Node<E> curNode = prevNode.next;
		removeAfter(prevNode);
		return curNode.element;
	}
	
	@Override
	public boolean contains(Object o) {
		Node<E> node = head.next;
		while(node != tail) {
			if(node.element == o)
				return true;
			node = node.next;
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return new MyIterator();
	}

	@Override
	public E get(int index) {
		return this.getDataNode(index).element;
	}

	@Override
	public E set(int index, E element) {
		Node<E> node = this.getDataNode(index);
		E old = node.element;
		node.element = element;
		return old;
	}

	@Override
	public int indexOf(Object o) {
		int idx = 0;
		Node<E> node = head.next;
		while(node != tail) {
			if(node.element == o)
				return idx;
			node = node.next;
			idx ++;
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		int idx = 0;
		int last = -1;
		Node<E> node = head.next;
		while(node != tail) {
			if(node.element == o)
				last = idx;
			node = node.next;
			idx ++;
		}
		return last;
	}

	@Override
	public ListIterator<E> listIterator() {
		return new MyListIterator(0);
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return new MyListIterator(index);
	}
	
	public class MyIterator implements Iterator<E>{
		Node<E> prevNode = null;
		Node<E> curNode = SLinkedList.this.head;
		boolean afterMove = false;
		
		@Override
		public boolean hasNext() {
			return curNode.next != SLinkedList.this.tail;
		}
		
		@Override
		public E next() {
			prevNode = curNode;
			curNode = curNode.next;
			afterMove = true;
			return curNode.element;
		}
		
		@Override
		public void remove() {
			if(!afterMove) return;
			SLinkedList.this.removeAfter(prevNode);
			curNode = prevNode;
			afterMove = false;
		}
	}//End of MyIterator
	
	public class MyListIterator extends MyIterator implements ListIterator<E>{
		
		public MyListIterator(int index){
			curNode = SLinkedList.this.getNode(index - 1);
		}
		
		public boolean hasPrevious() {
			throw new UnsupportedOperationException("Not supported yet.");
		}
		
		public void remove() {
			super.remove();
		}
		
		public E previous() {
			throw new UnsupportedOperationException("Not supported yet.");
		}
		
		public int nextIndex() {
			throw new UnsupportedOperationException("Not supported yet.");
		}
		public int previousIndex() {
			throw new UnsupportedOperationException("Not supported yet.");
		}
		
		public void set(E e) {
			if(!afterMove) return;
			curNode.element = e;
		}
		
		public void add(E e) {
			if(!afterMove) return;
			SLinkedList.this.addAfter(curNode, new Node<E>(null, e));
			curNode = curNode.next;
			afterMove = false;
		}
	}//End of MyListIterator

	@Override
	public Object[] toArray() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public <T> T[] toArray(T[] a) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	@Override
	public boolean containsAll(Collection<?> c) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}

class Node<E>{
	E element;
	Node<E> next;
	
	Node(Node<E> next, E element){
		this.next = next;
		this.element = element;
	}
	
	void update(Node<E> next, E element){
		this.next = next;
		this.element = element;
	}
}
