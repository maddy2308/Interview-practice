package LinkedLists;

import linkedListImplementation_Better.SLinkedList;
import linkedListImplementation_Better.SListNode;

public class RotateLinkedList {
    public static void main(String[] args) {
        SLinkedList list = new SLinkedList();
        list.insertFront(5);
        SListNode tail = list.getHead();
        list.insertFront(4);
        list.insertFront(3);
        list.insertFront(2);
        list.insertFront(1);
        SListNode head = list.getHead();
        RotateLinkedList obj = new RotateLinkedList();
        print(obj.rotateListByK(3, head, tail));
    }

    private static void print(SListNode head) {
        while (head != null) {
            System.out.print(head.getItem() + " ");
            head = head.getNext();
        }
        System.out.println();
    }

    private SListNode rotateListByK(int k, SListNode head, SListNode tail) {
        while (k > 0) {
            SListNode temp = head;
            head = head.getNext();
            temp.setNext(null);
            tail.setNext(temp);
            tail = tail.getNext();
            k--;
        }
        return head;
    }
}
