package trees_graphs;

import Utility.BinaryTree;
import Utility.Tree;
import Utility.TreeNode;

public class BoundaryOfTree {

    public static void main(String[] args) {
        TreeNode root = BinaryTree.getBinarySearchTree();
        Tree.displayTree(root);
        printLeftBoundary(root);
        printLeaves(root);
        printRightBoundary(root);
    }

    private static void printLeftBoundary(TreeNode root) {
        if (root != null) {
            if (root.getRightChildNode() != null || root.getLeftChildNode() != null) {
                System.out.print(root.getData() + " ");
            }
            printLeftBoundary(root.getLeftChildNode());
        }
    }

    private static void printLeaves(TreeNode root) {
        if (root != null) {
            if (root.getRightChildNode() == null && root.getLeftChildNode() == null) {
                System.out.print(root.getData() + " ");
            } else {
                printLeaves(root.getLeftChildNode());
                printLeaves(root.getRightChildNode());
            }
        }
    }

    private static void printRightBoundary(TreeNode root) {
        if (root != null) {
            printRightBoundary(root.getRightChildNode());
            if (root.getRightChildNode() != null || root.getLeftChildNode() != null) {
                System.out.print(root.getData() + " ");
            }
        }
    }
}
