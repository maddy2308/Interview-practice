package trees_graphs;

/*
     Print all nodes at distance k from a given node
     Consider the tree shown in diagram below:

                20
              /    \
             8     22
           /   \
          4    12
              /  \
             10  14

        Input: target = pointer to node with data 8.
               root = pointer to node with data 20.
               k = 2.
        Output : 10 14 22

        If target is 14 and k is 3, then output
        should be "4 20"

 */

import Utility.BinaryTree;
import Utility.Tree;
import Utility.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class NodesAtDistanceK {

    private static boolean flag = false;
    private static Set<TreeNode> set = new HashSet<TreeNode>();

    public static void main(String[] args) {
        int k = 4;
        TreeNode root = BinaryTree.getBinaryTree3();
        Tree.displayTree(root);
        TreeNode target = root.getRightChildNode().getLeftChildNode(); // 4
        downDfs(target, k);
        upDfs(target, root, k - 1);
    }

    private static void downDfs(TreeNode key, int k) {
        if (key != null) {
            if (k == 0)
                System.out.print(key.getData() + ", ");
            else {
                downDfs(key.getLeftChildNode(), k - 1);
                downDfs(key.getRightChildNode(), k - 1);

            }
        }
    }

    private static void upDfs(TreeNode target, TreeNode root, int k) {
        if (root == null) return;
        if (k == 0) {
            System.out.print(root.getData() + ", ");
            return;
        }
        if ((root.getLeftChildNode() == target) || (root.getRightChildNode() == target)) {
            set.add(target);
            set.add(root);
            flag = true;
        }
        TreeNode left = root.getLeftChildNode();
        TreeNode right = root.getRightChildNode();
        do {

            if (!set.contains(left)) {

                if (flag) {
                    set.add(left);
                    upDfs(target, left, k - 1);
                } else {
                    upDfs(target, left, k);
                }
            }
            if (!set.contains(right)) {

                if (flag) {
                    set.add(right);
                    upDfs(target, right, k - 1);
                } else {
                    upDfs(target, right, k);
                }
            }
        } while (!(set.contains(left) && set.contains(right)) && flag);
    }

}
