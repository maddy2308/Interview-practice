package trees_graphs;

import Utility.Tree;
import Utility.TreeNode;

public class BTFromPreAndInOrder {

    private static int elementsVisited = 0;

    public static void main(String[] args) {
        TreeNode rootNode = parseToBT("abdegcfh", "dbgeachf");
        Tree.displayTree(rootNode);
    }

    public static TreeNode parseToBT(String preOrder, String inOrder) {
        TreeNode root;
        if (inOrder.length() == 1) {
            return new TreeNode(null, null, null, inOrder);
        } else {
            char ch = preOrder.charAt(elementsVisited);
            root = new TreeNode(null, null, null, ch);
            int index = inOrder.indexOf(ch);
            String left = inOrder.substring(0, index);
            if (left.length() > 0) {
                elementsVisited++;
                root.setLeftChildNode(parseToBT(preOrder, left));
            }

            String right = inOrder.substring(index + 1);
            if (right.length() > 0) {
                elementsVisited++;
                root.setRightChildNode(parseToBT(preOrder, right));
            }

        }
        return root;
    }
}
