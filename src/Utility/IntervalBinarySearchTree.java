package Utility;

import java.util.List;

public class IntervalBinarySearchTree<T> {

    public class IntervalNode {
        int low, high, max = Integer.MIN_VALUE;
        IntervalNode left;
        IntervalNode right;

        public IntervalNode(int low, int high, IntervalNode left, IntervalNode right) {
            this.low = low;
            this.high = high;
            this.left = left;
            this.right = right;
        }
    }

    public IntervalBinarySearchTree(List<T> list) {
        IntervalNode root = new IntervalNode(1, 5, null, null);
        insert(root, null);
        insert(new IntervalNode(3, 7, null, null), root);
        insert(new IntervalNode(2, 6, null, null), root);
        insert(new IntervalNode(10, 15, null, null), root);
        insert(new IntervalNode(5, 6, null, null), root);
        insert(new IntervalNode(4, 100, null, null), root);
    }

    public int insert(IntervalNode node, IntervalNode root) {
        if (root == null) {
            node.max = node.high;
            return 0;
        } else {
            if (root.low >= node.low) {
                // go left
                int left = insert(node, root.left);
                if (left == 0) {
                    root.left = node;
                    root.max = root.max < node.max ? node.max : root.max;
                } else {
                    root.max = root.max < left ? left : root.max;
                }
            } else {
                // go right
                int right = insert(node, root.right);
                if (right == 0) {
                    root.right = node;
                    root.max = root.max < node.max ? node.max : root.max;
                } else {
                    root.max = root.max < right ? right : root.max;
                }
            }
            return node.max;
        }
    }


    // Driver program
    public static void main(String[] args) {
        IntervalBinarySearchTree ibst = new IntervalBinarySearchTree(null);
    }

}
