package LinkedLists;

import Utility.BinaryTree;
import Utility.Tree;
import Utility.TreeNode;
import linkedListImplementation_Better.SLinkedList;
import linkedListImplementation_Better.SListNode;

import java.util.ArrayList;
import java.util.List;

public class TreeAsLinkedList {

    private List<SLinkedList> listOfLevels = new ArrayList<SLinkedList>();

    public static void main(String[] args) {
        TreeNode root = BinaryTree.getBinaryTree();
        Tree.displayTree(root);
        TreeAsLinkedList obj = new TreeAsLinkedList();
        obj.traverseTree(root);
        for (SLinkedList list : obj.listOfLevels) {
            obj.printLinkedList(list);
        }
    }

    private void traverseTree(TreeNode node) {
        // creating linked list for the root node
        SLinkedList rootList = new SLinkedList();
        rootList.insertFront(node);
        listOfLevels.add(rootList);
        for (int i = 0; i < listOfLevels.size(); i++) {
            SLinkedList temp = createLinkedListAtDepths(listOfLevels.get(i));
            if (temp != null)
                listOfLevels.add(temp);
        }
    }

    private SLinkedList createLinkedListAtDepths(SLinkedList list) {
        SLinkedList newList = new SLinkedList();
        SListNode node = list.getHead();
        while (node != null) {
            TreeNode item = (TreeNode) node.getItem();
            if (item.getLeftChildNode() != null) {
                newList.insertFront(item.getLeftChildNode());
            }
            if (item.getRightChildNode() != null) {
                newList.insertFront(item.getRightChildNode());
            }
            node = node.getNext();
        }
        return newList.getLength() > 0 ? newList : null;
    }

    private void printLinkedList(SLinkedList list) {
        SListNode node = list.getHead();
        while (node != null) {
            TreeNode item = (TreeNode) node.getItem();
            System.out.print(item.getData() + " ");
            node = node.getNext();
        }
        System.out.println();
    }
}
