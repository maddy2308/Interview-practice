package trees_graphs;

import Utility.Tree;
import Utility.TreeNode;

public class Problem1_isBalancedBinaryTree {

    public static void main(String[] args) {
        Tree treeExample = new Tree();
        if ((isBalanced(treeExample.getRoot()) < 0))
            System.out.println(false);
        else
            System.out.println(true);
    }

    public static int isBalanced(TreeNode currentRoot) {
        if (currentRoot == null) {
            return 0;
        } else {
            int value = isBalanced(currentRoot.getLeftChildNode());
            if (value < 0) {
                return value;
            }
            int leftHeight = value + 1;
            value = isBalanced(currentRoot.getRightChildNode());
            if (value < 0) {
                return value;
            }
            int rightHeight = value + 1;
            if ((Math.abs(leftHeight - rightHeight)) > 1) {
                return -1;
            } else {
                return (leftHeight > rightHeight) ? leftHeight : rightHeight;
            }
        }
    }
}
