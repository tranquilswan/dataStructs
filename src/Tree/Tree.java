package Tree;

public interface Tree<E extends Comparable<E>> extends Iterable<E>{
    public boolean search(E e);

    public boolean insert(E e);

    public boolean delete(E e);

    public void inOrder();

    public void postOrder();

    public void preOrder();

    public int getSize();

    public boolean isEmpty();

    public java.util.Iterator<E> iterator();
}
