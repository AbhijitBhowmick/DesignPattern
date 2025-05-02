package org.example.behaviouraldp.iterator;

public interface Aggregate<T> {
    Iterator<T> createIterator();
}

