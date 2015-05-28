package trees_graphs;

import Utility.BinaryTree;
import Utility.Tree;
import Utility.TreeNode;

public class SumOfLeftLeaves {

    private static int leftSum = 0;

    public static void main(String[] args) {
        TreeNode root = BinaryTree.getBinarySearchTree();
        Tree.displayTree(root);
        recurse(root, false);
        System.out.println(leftSum);
    }

    private static TreeNode recurse(TreeNode node, boolean isLeft) {
        if (node == null) {
            return null;
        } else {
            TreeNode left = recurse(node.getLeftChildNode(), true);
            TreeNode right = recurse(node.getRightChildNode(), false);
            if ((left == null) && (right == null) && isLeft) {
                leftSum += (Integer) node.getData();
            }
            return node;
        }
    }

}
