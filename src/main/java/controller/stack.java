package controller;

public interface stack <E> {
        void push(E e);
        E pop();
        E top();
        int size();
        boolean isEmpty();
}
