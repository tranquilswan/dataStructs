package Tree;

import java.util.Iterator;

public abstract class AbstractTree<E extends Comparable<E>> implements Tree<E> {

    @Override
    public void inOrder(){}

    @Override
    public void postOrder() {

    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
