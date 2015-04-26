package trees_graphs;

import Utility.Tree;
import Utility.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfTree {

    private static Queue<TreeNode> queue = new LinkedList<TreeNode>();

    public static void main(String[] args) {
        Tree treeExample = new Tree();
        printLeftViewOfTree(treeExample.getRoot());
    }

    public static void printLeftViewOfTree(TreeNode root) {
        queue.add(root);
        ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();
        listOfNumbers.add(1);
        int level = 0;
        while (!queue.isEmpty()) {
            System.out.print(queue.peek().getData() + " ");
            int numberOfChildrenAtLevel = 0;
            int counter = listOfNumbers.get(level);
            while (counter-- > 0) {
                root = queue.poll();
                if (root.getLeftChildNode() != null) {
                    numberOfChildrenAtLevel++;
                    queue.add(root.getLeftChildNode());
                }
                if (root.getRightChildNode() != null) {
                    numberOfChildrenAtLevel++;
                    queue.add(root.getRightChildNode());
                }
            }
            ++level;
            listOfNumbers.add(numberOfChildrenAtLevel);
        }
    }
}
