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

    /*
                1
              /   \
             2     3
           /   \     \
          4    5      6
         /            /
        7            8

     */


    public static TreeNode getBinaryTree2() {
        TreeNode root = new TreeNode(null, null, null, 1);
        root.setLeftChildNode(new TreeNode(null, new TreeNode(null, new TreeNode(null, null, null, 7), null, 4),
                new TreeNode(null, null, null, 5), 2));

        root.setRightChildNode(new TreeNode(null, null, new TreeNode(null, new TreeNode(null, null, null, 8), null, 6),
                3));

        return root;
    }


    /*
               1
             /   \
            2      3
          /  \   /   \
         11  12 4     5
               /       \
              6         7
             / \       /
            8   9     10
     */

    public static TreeNode getBinaryTree3() {
        TreeNode root = new TreeNode(null, null, null, 1);

        root.setLeftChildNode(new TreeNode(null, new TreeNode(null, null, null, 11), new TreeNode(null, null, null, 12), 2));
        TreeNode sixSubTree = new TreeNode(null, new TreeNode(null, null, null, 8), new TreeNode(null, null, null, 9), 6);
        TreeNode sevenSubTree = new TreeNode(null, new TreeNode(null, null, null, 10), null, 7);


        root.setRightChildNode(new TreeNode(null,
                new TreeNode(null, sixSubTree, null, 4),
                new TreeNode(null, null, sevenSubTree, 5),
                3));

        return root;
    }

    // binary tree 4 and 5 are isomorphic to each other
    public static TreeNode getBinaryTree4() {
        TreeNode n1 = new TreeNode(null, null, null, 1);
        n1.setLeftChildNode(new TreeNode(null, null, null, 2));
        n1.setRightChildNode(new TreeNode(null, null, null, 3));

        n1.getLeftChildNode().setLeftChildNode(new TreeNode(null, null, null, 4));
        n1.getLeftChildNode().setRightChildNode(new TreeNode(null, null, null, 5));

        n1.getRightChildNode().setLeftChildNode(new TreeNode(null, null, null, 6));
        n1.getLeftChildNode().getRightChildNode().setLeftChildNode(new TreeNode(null, null, null, 7));
        n1.getLeftChildNode().getRightChildNode().setRightChildNode(new TreeNode(null, null, null, 8));
        return n1;
    }


    public static TreeNode getBinaryTree5() {
        TreeNode n2 = new TreeNode(null, null, null, 1);
        n2.setLeftChildNode(new TreeNode(null, null, null, 3));
        n2.setRightChildNode(new TreeNode(null, null, null, 2));

        n2.getRightChildNode().setLeftChildNode(new TreeNode(null, null, null, 4));
        n2.getRightChildNode().setRightChildNode(new TreeNode(null, null, null, 5));

        n2.getLeftChildNode().setRightChildNode(new TreeNode(null, null, null, 6));
        n2.getRightChildNode().getRightChildNode().setLeftChildNode(new TreeNode(null, null, null, 8));
        n2.getRightChildNode().getRightChildNode().setRightChildNode(new TreeNode(null, null, null, 7));

        return n2;
    }

    public static TreeNode getBigBinaryTree() {
        TreeNode root = new TreeNode(null, null, null, 1);
        root.setLeftChildNode(new TreeNode(null, null, null, 2));
        root.setRightChildNode(new TreeNode(null, null, null, 3));
        root.getLeftChildNode().setLeftChildNode(new TreeNode(null, null, null, 4));
        root.getLeftChildNode().setRightChildNode(new TreeNode(null, null, null, 5));
        root.getRightChildNode().setLeftChildNode(new TreeNode(null, null, null, 6));
        root.getRightChildNode().setRightChildNode(new TreeNode(null, null, null, 7));
        root.getLeftChildNode().getLeftChildNode().setLeftChildNode(new TreeNode(null, null, null, 8));
        root.getLeftChildNode().getLeftChildNode().setRightChildNode(new TreeNode(null, null, null, 9));
        root.getLeftChildNode().getRightChildNode().setLeftChildNode(new TreeNode(null, null, null, 12));
        root.getRightChildNode().getRightChildNode().setLeftChildNode(new TreeNode(null, null, null, 10));
        root.getLeftChildNode().getLeftChildNode().getRightChildNode().setLeftChildNode(new TreeNode(null, null, null, 13));
        root.getLeftChildNode().getLeftChildNode().getRightChildNode().setRightChildNode(new TreeNode(null, null, null, 14));
        root.getRightChildNode().getRightChildNode().getLeftChildNode().setRightChildNode(new TreeNode(null, null, null, 11));
        root.getLeftChildNode().getLeftChildNode().getRightChildNode().getRightChildNode().setRightChildNode(new TreeNode(null, null, null, 15));

        return root;
    }

}
