package it.matteoponzini.array.dynamic;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

@SuppressWarnings("unchecked")
public class Array<T> implements Iterable<T> {
    private int size = 0;
    private T[] array;
    private static final int INIT_CAPACITY = 16;

    public Array(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public Array() {
        this(INIT_CAPACITY);
    }

    public Array(List<T> array) {
        this.array = (T[]) new Object[array.size() + 10];
        grow((T[]) array.toArray(), array.size() + 10);
        size = array.size();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T element) {
        if (size() + 1 >= array.length) grow(array, size() + 10);
        array[size++] = element;
    }

    public T get(int index) {
        if (isValidIndex(index)) throw new IndexOutOfBoundsException();
        return array[index];
    }

    public T set(T element, int index) {
        if (isValidIndex(index)) throw new IndexOutOfBoundsException();
        T oldElement = array[index];
        array[index] = element;
        return oldElement;
    }

    public void insert(T element, int index) {
        if (isValidIndex(index)) throw new IndexOutOfBoundsException();
        if (array.length > size()) {
            for (int i = size() - 1; i >= index; i--) array[i + 1] = array[i];
            array[index] = element;
        } else {
            grow(array, array.length + 1, index, element);
        }
        size++;
    }

    public T remove(Object element) {
        int indexToRemove = indexOf(element);
        return (indexToRemove == -1) ? null : remove(indexToRemove);
    }

    public int indexOf(Object element) {
        for (int i = 0; i < size(); i++)
            if (array[i] == element || element != null && element.equals(array[i])) return i;
        return -1;
    }

    public T remove(int index) {
        if (isValidIndex(index)) throw new IndexOutOfBoundsException();
        T element = array[index];
        for (int i = 1; i <= (size() - 1) - index; i++) array[index + (i - 1)] = array[index + i];
        array[size() - 1] = null;
        size--;
        return element;
    }

    private void grow(T[] array, int newCapacity) {
        grow(array, newCapacity, null, null);
    }

    private void grow(T[] array, int newCapacity, Integer index, T element) {
        Object[] newArray = new Object[newCapacity];
        for (int i = 0; i < size(); i++) {
            if (index != null && i >= index) {
                if (i == index) newArray[i] = element;
                newArray[i + 1] = array[i];
            } else newArray[i] = array[i];
        }
        this.array = (T[]) newArray;
    }


    private boolean isValidIndex(int index) {
        return index >= size() || index < 0;
    }

    public void sorting(Consumer<Array<T>> consumer) {
        consumer.accept(this);
    }

    @Override
    public Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size();
            }

            @Override
            public T next() {
                return array[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }


    @Override
    public String toString() {
        StringBuilder arrayToString = new StringBuilder();
        arrayToString.append("{ size = ").append(size()).append(", array = [ ");
        for(int i = 0; i < size(); i++){
            arrayToString.append(this.get(i));
            if(i < size-1) arrayToString.append(",");
        }
        arrayToString.append(" ] }");
        return arrayToString.toString();
    }
}
