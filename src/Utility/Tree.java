package Utility;

import trees_graphs.Problem3_createBST_minimalHeight;

import java.util.Stack;

public class Tree {
    private static TreeNode root;

    public Tree() {

		/*root = new TreeNode(null, null, "a");
        root.setLeftChildNode(new TreeNode(new TreeNode(null, null, "j"),
				new TreeNode(null, null, "k"), "b"));
		root.setRightChildNode(new TreeNode(new TreeNode(new TreeNode(null,
				null, "e"), null, "d"), new TreeNode(new TreeNode(new TreeNode(
				null, null, "m"), null, "i"), null, "h"), "c"));*/
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        Tree.root = root;
    }

    public void inOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        inOrderTraversal(root.getLeftChildNode());
        System.out.print(root.getData() + " ");
        inOrderTraversal(root.getRightChildNode());
    }

    public void preOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.getData() + " ");
        preOrderTraversal(root.getLeftChildNode());
        preOrderTraversal(root.getRightChildNode());
    }

    public void postOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        postOrderTraversal(root.getLeftChildNode());
        postOrderTraversal(root.getRightChildNode());
        System.out.print(root.getData() + " ");
    }

    /**
     * The following function takes in a sorted array of unique values/keys and
     * creates the BST of minimal height
     *
     *
     * @return TreeNode (root node of the tree)
     */
    public void createBst(int array[]) {
        setRoot(new Problem3_createBST_minimalHeight(array).createBst(array));
    }

    /**
     * This function removes a node from a BST by taking the value to be
     * removed. BST has the constraint that all the keys are unique
     *
     * @param /key to be deleted
     */
    public void removeNode(int data) {
        TreeNode node = removeNodeHelper(root, data);
        String str = (String) (node == null ? "no such key found" : node
                .getData().toString());
        System.out.println("\n" + str);

    }

    private TreeNode removeNodeHelper(TreeNode root, int data) {
        TreeNode left = root.getLeftChildNode(), right = root
                .getRightChildNode();
        TreeNode parent = root, predecessor = null;
        if (root == null)
            return null;
        if ((Integer) root.getData() == data) {
            root.setData(findPredecessor(root.getLeftChildNode()).getData());
            return root;
        }
        if (left != null && (Integer) left.getData() == data) {
            predecessor = findPredecessor(left);
            if (predecessor != null) {
                parent.getLeftChildNode().setData(predecessor.getData());
            } else {
                parent.setLeftChildNode(predecessor);

            }
            return predecessor;
        } else if (right != null && (Integer) right.getData() == data) {
            predecessor = findPredecessor(right);
            if (predecessor != null) {
                parent.getRightChildNode().setData(predecessor.getData());
            } else {
                parent.setRightChildNode(predecessor);
            }
            return predecessor;
        } else if ((Integer) root.getData() > data) {
            return removeNodeHelper(root.getLeftChildNode(), data);
        } else {
            return removeNodeHelper(root.getRightChildNode(), data);
        }
    }

    private TreeNode findPredecessor(TreeNode rootSubTree) {
        if (rootSubTree.getRightChildNode() != null) {
            return findRightMostNode(rootSubTree.getRightChildNode());
        } else if (rootSubTree.getLeftChildNode() != null) {
            return findRightMostNode(rootSubTree.getLeftChildNode());
        } else {
            return null;
        }
    }

    /**
     * This function expects the root of the sub tree for which the rightmost
     * child is needed.
     *
     * @param rootSubTree
     * @return TreeNode
     */
    private TreeNode findRightMostNode(TreeNode rootSubTree) {
		/*
		 * if (rootSubTree == null) { return null; } else if
		 * (rootSubTree.getRightChildNode() == null) { return rootSubTree; }
		 * else { return findRightMostNode(rootSubTree.getRightChildNode()); }
		 */
        if (rootSubTree == null) {
            return null;
        } else {
            while ((rootSubTree.getRightChildNode() != null)

                    && (rootSubTree.getRightChildNode().getRightChildNode() != null)) {
                rootSubTree = rootSubTree.getRightChildNode();
            }
            TreeNode predecessor = rootSubTree.getRightChildNode();
            rootSubTree.setRightChildNode(null);
            return predecessor;
        }
    }

    /**
     * This function imitates the find functionality given the key to be
     * searched and returns null if not found
     *
     * @param  /key to be searched
     * @return null if not found else TreeNode if found
     */
    public TreeNode findNode(int data) {
        return findNodeHelper(this.getRoot(), data);
    }

    private TreeNode findNodeHelper(TreeNode root, int data) {
        if (root == null)
            return null;
        if ((Integer) root.getData() == data) {
            return root;
        } else if ((Integer) root.getData() > data) {
            return findNodeHelper(root.getLeftChildNode(), data);
        } else {
            return findNodeHelper(root.getRightChildNode(), data);
        }
    }

    public static void displayTree(TreeNode root) {
        Stack<TreeNode> globalStack = new Stack<TreeNode>();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println(
                "......................................................");
        while (!isRowEmpty) {
            Stack<TreeNode> localStack = new Stack<TreeNode>();
            isRowEmpty = true;

            for (int j = 0; j < nBlanks; j++)
                System.out.print(' ');

            while (!globalStack.isEmpty()) {
                TreeNode temp = globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.getData());
                    localStack.push(temp.getLeftChildNode());
                    localStack.push(temp.getRightChildNode());

                    if (temp.getLeftChildNode() != null ||
                            temp.getRightChildNode() != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++)
                    System.out.print(' ');
            }  // end while globalStack not empty
            System.out.println();
            nBlanks /= 2;
            while (!localStack.isEmpty())
                globalStack.push(localStack.pop());
        }  // end while isRowEmpty is false
        System.out.println(
                "......................................................");
    }

}
