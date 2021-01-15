package ru.karin.nc_hw2;
import java.util.Iterator;


public class MyLinkedList<E> implements ILinkedList<E> {

    private Node<E> rootNode;
    private Node<E> lastNode;
    private int size;

    public MyLinkedList() {
        rootNode = null;
        size = 0;
    }

    @Override
    public void add(E element) {
        if (rootNode == null){
            rootNode = lastNode = new Node<>(element);
        } else {
            lastNode.setNext(new Node<>(element));
            lastNode = lastNode.getNext();
        }
        size++;
    }

    @Override
    public void add(int index, E element) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException();
        if (index == 0) {
            lastNode = rootNode = new Node<>(element, rootNode);
            size++;
        } else if (index == size) {
            add(element);
        } else {
            Node<E> currentNode = rootNode;
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(new Node(element, currentNode.getNext()));
            size++;
        }
    }

    @Override
    public void clear() {
        Node<E> current = rootNode;
        Node <E> next;
        for (int i=0; i<size; i++){
            next = current.getNext();
            current.setNext(null);
            current.setElement(null);
            current = next;
        }
        size = 0;
    }

    @Override
    public E get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        if (index == size-1)
            return lastNode.getElement();
        Node<E> currentNode = rootNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode.getElement();
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            throw new NullPointerException();
        }
        Node<E> currentNode = rootNode;
        for (int i=0; i<size; i++) {
            if (element.equals(currentNode.getElement())) {
                return i;
            }
            currentNode = currentNode.getNext();
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        if (index == 0) {
            E returnValue = rootNode.getElement();
            rootNode = rootNode.getNext();
            size--;
            return returnValue;
        } else {
            Node<E> current = rootNode;
            for (int i=0; i < index-1; i++) {
                current = current.getNext();
            }
            E returnValue = current.getNext().getElement();
            current.setNext(current.getNext().getNext());
            size--;
            return returnValue;
        }
    }

    @Override
    public E set(int index, E element) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        if (index == size-1) {
            lastNode.setElement(element);
            return lastNode.getElement();
        }
        Node<E> currentNode = rootNode;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        currentNode.setElement(element);
        return currentNode.getElement();
    }

    @Override
    public int size() {
        return size;
    }


    @SuppressWarnings("unchecked")
    public E[] toArray(E[] a) {
        if (a.length < size)
            a = (E[])java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), size);
        Node<E> currentNode = rootNode;
        for (int i=0; i<size; i++) {
            a[i] = currentNode.getElement();
            currentNode = currentNode.getNext();
        }
        if (a.length > size)
            a[size] = null;
        return a;
    }

    @Override
    public Iterator<E> iterator() {
        return new NodeIterator<>(rootNode);
    }

    @Override
    public String toString() {
        StringBuilder listString = new StringBuilder("MyLinkedList");
        if (size == 0)
            return listString.toString();
       listString.append("={" + rootNode.toString());
       Node<E> currentNode = rootNode.getNext();
       for (int i=0; i<size-1; i++) {
           listString.append(", " + currentNode.getElement().toString());
           currentNode = currentNode.getNext();
       }
       listString.append("}");
       return listString.toString();
    }
}
