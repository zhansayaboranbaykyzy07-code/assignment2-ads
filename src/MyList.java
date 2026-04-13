/* MyList interface */

public interface MyList<T> {
    void add(T o);
    void add(int index, T o);
    T get(int index);
    T remove(int index);
    int size();
    void clear();
    boolean contains(T o);
    boolean isEmpty();
    int indexOf(T o);
    int lastIndexOf(T o);
    T set(int index, T o);
    Object[] toArray();
}