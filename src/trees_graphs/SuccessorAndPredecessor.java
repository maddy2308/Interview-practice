package trees_graphs;

// Find the successor and predecessor of a node (in-order) in a binary tree

import Utility.BinaryTree;
import Utility.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class SuccessorAndPredecessor {

    private Set<TreeNode> set = new HashSet<TreeNode>();

    public static void main(String[] args) {
        SuccessorAndPredecessor obj = new SuccessorAndPredecessor();
        BinaryTree.getBinaryTree();
        //obj.findSuccessor(BinaryTree.leaf1);
        obj.findPredecessor(BinaryTree.root);
    }

    void findSuccessor(TreeNode node) {
        TreeNode parent = node == null ? null : node.getParent();
        if (parent == null) {
            System.out.println("No successor possible");
        } else if (parent.getLeftChildNode() == node) {
            System.out.println(parent.getData());
        } else {
            if ((node.getRightChildNode() != null) && !set.contains(node.getRightChildNode())) {
                System.out.println(findLeftMostChild(node.getRightChildNode()).getData());
            } else {
                set.add(node);
                findSuccessor(node.getParent());
            }
        }
    }

    void findPredecessor(TreeNode node) {
        TreeNode parent = node == null ? null : node.getParent();
        if (node == null){
            System.out.println("No predecessor possible");
        } else if (parent !=null && parent.getRightChildNode() == node){
            System.out.println(parent.getData());
        }
        else {
            if (!set.contains(node.getLeftChildNode()) && node.getLeftChildNode() != null) {
                System.out.println(findRightMostChild(node.getLeftChildNode()).getData());
            } else {
                set.add(node);
                findPredecessor(node.getParent());
            }
        }
    }

    TreeNode findRightMostChild(TreeNode subTreeRoot){
        if (subTreeRoot == null)
            return null;
        else {
            TreeNode right = subTreeRoot.getRightChildNode();
            TreeNode predecessor = findLeftMostChild(right);
            return predecessor == null ? subTreeRoot : predecessor;
        }
    }

    TreeNode findLeftMostChild(TreeNode subTreeRoot) {
        if (subTreeRoot == null)
            return null;
        else {
            TreeNode left = subTreeRoot.getLeftChildNode();
            TreeNode successor = findLeftMostChild(left);
            return successor == null ? subTreeRoot : successor;
        }
    }
}
