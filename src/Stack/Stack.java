package Stack;

public interface Stack<E> {
    int gitSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
