package ru.karin.nc_hw2;

public class Node<E> {

    private E element;
    private Node<E> nextNode;

    public Node() {
    }

    public Node(E element) {
        this.element = element;
        nextNode = null;
    }

    public Node(E element, Node<E> nextNode) {
        this.element = element;
        this.nextNode = nextNode;
    }

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public Node<E> getNext() {
        return nextNode;
    }

    public void setNext(Node<E> nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}
