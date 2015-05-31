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
        driverMethodToRun(5);
    }

    private static void driverMethodToRun(int questionNumber) {
        TreeNode root = BinaryTree.getBinaryTree3();
        switch (questionNumber) {
            case 1: {
                root = BinaryTree.getBinaryTree3();
                Tree.displayTree(root);
                findClosestLeaf(root);
                break;
            }
            case 2: {
                // running question to remove Nodes
                TreeNode newRoot = removeNodes(root, 4, 1);
                Tree.displayTree(newRoot);
                break;
            }
            case 3: {
                // running the question to find the distance between two nodes
                root = BinaryTree.getBinaryTree2();
                Tree.displayTree(root);
                System.out.println(distanceBetweenTwoNodes(root, 3, 7));
            }
            case 4: {
                // running the question to check if the leaves are at same level.
                root = new TreeNode(null, null, null, 12);
                root.setLeftChildNode(new TreeNode(null, null, null, 5));
                root.setRightChildNode(new TreeNode(null, null, null, 7));
                root.getLeftChildNode().setLeftChildNode(new TreeNode(null, null, null, 3));
                root.getLeftChildNode().setRightChildNode(new TreeNode(null, null, null, 2));
                root.getRightChildNode().setRightChildNode(new TreeNode(null, null, null, 1));
                Tree.displayTree(root);
                System.out.println(dfs_SameLeafLevel(root, 0));
            }
            case 5: {
                // running the question to remove the nodes that sum upto less than K
                // removeNodesLessThanSumK
                root = BinaryTree.getBigBinaryTree();
                Tree.displayTree(root);
                root = removeNodesLessThanSumK(root, 0, 20);
                Tree.displayTree(root);
            }

        }
    }


    // Question - 1
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
            if (heightToLeaf >= 2 && parentChildMap.containsKey(node)) {
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

    // Question - 3
    /*
        Find distance between two given keys of a Binary Tree
        link on geek for geeks --> http://www.geeksforgeeks.org/find-distance-two-given-nodes/
     */

    private static int distanceBetweenTwoNodes(TreeNode root, int first, int second) {

        TreeNode lca = new LowestCommonAncestor().findLowestCommonAncestorInBT(root, first, second);
        System.out.println(lca.getData());

        // do double dfs to get the distance from the lca to the two nodes that contains the keys
        int firstLength = dfs(lca, first);
        int secondLength = dfs(lca, second);

        return firstLength + secondLength;
    }

    private static int dfs(TreeNode root, int key) {
        if (root == null)
            return -1;
        else if ((Integer) root.getData() == key) {
            return 0;
        } else {
            int left = dfs(root.getLeftChildNode(), key);
            int right = -1;
            if (left < 0) {
                right = dfs(root.getRightChildNode(), key);
            }
            return (left >= 0 || right >= 0) ? (Math.max(left, right) + 1) : Math.max(left, right);
        }
    }

    // Question - 4
    /*
            Given a Binary Tree, check if all leaves are at same level or not.
                  12
                /    \
              5       7
            /          \
           3            1
          Leaves are at same level

                  12
                /    \
              5       7
            /
           3
           Leaves are Not at same level
     */
    private static int firstHeight = Integer.MIN_VALUE;

    private static boolean dfs_SameLeafLevel(TreeNode root, int height) {
        if (root == null) return true;
        if (root.getLeftChildNode() == null && root.getRightChildNode() == null) {
            if (firstHeight == Integer.MIN_VALUE) {
                firstHeight = height;
                return true;
            } else {
                return firstHeight == height;
            }
        } else {
            return (dfs_SameLeafLevel(root.getLeftChildNode(), height + 1) &&
                    dfs_SameLeafLevel(root.getRightChildNode(), height + 1));
        }
    }


    // Question - 5
    /*
            Remove all nodes which don’t lie in any path with sum>= k

            Consider the following Binary Tree
                      1
                  /      \
                 2        3
               /   \     /  \
              4     5   6    7
             / \    /       /
            8   9  12      10
               / \           \
              13  14         11
                  /
                 15

            For input k = 20, the tree should be changed to following
            (Nodes with values 6 and 8 are deleted)
                      1
                  /      \
                 2        3
               /   \        \
              4     5        7
               \    /       /
                9  12      10
               / \           \
              13  14         11
                  /
                 15

            For input k = 45, the tree should be changed to following.
                  1
                /
               2
              /
             4
              \
               9
                \
                 14
                 /
                15

     */

    private static TreeNode removeNodesLessThanSumK(TreeNode root, int sum, int k) {
        if (root == null)
            return null;
        else {
            root.setLeftChildNode(removeNodesLessThanSumK(root.getLeftChildNode(), sum + (Integer) root.getData(), k));
            root.setRightChildNode(removeNodesLessThanSumK(root.getRightChildNode(),
                    sum + (Integer) root.getData(), k));
            if ((root.getLeftChildNode() == null) && (root.getRightChildNode() == null) &&
                    (sum + (Integer) root.getData() < k))
                return null;
            else {
                return root;
            }
        }
    }
}
