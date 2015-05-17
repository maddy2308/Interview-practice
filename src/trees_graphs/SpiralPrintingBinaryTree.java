package trees_graphs;

import Utility.BinaryTree;
import Utility.Tree;
import Utility.TreeNode;

import java.util.Stack;

public class SpiralPrintingBinaryTree {

    public static void main(String[] args) {
        new SpiralPrintingBinaryTree().spiralPrint(BinaryTree.getBinaryTree());
    }

    private void spiralPrint(TreeNode root) {
        Tree.displayTree(BinaryTree.getBinaryTree());
        Stack<TreeNode> oddLevelStack = new Stack<TreeNode>();
        Stack<TreeNode> evenLevelStack = new Stack<TreeNode>();
        evenLevelStack.push(root);
        System.out.println(root.getData());
        boolean flag = true;
        while (flag) {
            flag = alternateStack(oddLevelStack, evenLevelStack);
        }
    }

    private boolean alternateStack(Stack<TreeNode> oddLevelStack, Stack<TreeNode> evenLevelStack) {

        if (!oddLevelStack.isEmpty()) {
            while (!oddLevelStack.isEmpty()) {
                TreeNode poppedNode = oddLevelStack.pop();
                addChild(evenLevelStack, poppedNode.getLeftChildNode());
                addChild(evenLevelStack, poppedNode.getRightChildNode());
            }
        } else {
            while (!evenLevelStack.isEmpty()) {
                TreeNode poppedNode = evenLevelStack.pop();
                addChild(oddLevelStack, poppedNode.getRightChildNode());
                addChild(oddLevelStack, poppedNode.getLeftChildNode());
            }
        }
        System.out.println();
        return !(oddLevelStack.isEmpty() && evenLevelStack.isEmpty());
    }

    private void addChild(Stack<TreeNode> stack, TreeNode node) {
        if (node != null) {
            System.out.print(node.getData() + " ");
            stack.add(node);
        }

    }
}
