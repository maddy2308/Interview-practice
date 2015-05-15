package trees_graphs;

import Utility.BinaryTree;
import Utility.Tree;
import Utility.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfTree {

    private static Queue<TreeNode> queue = new LinkedList<TreeNode>();

    public static void main(String[] args) {
        Tree.displayTree(BinaryTree.getBinaryTree());
        printLeftViewOfTree(BinaryTree.getBinaryTree());
    }

    public static void printLeftViewOfTree(TreeNode root) {

    }
}
