package trees_graphs;

import Utility.BinaryTree;
import Utility.TreeNode;

public class LowestCommonAncestor {

    private TreeNode root = BinaryTree.getBinarySearchTree();

    public static void main(String[] args) {
        LowestCommonAncestor obj = new LowestCommonAncestor();

        // find lowest common ancestor in Binary Search Tree
        TreeNode ancestor = obj.findLowestCommonAncestorInBST(obj.root, 35, 18);
        if (ancestor == null) System.out.println("No such children");
        else System.out.println(ancestor.getData());

        // find lowest common ancestor in Binary Tree
        obj.root = BinaryTree.getBinaryTree();
        ancestor = obj.findLowestCommonAncestorInBT(obj.root, 1, 12);
        if (ancestor == null) System.out.println("No such children");
        else System.out.println(ancestor.getData());
    }

    public TreeNode findLowestCommonAncestorInBST(TreeNode node, Integer n1, Integer n2) {
        if (node == null) return null;
        if (isInBetween(node, n1, n2) || isInBetween(node, n2, n1)){
            return node;
        } else {
            TreeNode temp = findLowestCommonAncestorInBST(node.getLeftChildNode(), n1, n2);
            if (temp == null) {
                return findLowestCommonAncestorInBST(node.getRightChildNode(), n1, n2);
            } else {
                return temp;
            }
        }
    }

    public TreeNode findLowestCommonAncestorInBT(TreeNode node, int n1, int n2){
        if (node == null) return null;
        if ((Integer) node.getData() == n1 || (Integer) node.getData() == n2){
            return node;
        }
        TreeNode leftLCA = findLowestCommonAncestorInBT(node.getLeftChildNode(), n1, n2);
        TreeNode rightLCA = findLowestCommonAncestorInBT(node.getRightChildNode(), n1, n2);

        if (leftLCA != null && rightLCA != null) return node;
        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    private boolean isInBetween(TreeNode node, Integer n1, Integer n2) {
        return ((Integer)node.getData() >= n1 && (Integer)node.getData() <= n2);
    }
}
