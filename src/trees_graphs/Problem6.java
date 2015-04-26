package trees_graphs;

import Utility.BinaryTree;
import Utility.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class Problem6 {

    private static Set<TreeNode> set = new HashSet<TreeNode>();

    public static void main(String[] args) {
        BinaryTree t = new BinaryTree();
        System.out.println(getSuccessor(BinaryTree.root.getRightChildNode().getRightChildNode().getRightChildNode()).getData());
    }

    public static TreeNode getSuccessor(TreeNode node) {
        if (!set.contains(node)) {
            set.add(node);
            if (node == null)
                return null;
            else {
                if (node.getRightChildNode() != null && !set.contains(node.getRightChildNode())) {
                    return findLeftMostChild(node.getRightChildNode());
                } else {
                    if (isLeftChild(node)) {
                        System.out.println(true);
                        return node.getParent();
                    } else {
                        return getSuccessor(node.getParent());
                    }
                }
            }
        }
        return null;
    }

    private static TreeNode findLeftMostChild(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode returnNode = findLeftMostChild(node.getLeftChildNode());
        return (returnNode == null) ? node : returnNode;
    }

    private static boolean isLeftChild(TreeNode node) {
        return node != null && node == node.getParent().getLeftChildNode();
    }
}



















