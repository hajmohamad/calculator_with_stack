package model;

import controller.stack;

public class LinkedListStack<E> implements stack<E> {

    SinglyLinkedList<E> list = new SinglyLinkedList<>();


    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E top() {
        return list.first();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
    public LinkedListStack<E> copy(E sd) {
        LinkedListStack<E> tempStack = new LinkedListStack<E>();
        LinkedListStack<E> currentStack = new LinkedListStack<E>();
        while (!this.isEmpty()){
            currentStack.push(this.pop());
        }
        while (!currentStack.isEmpty()){
            E node = currentStack.pop();
            this.push(node);
            tempStack.push(node);
        }
        tempStack.push( sd);

        return tempStack;

    }

    public static boolean isMatched(String expression) {
        final String opening = "({[";
        final String closing = ")}]";
        stack<Character> buffer = new LinkedListStack<>();
        for (char c : expression.toCharArray()) {
            if (opening.indexOf(c) != -1) {
                buffer.push(c);
            } else if (closing.indexOf(c) != -1) {
                if (buffer.isEmpty()) return false;
                if (closing.indexOf(c) != opening.indexOf(buffer.pop())) return false;
            }
        }
        return buffer.isEmpty();
    }
    public static class SinglyLinkedList<T> {

        private Node head;
        private Node tail;
        private int size;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        /* ------------------------ LinkedList Methods ------------------------ */

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public T first() {
            if (isEmpty()) throw new IllegalStateException("LinkedList is empty");
            return this.head.getValue();
        }

        public T last() {
            if (isEmpty()) throw new IllegalStateException("LinkedList is empty");
            return this.tail.getValue();
        }

        public void addFirst(T value) {
            head = new Node(value, head);
            if (isEmpty()) tail = head;
            size++;
        }

        public void addLast(T value) {
            Node newNode = new Node(value, null);
            if (isEmpty()) head = newNode;
            else tail.setNext(newNode);
            tail = newNode;
            size++;
        }

        public T removeFirst() {
            if (isEmpty()) throw new IllegalStateException("LinkedList is empty");
            T first = head.getValue();
            head = head.getNext();
            size--;
            return first;
        }

        public void traverse() {
            Node node = head;
            while (node != null) {
                System.out.println(node.getValue());
                node = node.getNext();
            }
        }


        public Node getHead() {
            return head;
        }

        public void setHead(Node head) {
            this.head = head;
        }

        public Node getTail() {
            return tail;
        }

        public void setTail(Node tail) {
            this.tail = tail;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        /* ------------------------ Node Class ------------------------ */

        private class Node {
            private final T value;
            private Node next;

            public Node(T v, Node n) {
                value = v;
                next = n;
            }

            public T getValue() {
                return value;
            }

            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }
        }
    }
}
