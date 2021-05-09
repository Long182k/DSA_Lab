package list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;



public class DLinkedList<E> implements List<E>{
	
	@SuppressWarnings("hiding")
	class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;
        public Node() {}
        public Node(E e) {element = e;}
	}
	
	private int size;
	private Node<E> head, tail;
	
	public DLinkedList() {
		head = new Node<E>();
		tail = new Node<E>();
		head.next = tail;
		tail.prev = head;
		size = 0;
	};
	
	// Utility methods
	
	private void checkDataIndex(int index) {
		if(index < -1 || index > size) {
            String message = String.format("Invalid index (=%d)", index);
            throw new IndexOutOfBoundsException(message);
		}
	}
	
	private void checkNodeIndex(int index) {
		if(index < -1 || index > size) {
            String message = String.format("Invalid index (=%d)", index);
            throw new IndexOutOfBoundsException(message);
		}
	}
	
	private Node<E> getNode(int index) {
		checkNodeIndex(index);
		Node<E> cur = head;
		for(int i = -1; i < index; i++)
			cur = cur.next;
		return cur;
	}
	
	private void insertNodeBetween(Node<E> leftNode, Node<E> rightNode, Node<E> newNode) {
		leftNode.next = newNode;
		newNode.prev = leftNode;
		rightNode.prev = newNode;
		newNode.next = rightNode;
		size ++;
	}
	
	private void removeNode(Node<E> current) {
		current.prev.next = current.next;
		current.next.prev = current.prev;
		current.prev = current.next = null;
		current.element = null;
		size --;
	}
	
	// List methods

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size <= 0;
	}

	@Override
	public boolean contains(Object o) {
		Node<E> cur = head.next;
		while(cur != tail) {
			if(cur.element.equals(o))
				return true;
			cur = cur.next;
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return new DIterator();
	}

	@Override
	public Object[] toArray() {
    	throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean add(E e) {
		Node<E> newNode = new Node<E>(e);
		insertNodeBetween(tail.prev, tail, newNode);
		return true;
	}

	@Override
	public boolean remove(Object o) {
		Node<E> cur = head.next;
		while(cur != tail) {
			if(cur.element.equals(o)) {
				removeNode(cur);
				return true;
			}
			cur = cur.next;
		}
		return false;
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
	public void clear() {
		while(size > 0)
			removeNode(head.next);
	}

	@Override
	public E get(int index) {
		checkDataIndex(index);
		Node<E> n = getNode(index);
		return n.element;
	}

	@Override
	public E set(int index, E element) {
		checkDataIndex(index);
		Node<E> n = getNode(index);
		n.element = element;
		return element;
	}

	@Override
	public void add(int index, E element) {
		Node<E> cur = getNode(index - 1);
		insertNodeBetween(cur, cur.next, new Node<E>(element));
	}

	@Override
	public E remove(int index) {
		checkDataIndex(index);
		Node<E> cur = getNode(index);
		E element = cur.element;
		removeNode(cur);
		return element;
	}

	@Override
	public int indexOf(Object o) {
		Node<E> cur = head.next;
		int index = 0;
		while(cur != tail) {
			if(cur.element.equals(o))
				return index;
			cur = cur.next;
			index ++;
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		Node<E> cur = tail.prev;
		int index = size - 1;
		while(cur != head) {
			if(cur.element.equals(o))
				return index;
			cur = cur.prev;
			index --;
		}
		return -1;
	}

	@Override
	public ListIterator<E> listIterator() {
		return new DListIterator();
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return new DListIterator(index);
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
    	throw new UnsupportedOperationException("Not supported yet.");
	}
	
	// ITERATORS
	
	public class DIterator implements Iterator<E> {
		
		Node<E> current;
		boolean afterMove;
		
		public DIterator() {
			current = DLinkedList.this.head.next;
			afterMove = false;
		}

		@Override
		public boolean hasNext() {
			return current != tail;
		}

		@Override
		public E next() {
			E e = current.element;
			current = current.next;
			afterMove = true;
			return e;
		}

		@Override
		public void remove() {
			DLinkedList.this.removeNode(current.prev);
			afterMove = false;
		}
	}
	
	public class DListIterator extends DIterator implements ListIterator<E>{

		int index;
		boolean isMovingForward = true;
		
		public DListIterator(int start) {
			super();
			index = start;
			this.current = DLinkedList.this.getNode(start);
		}
		
		public DListIterator() {
			this(0);
		}
		
		@Override
		public void remove() {
			if(isMovingForward)
				super.remove();
			else {
				Node<E> newCur = current.next;
				DLinkedList.this.removeNode(current);
				current = newCur;
				afterMove = false;
			}		
		}
		
		@Override
		public E next() {
			isMovingForward = true;
			index ++;
			return super.next();
		}
		
		@Override
		public boolean hasPrevious() {
			return current.prev != head;
		}

		@Override
		public E previous() {
			isMovingForward = false;
			index --;
			E e = current.prev.element;
			current = current.prev;
			afterMove = true;
			return e;
		}

		@Override
		public int nextIndex() {
			return index;
		}

		@Override
		public int previousIndex() {
			return index - 1;
		}

		@Override
		public void set(E e) {
			if(!afterMove)
				return;
			if(isMovingForward)
				current.prev.element = e;
			else
				current.element = e;
		}

		@Override
		public void add(E e) {
			if(!afterMove)
				return;

            Node<E> newNode = new Node<>(e);
            
			if(isMovingForward) {
				DLinkedList.this.insertNodeBetween(current.prev, current, newNode);
			}else {
				DLinkedList.this.insertNodeBetween(current.prev, current, newNode);
				current = current.prev;
			}
		}
		
	}

}
