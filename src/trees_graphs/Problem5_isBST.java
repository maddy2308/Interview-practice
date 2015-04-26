package trees_graphs;

import Utility.BinaryTree;
import Utility.TreeNode;

public class Problem5_isBST {

    public static void main(String[] args){
        Problem5_isBST obj = new Problem5_isBST();
        int MIN = Integer.MIN_VALUE;
        int MAX = Integer.MAX_VALUE;
        System.out.println(obj.isBST(BinaryTree.getBinarySearchTree(), MIN, MAX));
    }

    private boolean isBST(TreeNode node, int min, int max){
        if (node == null){
            return true;
        }
        int data = ((Integer)node.getData());
        if (data >= min && data <= max){
            boolean isLeftSubTreeBST = isBST(node.getLeftChildNode(), min, data);
            boolean isRightSubTreeBST = isBST(node.getRightChildNode(), data, max);
            return isLeftSubTreeBST && isRightSubTreeBST;
        }
        return false;
    }
}
