package trees_graphs;

import Utility.BinaryTree;
import Utility.Tree;
import Utility.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class TreeQuestions {

    private static Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
    private static Map<TreeNode, TreeNode> parentChildMap = new HashMap<TreeNode, TreeNode>();

    public static void main(String[] args) {
        TreeNode root = BinaryTree.getBinaryTree3();
        Tree.displayTree(root);
        findClosestLeaf(root);

        // running question to remove Nodes
        TreeNode newRoot = removeNodes(root, 4, 1);
        Tree.displayTree(newRoot);

    }

    // Remove nodes on root to leaf paths of length < K
    private static TreeNode removeNodes(TreeNode node, int k, int height) {
        if (node == null) {
            return null;
        } else {
            node.setLeftChildNode(removeNodes(node.getLeftChildNode(), k, height + 1));
            node.setRightChildNode(removeNodes(node.getRightChildNode(), k, height + 1));
            if (node.getLeftChildNode() == null && node.getRightChildNode() == null && height < k) {
                return null;
            } else {
                return node;
            }
        }
    }

    // Question - 2
    // http://www.geeksforgeeks.org/find-closest-leaf-binary-tree/
    //
    // Find the closest leaf in a Binary Tree
    // Given a Binary Tree and a key ‘k’, find distance of the closest leaf from ‘k’.
    /*
            Examples:

               A
             /   \
            B      C
                 /   \
                E     F
               /       \
              G         H
             / \       /
            I   J     K

        Closest leaf to 'H' is 'K', so distance is 1 for 'H'
        Closest leaf to 'C' is 'B', so distance is 2 for 'C'
        Closest leaf to 'E' is either 'I' or 'J', so distance is 2 for 'E'
        Closest leaf to 'B' is 'B' itself, so distance is 0 for 'B'
     */

    public static void findClosestLeaf(TreeNode root) {
        dfs_FindingLeafForEveryNode(root, null);
        printMap(map);

        for (Map.Entry<TreeNode, Integer> e : map.entrySet()) {
            int heightToLeaf = e.getValue();
            TreeNode node = e.getKey();
            if (heightToLeaf >= 2) {
                int parentToLeaf = map.get(parentChildMap.get(node));
                if (parentToLeaf + 1 < heightToLeaf) {
                    map.put(node, parentToLeaf + 1);
                }
            }
        }
        printMap(map);
        map = null;
        parentChildMap = null;
    }

    private static void printMap(Map<TreeNode, Integer> map) {
        for (Map.Entry<TreeNode, Integer> e : TreeQuestions.map.entrySet()) {
            System.out.print(e.getKey().getData() + "-->" + e.getValue() + " ,");
        }
        System.out.println();
    }

    private static int dfs_FindingLeafForEveryNode(TreeNode node, TreeNode parent) {
        parentChildMap.put(node, parent);
        if (node == null) {
            return 0;
        } else {
            int height;
            int leftHeight = dfs_FindingLeafForEveryNode(node.getLeftChildNode(), node);
            int rightHeight = dfs_FindingLeafForEveryNode((node.getRightChildNode()), node);
            if (leftHeight == 0 && rightHeight == 0) {
                height = 1;
            } else if (leftHeight != 0 && rightHeight != 0) {
                height = Math.min(leftHeight, rightHeight) + 1;
            } else {
                height = leftHeight == 0 ? rightHeight + 1 : leftHeight + 1;
            }
            map.put(node, height - 1);
            return height;
        }
    }
}
