package list;

public class Node<E> {
    E element;
    Node<E> next;

    Node(Node<E> next, E element) {
        this.element = element;
        this.next = next;
    }

    void update(Node<E> next, E element) {
        this.element = element;
        this.next = next;
    }
}
