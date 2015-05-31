package trees_graphs;

import Utility.BinaryTree;
import Utility.Tree;
import Utility.TreeNode;

public class IsomorphicTree {

    public static void main(String[] args) {
        // Let us create trees shown in above diagram
        TreeNode n1 = BinaryTree.getBinaryTree4();
        Tree.displayTree(n1);

        TreeNode n2 = BinaryTree.getBinaryTree5();
        Tree.displayTree(n2);

        System.out.println(isIsomorphic(n1, n2));
    }

    private static boolean isIsomorphic(TreeNode n1, TreeNode n2) {
        if ((n1 == null) && (n2 == null)) {
            return true;
        }
        if ((n1 == null || n2 == null)) {
            return false;
        }
        if (n1.getData() != n2.getData()) {
            return false;
        }
        return ((isIsomorphic(n1.getLeftChildNode(), n2.getLeftChildNode()) &&
                isIsomorphic(n1.getRightChildNode(), n2.getRightChildNode()))
                ||
                ((isIsomorphic(n1.getRightChildNode(), n2.getLeftChildNode()) &&
                        isIsomorphic(n1.getLeftChildNode(), n2.getRightChildNode()))));
    }

}
