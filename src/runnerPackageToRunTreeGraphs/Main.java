package runnerPackageToRunTreeGraphs;

import Utility.Tree;

public class Main {

    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        Tree tree = new Tree();
        tree.createBst(array);
        tree.inOrderTraversal(tree.getRoot());

        tree.removeNode(8);
        tree.inOrderTraversal(tree.getRoot());

        tree.removeNode(11);
        tree.inOrderTraversal(tree.getRoot());

        tree.removeNode(2);
        tree.inOrderTraversal(tree.getRoot());

        tree.removeNode(5);
        tree.inOrderTraversal(tree.getRoot());

        tree.removeNode(3);
        tree.inOrderTraversal(tree.getRoot());
    }

}
