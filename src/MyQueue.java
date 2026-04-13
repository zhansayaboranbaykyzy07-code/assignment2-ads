/* Implements a queue using a linked list */
public class MyQueue<T> {

    // The queue is implemented using a linked list to store the elements. The front of the queue is represented by the head of the linked list and the rear of the queue is represented by the tail of the linked list.
    private MyLinkedList<T> list;
    
    public MyQueue() {
        list = new MyLinkedList<>();
    }

    /** @return true if the queue is empty */
    public boolean empty() {
        return list.isEmpty();
    }

    /** @return the number of elements in the queue */
    public int size() {
        return list.size();
    }

    /** @return the front element of the queue without removing it */
    public T peek() {
        if (empty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.get(0);
    }

    /** @param item the element to be added to the rear of the queue */
    public void enqueue(T item) {
        list.add(item);
    }

    /** @return the front element of the queue and removes it */
    public T dequeue() {
        if (empty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.remove(0);
    }
    
    @Override
    public String toString() {
        if (empty()) {
            return "Queue is empty";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
