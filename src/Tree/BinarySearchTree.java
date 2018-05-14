package Tree;

import java.util.Iterator;

public class BinarySearchTree<E extends Comparable<E>> extends AbstractTree<E> {

    protected TreeNode<E> root;
    protected int size = 0;

    public BinarySearchTree(){}

    public BinarySearchTree(E[] objects){
        for (int i = 0; i < objects.length; i++){
            insert(objects[i]);
        }
    }

    @Override
    public boolean search(E e) {
        TreeNode<E> current = root;

        while (current != null){
            if(e.compareTo(current.element)<0){
                current = current.left;
            }else if(e.compareTo(current.element) > 0){
                current = current.right;
            }else{
                return true;
            }
        }
        return false;
    }

    public boolean insert(E e){
        if (root == null){
            root = createNewNode(e);
        }else{
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null){
                if(e.compareTo(current.element)<0){
                    parent = current;
                    current = current.left;
                }else if(e.compareTo(current.element)>0){
                    parent = current;
                    current = current.right;
                }
                else{
                    return false;
                }
            }
            if (e.compareTo(parent.element)<0){
                parent.left = createNewNode(e);
            }else{
                parent.right = createNewNode(e);
            }
        }

        size++;
        return true;

    }

    protected TreeNode<E> createNewNode(E e){
        return new TreeNode<E>(e);
    }

    protected void inOrder(TreeNode<E> root){
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.element + " ");
        inOrder(root.right);
    }

    @Override
    public void inOrder() {
        inOrder(root);
    }

    @Override
    public void postOrder() {
        postOrder(root);
    }

    public void postOrder(TreeNode<E> root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.element + " ");
    }

    protected void preOrder(TreeNode<E> root){
        if(root == null) return;
        System.out.println(root.element + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    @Override
    public void preOrder() {
        preOrder(root);
    }

    public static class TreeNode<E extends Comparable<E>> {
        protected E element;
        protected TreeNode<E> left;
        protected TreeNode<E> right;

        public TreeNode(E e){
            this.element = e;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    public TreeNode<E> getRoot(){
        return root;
    }

    public java.util.ArrayList<TreeNode<E>> path(E e){
        java.util.ArrayList<TreeNode<E>> list = new java.util.ArrayList<TreeNode<E>>();
        TreeNode<E> current = root;

        while (current != null){
            list.add(current);
            if(e.compareTo(current.element)<0){
                current = current.right;
            }
            else if(e.compareTo(current.element)>0){
                current = current.right;
            }
            else {
                break;
            }
        }
        return list;
    }

    @Override
    public boolean delete(E e) {
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null){
            if(e.compareTo(current.element)<0){
                parent = current;
                current = current.left;
            }
            else if(e.compareTo(current.element) > 0){
                parent = current;
                current = current.right;
            }
            else{
                break;
            }
        }
        if(current == null){
            return false;
        }
        if(current.left == null){
            if(parent == null){
                root = current.right;
            }
            else {
                if (e.compareTo(parent.element) < 0){
                    parent.left = current.right;
                }else {
                    parent.right = current.right;
                }
            }
        }else{
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;

            while (rightMost.right != null){
                parentOfRightMost = rightMost;
                rightMost = rightMost.right;
            }

            current.element = rightMost.element;

            if(parentOfRightMost.right == rightMost){
                parentOfRightMost.right = rightMost.left;
            }else{
                parentOfRightMost.left = rightMost.left;
            }
        }

        size--;
        return true;
    }

    @Override
    public java.util.Iterator<E> iterator() {
        return new InorderIterator();
    }

    private class InorderIterator implements java.util.Iterator<E> {

        private java.util.ArrayList<E> list = new java.util.ArrayList<E>();

        private int current = 0;

        public InorderIterator(){
            inOrder();
        }

        private void inOrder(){
            inOrder(root);
        }

        private void inOrder(TreeNode<E> root){
            if(root == null){
                return;
            }
            inOrder(root.left);
            list.add(root.element);
            inOrder(root.right);
        }

        @Override
        public boolean hasNext() {
            if(current < list.size()){
                return true;
            }
            return false;
        }

        @Override
        public E next() {
            return list.get(current++);
        }

        @Override
        public void remove() {
            delete(list.get(current));
            list.clear();
            inOrder();
        }

    }

    public void clear(){
        root = null;
        size = 0;
    }
}
