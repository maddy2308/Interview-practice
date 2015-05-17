package LinkedLists;

import linkedListImplementation_Better.SLinkedList;
import linkedListImplementation_Better.SListNode;

import java.util.Random;

public class MiddleOfLinkedList {

    SListNode fast, slow;

    public static void main(String[] args) {
        MiddleOfLinkedList obj = new MiddleOfLinkedList();
        SListNode head = obj.createLinkedList().getHead();
        obj.print(head);
        SListNode mid = obj.getMiddle(head);
        System.out.println(mid.getItem());
    }

    private void print(SListNode head) {
        while (head != null) {
            System.out.print(head.getItem() + " ");
            head = head.getNext();
        }
        System.out.println();
    }

    private SLinkedList createLinkedList() {
        SLinkedList list = new SLinkedList();
        Random r = new Random();
        int j = r.nextInt(20);
        for (int i = 0; i < j; i++) {
            list.insertFront(i);
        }
        return list;
    }

    SListNode getMiddle(SListNode headPtr) {
        if (headPtr == null || headPtr.getNext() == null) {
            return headPtr;
        } else {
            slow = headPtr;
            fast = headPtr.getNext();
            while (fast != null) {
                slow = slow.getNext();
                fast = fast.getNext();
                if (fast != null) {
                    fast = fast.getNext();
                }
            }
            return slow;
        }
    }

}
