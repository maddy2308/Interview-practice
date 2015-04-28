package trees_graphs;

import Utility.TreeNode;

public class BinaryTreeMaxPathSum {
    private int max = Integer.MIN_VALUE;
    private TreeNode root;
    public BinaryTreeMaxPathSum() {
        TreeNode nodeL = new TreeNode(null, new TreeNode(null, null, null, 4), new TreeNode(null, null, null, 5), -2);
        TreeNode nodeR = new TreeNode(null, new TreeNode(null, null, null, -7), new TreeNode(null, null, null, -8), -3);
        root = new TreeNode(null, nodeL, nodeR, 7);
    }

    public static void main(String[] args) {
        BinaryTreeMaxPathSum obj = new BinaryTreeMaxPathSum();
        obj.findMax(obj.root);
        System.out.println(obj.max);
    }

    private int findMax(TreeNode node) {
        if (node == null) return 0;
        int left = findMax(node.getLeftChildNode());
        int right = findMax(node.getRightChildNode());

        int current = Math.max((Integer) node.getData(), Math.max((Integer) node.getData() + left, (Integer) node.getData() + right));
        max = Math.max(max, Math.max(current, left + (Integer)node.getData() + right));
        return current;
    }
}
