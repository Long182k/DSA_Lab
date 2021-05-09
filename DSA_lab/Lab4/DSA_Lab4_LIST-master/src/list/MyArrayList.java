package list;

import java.util.*;

public class MyArrayList<E> implements List<E> {
    private enum MoveType {NEXT, PREV}

    private static final int MAX_CAPACITY = Integer.MAX_VALUE - 8;

    //    Internal data fields
    private E[] elements;
    private int size;

    //    Constructors
    public MyArrayList(int capacity) throws IllegalArgumentException {
        if ((capacity < 0) || (capacity > MAX_CAPACITY)) {
            String message = String.format("Invalid capacity (=%d)", capacity);
            throw new IllegalArgumentException(message);
        }
        this.elements = (E[]) new Object[capacity];
        this.size = 0;
    }

    public MyArrayList() throws IllegalArgumentException {
        this(10);
    }

    public MyArrayList(Collection<? extends E> c) {
        E[] a = (E[]) c.toArray();
        if ((size = a.length) != 0) {
            if (c.getClass() == ArrayList.class) {
                elements = a;
            } else {
                elements = (E[]) Arrays.copyOf(a, size, Object[].class);
            }
        } else {
            elements = (E[]) new Object[10];
        }
    }

    //    Utilities
    private void checkValidIndex(int index, int min, int max) {
        if ((index < min) || (index > max)) {
            String message = String.format("Invalid index (=%d)", index);
            throw new IndexOutOfBoundsException(message);
        }
    }

    private void checkCapacity(int minCapacity) {
        if ((minCapacity < 0) || (minCapacity > MAX_CAPACITY))
            throw new OutOfMemoryError("Not enough memory to store the array");
        if (minCapacity < this.elements.length) return;
        else {
            //grow
            int oldCapacity = this.elements.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity < 0)
                newCapacity = MAX_CAPACITY;
            this.elements = Arrays.copyOf(this.elements, newCapacity);
        }
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
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public void add(int index, E element) {
        checkValidIndex(index, 0, size);
        if (element == null) {
            throw new NullPointerException("Can not add null pointer");
        }
        checkCapacity(this.size + 1);

        int copyCount = (this.size - 1) - index + 1;
        System.arraycopy(this.elements, index, this.elements, index + 1, copyCount);
        this.elements[index] = element;
        this.size++;
    }

    @Override
    public boolean add(E element) {
        if (element == null) {
            throw new NullPointerException("Can not add null pointer");
        }
        checkCapacity(this.size + 1);

        this.elements[this.size++] = element;
        return true;
    }

    @Override
    public E remove(int index) {
        checkValidIndex(index, 0, size - 1);
        E oldElement = this.elements[index];
        int copyCount = (this.size - 1) - (index + 1) + 1;
        System.arraycopy(this.elements, index + 1, this.elements, index, copyCount);
        this.size--;
        return oldElement;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index < 0) return false;
        remove(index);
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public E get(int index) {
        checkValidIndex(index, 0, size - 1);
        return this.elements[index];
    }

    @Override
    public E set(int index, E element) {
        checkValidIndex(index, 0, size - 1);
        E oldElement = this.elements[index];
        this.elements[index] = element;
        return oldElement;
    }

    @Override
    public int indexOf(Object o) {
        int foundIndex = -1;
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                foundIndex = i;
                break;
            }
        }
        return foundIndex;
    }

    @Override
    public int lastIndexOf(Object o) {
        int foundIndex = -1;
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(o)) {
                foundIndex = i;
                break;
            }
        }
        return foundIndex;
    }

    @Override
    public String toString() {
        if (size != 0) {
            StringBuilder string = new StringBuilder();
            string.append("[");
            for (int i = 0; i < size; i++) {
                string.append(elements[i]);
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

    public class MyIterator implements Iterator<E> {
        int cursor = 0;
        MoveType moveType = MoveType.NEXT;
        boolean afterMove = false;

        @Override
        public boolean hasNext() {
            return this.cursor != MyArrayList.this.size;
        }

        @Override
        public E next() {
            cursor += 1;
            moveType = MoveType.NEXT;
            afterMove = true;
            return MyArrayList.this.elements[cursor - 1];
        }

        @Override
        public void remove() {
            if (afterMove) {
                MyArrayList.this.remove(cursor - 1);
                cursor -= 1;
                afterMove = false;
            }
        }
    }

    @Override
    public ListIterator<E> listIterator() {
        return new MyListIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new MyListIterator(index);
    }

    public class MyListIterator extends MyIterator implements ListIterator<E> {
        public MyListIterator() {
        }

        public MyListIterator(int index) {
            cursor = index;
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
        public boolean hasPrevious() {
            return cursor != 0;
        }

        @Override
        public E previous() {
            cursor -= 1;
            moveType = MoveType.PREV;
            afterMove = true;
            return MyArrayList.this.elements[cursor];
        }

        @Override
        public void set(E element) {
            if (afterMove) {
                if (moveType == MoveType.NEXT) {
                    MyArrayList.this.set(cursor - 1, element);
                } else {
                    MyArrayList.this.set(cursor, element);
                }
            }
        }

        @Override
        public void add(E element) {
            if (afterMove) {
                if (moveType == MoveType.NEXT) {
                    MyArrayList.this.add(cursor - 1, element);
                } else {
                    MyArrayList.this.add(cursor, element);
                }
            }
        }

        @Override
        public void remove() {
            if (afterMove) {
                if (moveType == MoveType.NEXT) {
                    super.remove();
                } else {
                    MyArrayList.this.remove(cursor);
                }
            }
        }
    }

    @Override
    public boolean addAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean addAll(int index, Collection c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean containsAll(Collection c) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Object[] toArray(Object[] a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
