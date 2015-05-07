package trees_graphs;

import Utility.Tree;
import Utility.TreeNode;

public class BTFromPreAndInOrder {

    private int elementsVisited = 0;

    public static void main(String[] args) {
        BTFromPreAndInOrder obj = new BTFromPreAndInOrder();
        TreeNode rootNode = obj.parseToBT("abdegcfh", "dbgeachf");
        Tree.displayTree(rootNode);
    }

    private TreeNode parseToBT(String preOrder, String str) {
        TreeNode root;
        if (str.length() == 1) {
            return new TreeNode(null, null, null, str);
        } else {
            char ch = preOrder.charAt(elementsVisited);
            root = new TreeNode(null, null, null, ch);
            int index = str.indexOf(ch);
            String left = str.substring(0, index);
            if (left.length() > 0) {
                elementsVisited++;
                root.setLeftChildNode(parseToBT(preOrder, left));
            }

            String right = str.substring(index + 1);
            if (right.length() > 0) {
                elementsVisited++;
                root.setRightChildNode(parseToBT(preOrder, right));
            }

        }
        return root;
    }
}
