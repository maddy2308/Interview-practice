package Utility;

public class BinaryTree {
    public static TreeNode root, leaf1, leaf2, leaf4, leaf3, rNode1, rNode2, lNode;


    /*
                  4
            3           6
        1           5       9
                        7       12
     */
    public static TreeNode getBinaryTree() {
        // create test Tree
        root = new TreeNode(null, null, null, 4);

        leaf1 = new TreeNode(null, null, null, 1);
        leaf2 = new TreeNode(null, null, null, 5);
        leaf3 = new TreeNode(null, null, null, 7);
        leaf4 = new TreeNode(null, null, null, 12);

        lNode = new TreeNode(root, leaf1, null, 3);
        leaf1.setParent(lNode);

        rNode1 = new TreeNode(root, leaf2, null, 6);
        rNode2 = new TreeNode(rNode1, leaf3, leaf4, 9);
        leaf2.setParent(rNode1);
        leaf3.setParent(rNode2);
        leaf4.setParent(rNode2);
        rNode1.setRightChildNode(rNode2);

        lNode.setParent(root);
        rNode1.setParent(root);
        root.setLeftChildNode(lNode);
        root.setRightChildNode(rNode1);

        return root;
    }

    public static TreeNode getBinarySearchTree(){
        TreeNode nodeL = new TreeNode(null, new TreeNode(null, null, null, -1), new TreeNode(null, null, null, 8), 6);
        TreeNode nodeR = new TreeNode(null, new TreeNode(null, null, null, 15), null, 18);
        root = new TreeNode(null, nodeL, nodeR, 9);
        return root;
    }
}
