package trees_graphs;

import Utility.Tree;
import Utility.TreeNode;

public class LargestBSTInBT {

    public static void main(String[] args) {
        TreeNode root = createBT();
        Tree.displayTree(root);
        System.out.println(recurse(root).size);
    }

    private static class ObjectReturn {
        boolean isBST;
        Integer size, min, max;

        public ObjectReturn(boolean isBST, int size, Integer min, Integer max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }

        public ObjectReturn() {
            this.isBST = true;
            this.size = 0;
            this.min = Integer.MAX_VALUE;
            this.max = Integer.MIN_VALUE;
        }
    }

    private static ObjectReturn recurse(TreeNode node) {
        if (node == null) {
            return new ObjectReturn();
        }
        if (node.getLeftChildNode() == null && node.getRightChildNode() == null) {
            return new ObjectReturn(true, 1, (Integer) node.getData(), (Integer) node.getData());
        } else {
            ObjectReturn left = recurse(node.getLeftChildNode());
            ObjectReturn right = recurse(node.getRightChildNode());
            if ((!(left.isBST && right.isBST)) ||
                    !(((Integer) node.getData() > left.max) && ((Integer) node.getData() < right.min))) {
                int size = Math.max(left.size, right.size);
                return new ObjectReturn(false, size, 0, 0);
            }
            int size = left.size + right.size + 1;
            return new ObjectReturn(true, size, left.min, right.max);
        }
    }

    private static TreeNode createBT() {
        TreeNode root = new TreeNode(null, null, null, 20);

        root.setLeftChildNode(new TreeNode(null, null, null, 18));
        root.setRightChildNode(new TreeNode(null, null, null, 50));

        root.getLeftChildNode().setLeftChildNode(new TreeNode(null, null, null, 19));
        root.getLeftChildNode().setRightChildNode(new TreeNode(null, null, null, 20));
        root.getRightChildNode().setLeftChildNode(new TreeNode(null, null, null, 35));
        root.getRightChildNode().setRightChildNode(new TreeNode(null, null, null, 60));

        root.getLeftChildNode().getLeftChildNode().setRightChildNode(new TreeNode(null, null, null, 15));
        root.getLeftChildNode().getRightChildNode().setLeftChildNode(new TreeNode(null, null, null, 18));
        root.getLeftChildNode().getRightChildNode().setRightChildNode(new TreeNode(null, null, null, 25));
        root.getRightChildNode().getLeftChildNode().setLeftChildNode(new TreeNode(null, null, null, 20));
        root.getRightChildNode().getLeftChildNode().setRightChildNode(new TreeNode(null, null, null, 40));
        root.getRightChildNode().getRightChildNode().setLeftChildNode(new TreeNode(null, null, null, 55));
        root.getRightChildNode().getRightChildNode().setRightChildNode(new TreeNode(null, null, null, 70));

        root.getRightChildNode().getLeftChildNode().getLeftChildNode().setRightChildNode(new TreeNode(null, null, null, 25));

        return root;
    }
}
