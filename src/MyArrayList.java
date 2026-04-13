/* Implements a dynamic array-based list */
public class MyArrayList<T> implements MyList<T> {

    // Private instance variables
    private Object[] o;
    private int size;

    // Default initial capacity
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        this.o = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /* Ensures the array has enough capacity */
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > o.length) {
            int newCapacity = o.length * 2;
            Object[] newElements = new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newElements[i] = o[i];
            }
            o = newElements;
        }
    }

    /* Checks if the index is valid for accessing elements */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /* Checks if the index is valid for adding elements */
    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /* Adds an element to the end of the list */
    @Override
    public void add(T item) {
        ensureCapacity(size + 1);
        o[size++] = item;
    }

    /* Adds an element at a specific index */
    @Override
    public void add(int index, T item) {
        checkIndexForAdd(index);
        ensureCapacity(size + 1);
        for (int i = size; i > index; i--) {
            o[i] = o[i - 1];
        }
        o[index] = item;
        size++;
    }

    /* Retrieves an element at a specific index */
    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) o[index];
    }

    /* Removes an element at a specific index and returns it */
    @Override
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        checkIndex(index);
        T removedElement = (T) o[index];
        for (int i = index; i < size - 1; i++) {
            o[i] = o[i + 1];
        }
        o[--size] = null;
        return removedElement;
    }

    /* Returns the number of elements in the list */
    @Override
    public int size() {
        return size;
    }

    /* Clears the list */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            o[i] = null;
        }
        size = 0;
    }

    /* Checks if the list contains a specific element */
    @Override
    public boolean contains(T item) {
        return indexOf(item) != -1;
    }

    /* Checks if the list is empty */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /* Returns the index of the first occurrence of a specific element */
    @Override
    public int indexOf(T item) {
        if (item == null) {
            for (int i = 0; i < size; i++) {
                if (o[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (item.equals(o[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /* Returns the index of the last occurrence of a specific element */
    @Override
    public int lastIndexOf(T item) {
        if (item == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (o[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (item.equals(o[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /* Replaces the element at the specified index with the specified element and returns the old element */
    @Override
    @SuppressWarnings("unchecked")
    public T set(int index, T item) {
        checkIndex(index);
        T oldElement = (T) o[index];
        o[index] = item;
        return oldElement;
    }

    /* Returns an array containing all of the elements in this list in proper sequence (from first to last element) */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = o[i];
        }
        return array;
    }

    /* Returns a string representation of the list */
    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(o[i]).append(", ");
            }
        sb.append(o[size - 1]).append("]");
        return sb.toString();
    }
}