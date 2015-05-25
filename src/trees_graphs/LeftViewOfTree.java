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

        queue.add(root);
        int previousLevel = 1, currentLevel = 0;
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            sb.append(temp.getData());
            previousLevel--;
            if (temp.getLeftChildNode() != null) {
                queue.add(temp.getLeftChildNode());
                currentLevel++;
            }
            if (temp.getRightChildNode() != null) {
                queue.add(temp.getRightChildNode());
                currentLevel++;
            }
            if (previousLevel == 0) {
                System.out.println(sb.charAt(0));
                previousLevel = currentLevel;
                currentLevel = 0;
                sb = new StringBuilder();
            }
        }
    }
}
