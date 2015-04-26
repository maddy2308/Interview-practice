package practiceProblems;

import linkedListImplementation_Better.SLinkedList;
import linkedListImplementation_Better.SListNode;

public class ReverseLinkedList {

    private static SListNode head = null;
    private static boolean isRevesingDone = true;

    public static void main(String[] args) {
        SLinkedList list = new SLinkedList();
        list.insertFront(5);
        list.insertFront(4);
        list.insertFront(3);
        list.insertFront(2);
        list.insertFront(1);
        head = list.getHead();
        print(head);
        ReverseLinkedList obj = new ReverseLinkedList();
        for (int i = 0; i < 3; i++) {
            obj.reverse(list.getHead());
            isRevesingDone = true;
            head = list.getHead();
            print(list.getHead());
        }

    }

    private static void print(SListNode head) {
        while (head != null) {
            System.out.print(head.getItem() + " ");
            head = head.getNext();
        }
        System.out.println();
    }

    private void reverse(SListNode node) {
        if (node == null)
            return;
        reverse(node.getNext());
        if (node != head && isRevesingDone) {
            swap(node, head);
            head = head.getNext();
        } else {
            isRevesingDone = false;
        }
    }

    private void swap(SListNode node1, SListNode node2) {
        Object temp = node1.getItem();
        node1.setItem(node2.getItem());
        node2.setItem(temp);
    }
}
