package trees_graphs;

import Utility.TreeNode;

/**
 * The class creates a BST with minimal height given a sorted array
 *
 * @author mehta.ma
 */
public class Problem3_createBST_minimalHeight {
    private int[] array;

    public Problem3_createBST_minimalHeight(int array[]) {
        this.array = array;
    }

    public TreeNode createBst(int[] array) {
        return createBst(0, array.length - 1);
    }

    private TreeNode createBst(int start, int end) {
        int mid = (start + end) / 2;
        if (start == end) {
            return new TreeNode(null, null, null, array[start]);
        } else if (start > end) {
            return null;
        } else {
            TreeNode left = createBst(start, mid - 1);
            TreeNode right = createBst(mid + 1, end);
            TreeNode root = new TreeNode(null, left, right, array[mid]);
            return root;
        }

    }
}
