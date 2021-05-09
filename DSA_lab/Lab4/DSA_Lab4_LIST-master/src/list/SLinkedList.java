package list;

import java.util.*;

public class SLinkedList<E> implements List<E> {
    private enum MoveType {NEXT, PREV}

    //    Internal data fields
    Node<E> head;
    Node<E> tail;
    int size;

//    Constructors
    public SLinkedList() {
        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        head.next = tail;
        tail.next = head;
        size = 0;
    }

    public SLinkedList(Collection<? extends E> c) {
        Object[] a = c.toArray();

        head = new Node<>(null, null);
        tail = new Node<>(null, null);
        head.next = tail;
        tail.next = head;

        for (Object o : a) {
            @SuppressWarnings("unchecked") E e = (E) o;
            add(e);
        }

        size = c.size();
    }

    //    Utilities (Private)
    private void checkValidIndex(int index) {
        if ((index < 0) || (index >= size)) {
            String message = String.format("Invalid index (=%d)", index);
            throw new IndexOutOfBoundsException(message);
        }
    }

    private Node<E> getDataNode(int index) {
        Node<E> curNode = head.next;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        return curNode;
    }

    //    getNode: can return head
    private Node<E> getNode(int index) {
//        Check Valid Index (including head)
        if ((index < -1) || (index >= size)) {
            String message = String.format("Invalid index (including head) (=%d)", index);
            throw new IndexOutOfBoundsException(message);
        }
//        Get Node
        Node<E> curNode = head;
        for (int i = -1; i < index; i++) {
            curNode = curNode.next;
        }
        return curNode;
    }

    private void addAfter(Node<E> afterThis, Node<E> newNode) {
        newNode.next = afterThis.next;
        afterThis.next = newNode;
        if (newNode.next == tail) {
            tail.next = newNode;
        }
        size += 1;
    }

    private Node<E> removeAfter(Node<E> afterThis) {
        Node<E> removedNode = afterThis.next;
        afterThis.next = removedNode.next;
        if (removedNode.next == tail) {
            tail.next = afterThis;
        }
        removedNode.next = null;
        size -= 1;
        return removedNode;
    }

    //    Utilities
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public String toString() {
        if (size != 0) {
            StringBuilder string = new StringBuilder();
            string.append("[");
            for (E element : this) {
                string.append(element);
                string.append(", ");
            }
            string.delete(string.length() - 2, string.length());
            string.append("]");
            return string.toString();
        } else {
            return "[]";
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<E> {
        Node<E> prev = SLinkedList.this.head;
        Node<E> cur = prev.next;
        int cursor = 0;
        MoveType moveType = MoveType.NEXT;
        boolean afterMove = false;

        @Override
        public boolean hasNext() {
            return cursor != SLinkedList.this.size;
        }

        @Override
        public E next() {
            if (afterMove) {
                prev = prev.next;
            }
            moveType = MoveType.NEXT;
            afterMove = true;
            cur = cur.next;
            cursor += 1;
            return prev.next.element;
        }

        @Override
        public void remove() {
            if (afterMove) {
                removeAfter(prev);
                afterMove = false;
                cursor -= 1;
            }
        }
    }

    @Override
    public boolean add(E e) {
        Node<E> newNode = new Node<>(null, e);

        tail.next.next = newNode;
        newNode.next = tail;
        tail.next = newNode;
        size += 1;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node<E> prev = head;
        Node<E> cur = head.next;
        while (cur != tail && !cur.equals(o)) {
            prev = cur;
            cur = cur.next;
        }
        removeAfter(prev);
        return true;
    }

    @Override
    public void clear() {
        for (Node<E> x = head; x != tail; ) {
            Node<E> next = x.next;
            x.element = null;
            x.next = null;
            x = next;
        }
        head.next = tail;
        tail.next = head;
        size = 0;
    }

    @Override
    public E get(int index) {
        checkValidIndex(index);
        return getDataNode(index).element;
    }

    @Override
    public E set(int index, E element) {
        checkValidIndex(index);
        Node<E> node = getDataNode(index);
        node.element = element;
        return node.element;
    }

    @Override
    public void add(int index, E element) {
//        Check valid index to include max size
        if ((index < 0) || (index > size)) {
            String message = String.format("Invalid index (=%d)", index);
            throw new IndexOutOfBoundsException(message);
        }

        Node<E> prevNode = getNode(index - 1);
        Node<E> newNode = new Node<>(null, element);
        addAfter(prevNode, newNode);
    }

    @Override
    public E remove(int index) {
        checkValidIndex(index);
        Node<E> prevNode = getNode(index - 1);
        return removeAfter(prevNode).element;
    }

    @Override
    public int indexOf(Object o) {
//        Bad implementation O(N^2)
        Node<E> node;
        for (int i = 0; i < size; i++) {
            node = getNode(i);
            if (node.equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
//        Bad implementation O(N^2)
        Node<E> node;
        for (int i = size - 1; i >= 0; i--) {
            node = getNode(i);
            if (node.equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new MyListIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new MyListIterator(index);
    }

    private class MyListIterator extends MyIterator implements ListIterator<E> {
        public MyListIterator() {
        }

        public MyListIterator(int index) {
            SLinkedList.this.checkValidIndex(index);
            prev = SLinkedList.this.getNode(index - 1);
            cur = prev.next;
            cursor = index;
        }

        @Override
        public boolean hasPrevious() {
            return cursor != 0;
        }

        @Override
        public E previous() {
            moveType = MoveType.PREV;
            afterMove = true;
            prev = SLinkedList.this.getNode(cursor - 2);
            cur = prev.next;
            cursor -= 1;
            return cur.element;
        }

        @Override
        public int nextIndex() {
            return cursor;
        }

        @Override
        public int previousIndex() {
            return cursor - 1;
        }

        @Override
        public void set(E element) {
            if (afterMove) {
                prev.next.element = element;
            }
        }

        @Override
        public void add(E e) {
            if (afterMove) {
                Node<E> newNode = new Node<>(null, e);
                addAfter(prev, newNode);
            }
        }

        @Override
        public void remove() {
            super.remove();
        }
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

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
