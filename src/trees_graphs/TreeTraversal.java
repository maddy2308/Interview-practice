package trees_graphs;

import Utility.TreeNode;

import java.util.Stack;

public class TreeTraversal {
    private TreeNode root;
    private Stack<TreeNode> stack = new Stack<TreeNode>();

    public static void main(String[] args) {
        TreeTraversal obj = new TreeTraversal();
        TreeNode root = obj.getTree();
//        obj.inorder(root);
//        System.out.println();
//        obj.preorder(root);
//        System.out.println();
//        obj.postorder(root);
        obj.inorderWithLoop(root);
        System.out.println();
        obj.preorderWithLoop(root);
    }

    private void inorder(TreeNode node) {
        if (node == null)
            return;
        else {
            inorder(node.getLeftChildNode());
            System.out.print(node.getData() + "|");
            inorder(node.getRightChildNode());
        }
    }

    private void inorderWithLoop(TreeNode node) {

        do{
            if (node != null){
                stack.push(node);
                node = node.getLeftChildNode();
            } else {
                node = stack.pop();
                System.out.print(node.getData() + "|");
                node = node.getRightChildNode();
            }
        }while (!(stack.isEmpty()) || node != null);
    }

    private void preorderWithLoop(TreeNode node) {

        do{
            if (node != null){
                System.out.print(node.getData() + "|");
                stack.push(node);
                node = node.getLeftChildNode();
            } else {
                node = stack.pop();
                node = node.getRightChildNode();
            }
        }while (!(stack.isEmpty()) || node != null);
    }

    private void preorder(TreeNode node) {
        if (node == null)
            return;
        else {
            System.out.print(node.getData() + "|");
            preorder(node.getLeftChildNode());
            preorder(node.getRightChildNode());
        }
    }

    private void postorder(TreeNode node) {
        if (node == null)
            return;
        else {
            postorder(node.getLeftChildNode());
            postorder(node.getRightChildNode());
            System.out.print(node.getData() + "|");
        }
    }

    private TreeNode getTree() {
        TreeNode nodeL = new TreeNode(null, new TreeNode(null, null, null, -1), new TreeNode(null, null, null, 8), 6);
        TreeNode nodeR = new TreeNode(null, new TreeNode(null, null, null, 15), new TreeNode(null, null, null, 23), 18);
        root = new TreeNode(null, nodeL, nodeR, 9);
        return root;
    }
}
