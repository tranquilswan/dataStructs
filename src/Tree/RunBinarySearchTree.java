package Tree;

public class RunBinarySearchTree {

    public static void main(String[] args){
        String[] names = new String[]{"Mike","Rob", "Fred", "Tom", "Jerry", "Walter"};

        BinarySearchTree<String> tree = new BinarySearchTree<String>(names);
        tree.insert("Gsp");
        tree.insert("Kimbo");

        System.out.println("\nIs jerry in the tree? " + tree.search("Jerry"));

        System.out.println("\nInorder (sorted): ");
        tree.inOrder();
        System.out.println("\nPostorder (sorted): ");
        tree.postOrder();
        System.out.println("\nPreorder (sorted): ");
        tree.preOrder();
        System.out.println("\nThe number of nodes is: " + tree.getSize());

         System.out.println("\nPath from root to Jerry is: " );
        java.util.ArrayList<BinarySearchTree.TreeNode<String>> path = tree.path("Jerry");

        for(int i = 0;path!=null && i < path.size(); i++){
            System.out.println(path.get(i).element + " ");
        }

        Integer[] nums = {2,4,23,6756,23,65,123565,8};
        BinarySearchTree<Integer> intTree = new BinarySearchTree<Integer>(nums);
        System.out.println("\nInorder (sorted): ");
        intTree.inOrder();

    }
}