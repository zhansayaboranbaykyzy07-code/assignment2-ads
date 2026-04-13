/* Implements a min heap using an array list */
public class MyMinHeap<T extends Comparable<T>> {

    /* The min heap is implemented using an array, where the parent-child relationships are maintained according to the properties of a binary heap. */
    private MyArrayList<T> heap;
    
    public MyMinHeap() {
        heap = new MyArrayList<>();
        heap.add(null); // Add a dummy element at index 0 to simplify index calculations
    }

    /** @return true if the min heap is empty */
    public boolean empty() {
        return heap.size() == 1; // Only the dummy element is present
    }

    /** @return the number of elements in the min heap */
    public int size() {
        return heap.size() - 1; // Exclude the dummy element
    }

    /** @return the minimum element in the min heap without removing it */
    public T getMin() {
        if (empty()) {
            throw new IllegalStateException("Min heap is empty");
        }
        return heap.get(1); // The minimum element is at index 1
    }

    /** @param item the element to be inserted into the min heap */
    public void insert(T item) {
        heap.add(item);
        traverseUp(size());
    }

    /** @return the minimum element in the min heap and removes it */
    public T removeMin() {
        if (empty()) {
            throw new IllegalStateException("Min heap is empty");
        }
        T min = getMin();
        T lastElement = heap.remove(heap.size()-1);
        if (size() > 0) {
            heap.set(1, lastElement);
            heapify(1);
        }
        return min;
    }

    /// Private helper methods
    
    /** Fixes the heap property by moving an element up */
    private void traverseUp(int index) {
        while (index > 1) {
            int parent = parentOf(index);
            if (heap.get(index).compareTo(heap.get(parent)) < 0) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    /** Fixes the heap property by moving an element down */
    private void heapify(int index) {
        int smallest = index;
        int left = leftChildOf(index);
        int right = rightChildOf(index);

        if (left <= size() && heap.get(left).compareTo(heap.get(smallest)) < 0) {
            smallest = left;
        }
        if (right <= size() && heap.get(right).compareTo(heap.get(smallest)) < 0) {
            smallest = right;
        }
        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }
    }

    /** Returns the index of the parent of the element at the specified index */
    private int parentOf(int index) {
        return index / 2;
    }

    /** Returns the index of the left child of the element at the specified index */
    private int leftChildOf(int index) {
        return index * 2;
    }

    /** Returns the index of the right child of the element at the specified index */
    private int rightChildOf(int index) {
        return index * 2 + 1;
    }

    /** Swaps the elements at the specified indices */
    private void swap(int index1, int index2) {
        T temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    @Override
    public String toString() {
        if (empty()) {
            return "Min heap is empty";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("["); 
        for (int i = 1; i < heap.size(); i++) {
            sb.append(heap.get(i));
            if (i < size()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
