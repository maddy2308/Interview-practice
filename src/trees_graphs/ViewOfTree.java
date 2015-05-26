package trees_graphs;

import Utility.BinaryTree;
import Utility.Tree;
import Utility.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class ViewOfTree {

    private static Queue<TreeNode> queue = new LinkedList<TreeNode>();

    public static void main(String[] args) {
        TreeNode root = BinaryTree.getBinaryTree();
        Tree.displayTree(root);
        printLevelOrderTraversal(root);
        printLeftViewOfTree(root);
        printRightViewOfTree(root);
    }

    public static void printLevelOrderTraversal(TreeNode root) {
        System.out.println(levelOrderTraversal(root));
    }

    public static void printLeftViewOfTree(TreeNode root) {
        String str = levelOrderTraversal(root);
        String[] split = str.split("\n");
        for (String s : split) {
            String[] level = s.split(" ");
            System.out.print(level[0] + " ");
        }
    }

    public static void printRightViewOfTree(TreeNode root) {
        System.out.println();
        String str = levelOrderTraversal(root);
        String[] split = str.split("\n");
        for (String s : split) {
            String[] level = s.split(" ");
            System.out.print(level[level.length - 1] + " ");
        }
    }

    private static String levelOrderTraversal(TreeNode root) {
        queue.add(root);
        int previousLevel = 1, currentLevel = 0;
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            sb.append(temp.getData()).append(" ");
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
                previousLevel = currentLevel;
                currentLevel = 0;
                sb.append('\n');
            }
        }
        return sb.toString();
    }
}
