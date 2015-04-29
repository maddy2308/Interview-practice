package trees_graphs;

import Utility.BinaryTree;
import Utility.TreeNode;

public class ClosestValueInBST {

    private int closeValue = Integer.MAX_VALUE;
    private int findClosestFor = 36;

    public static void main(String[] args) {
        BinaryTree.getBinarySearchTree();
        ClosestValueInBST obj = new ClosestValueInBST();
        obj.searchClosestNode(BinaryTree.root);
        System.out.println(obj.closeValue);
    }

    private void searchClosestNode(TreeNode node) {
        if (node != null) {
            int previousClosestValue = Math.abs(findClosestFor - (Integer) node.getData());
            if ((Integer) node.getData() == findClosestFor) {
                int leftClosestValue = node.getLeftChildNode() != null ?
                        Math.abs((Integer) node.getLeftChildNode().getData() - (Integer) node.getData()) : Integer.MAX_VALUE;
                int rightClosestValue = node.getRightChildNode() != null ?
                        Math.abs((Integer) node.getRightChildNode().getData() - (Integer) node.getData()) : Integer.MAX_VALUE;
                closeValue = Math.min(closeValue, Math.min(leftClosestValue, rightClosestValue));
            } else {
                closeValue = (closeValue > previousClosestValue) ? previousClosestValue : closeValue;
                searchClosestNode(node.getLeftChildNode());
                searchClosestNode(node.getRightChildNode());
            }
        }
    }
}
