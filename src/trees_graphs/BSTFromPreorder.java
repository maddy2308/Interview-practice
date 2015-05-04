package trees_graphs;

import Utility.Tree;
import Utility.TreeNode;

public class BSTFromPreOrder {

    private int index = 0;
    private TreeNode root;
    int[] arr = new int[]{8, 4, 3, 1, 7, 5, 12, 10, 18, 16, 20};
    public static void main(String[] args) {
        BSTFromPreOrder obj = new BSTFromPreOrder();
        obj.root = new TreeNode(null, null, null, obj.arr[0]);
        obj.root = obj.createBstFromPreOrder(obj.arr[0], Integer.MIN_VALUE, Integer.MAX_VALUE);
        Tree.displayTree(obj.root);
    }

    private TreeNode createBstFromPreOrder(int value, int min, int max) {
        TreeNode n = null;
        if (value > min && value < max){
            n = new TreeNode(null, null, null, value);
            index++;
            if (index < arr.length)  {
                n.setLeftChildNode(createBstFromPreOrder(arr[index], min, value));
                n.setRightChildNode(createBstFromPreOrder(arr[index], value, max));
            }
        }
        return n;
    }
}