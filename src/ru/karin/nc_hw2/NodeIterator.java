package ru.karin.nc_hw2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NodeIterator<E> implements Iterator<E> {
    private Node<E> currentNode;
    private Node<E> previous;

    public NodeIterator(Node<E> currentNode) {
        this.currentNode = currentNode;
        this.previous = null;
    }

    @Override
    public boolean hasNext() {
        return currentNode != null;
    }

    @Override
    public E next() {
        if (currentNode == null)
            throw new NoSuchElementException();
        E returned = currentNode.getElement();
        previous = currentNode;
        currentNode = currentNode.getNext();
        return returned;
    }

    @Override
    public void remove() {
        if (currentNode == null)
            throw new NoSuchElementException();
        if (previous != null)
            previous.setNext(currentNode.getNext());
    }
}
