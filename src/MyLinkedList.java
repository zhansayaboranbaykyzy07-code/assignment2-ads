public class MyLinkedList<T> implements MyList<T> {
        
    private class MyNode {
        
        /* Inner class for the nodes in the linked list */
        T o;
        MyNode next;
        MyNode prev;

        MyNode(T element) {
            this.o = element;
            this.next = null;
            this.prev = null;
        }

        MyNode(T element, MyNode next, MyNode prev) {
            this.o = element;
            this.next = next;
            this.prev = prev;
        }
    }

    /* Private fields for the linked list */
    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /* Checks if the given index is valid */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /* Checks if the given index is valid for adding an element */
    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /* Retrieves the node at a specific index */
    private MyNode getNode(int index) {
        checkIndex(index);
        MyNode current;
        if (index < size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    /* Adds an element to the end of the list */
    @Override
    public void add(T item) {
        MyNode newNode = new MyNode(item);
            if (tail == null) {
                head = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
            }
        tail = newNode;
        size++;
    }

    /* Adds an element at a specific index */
    @Override
    public void add(int index, T item) {
        checkIndexForAdd(index);
        if (index == size) {
            add(item);
            return;
        }
        if (index == 0) {
            MyNode newNode = new MyNode(item);
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            } 
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        } else {
            MyNode current = getNode(index);
            MyNode newNode = new MyNode(item);
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
        }
        size++;
    }

    /* Retrieves an element at a specific index */
    @Override
    public T get(int index) {
        return getNode(index).o;
    }

    /* Removes an element at a specific index and returns it */
    @Override
    public T remove(int index) {
        checkIndex(index);
        MyNode nodeToRemove = getNode(index);
        T element = nodeToRemove.o;
        if (nodeToRemove.prev == null) {
            head = nodeToRemove.next;
            if (head != null) {
                head.prev = null;
            }
        } else {
            nodeToRemove.prev.next = nodeToRemove.next;
        }
        if (nodeToRemove.next == null) {
            tail = nodeToRemove.prev;
        } else {
            nodeToRemove.next.prev = nodeToRemove.prev;
        }

        nodeToRemove.next = null;
        nodeToRemove.prev = null;
        nodeToRemove.o = null;
        size--;
        return element;
    }

    /* Returns the number of elements in the list */
    @Override
    public int size() {
        return size;
    }

    /* Clears the list */
    @Override
    public void clear() {
        MyNode current = head;
        while (current != null) {
            MyNode next = current.next;
            current.o = null; 
            current.next = null; 
            current.prev = null; 
            current = next;
        }
        head = null;
        tail = null;
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
        MyNode current = head;
        int index = 0;
        if (item == null) {
            while (current != null) {
                if (current.o == null) {
                    return index;
                }
                current = current.next;
                index++;
            }
        } else {
            while (current != null) {
                if (item.equals(current.o)) {
                    return index;
                }
                current = current.next;
                index++;
            }
        }
        return -1;
    }

    /* Returns the index of the last occurrence of a specific element */
    @Override
    public int lastIndexOf(T item) {
        MyNode current = tail;
        int index = size - 1;
        if (item == null) {
            while (current != null) {
                if (current.o == null) {
                    return index;
                }
                current = current.prev;
                index--;
            }
        } else {
            while (current != null) {
                if (item.equals(current.o)) {
                    return index;
                }
                current = current.prev;
                index--;
            }
        }
        return -1;
    }

    /* Replaces the element at the specified index with the specified element and returns the old element */
    @Override
    public T set(int index, T item) {
        checkIndex(index);
        MyNode node = getNode(index);
        T oldElement = node.o;
        node.o = item;
        return oldElement;
    }

    /* Returns an array containing all of the elements in this list in proper sequence (from first to last element) */
    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        MyNode current = head;
        for (int i = 0; i < size; i++) {
            array[i] = current.o;
            current = current.next;
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
        MyNode current = head;
        while (current.next != null) {
            sb.append(current.o).append(", ");
            current = current.next; 
        }
        sb.append(current.o).append("]");
        return sb.toString();
    }
}