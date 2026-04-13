/* Implements a stack using an array list */
public class MyStack<T> {

    // The stack is implemented using an array list to store the elements. The top of the stack is represented by the last element in the list.
    private MyArrayList<T> list;

    public MyStack() {
        list = new MyArrayList<>();
    }

    /** @return true if the stack is empty */
    public boolean empty() {
        return list.isEmpty();
    }

    /** @return the number of elements in the stack */
    public int size() {
        return list.size();
    }

    /** @return the top element of the stack without removing it */
    public T peek() {
        if (empty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.get(size() - 1);
    }

    /** @return the top element of the stack and removes it */
    public T pop() {
        if (empty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return list.remove(size() - 1);
    }

    /** @param item the element to be pushed onto the stack */
    public void push(T item) {
        list.add(item);
    }

    @Override
    public String toString() {
        if (empty()) {
            return "Stack is empty";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i));
            if (i > 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}