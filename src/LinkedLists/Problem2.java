package LinkedLists;

import linkedListImplementation_Better.SLinkedList;
import linkedListImplementation_Better.SListNode;

public class Problem2 {

    int count = 5;

    public Problem2() {
        SLinkedList obj = new SLinkedList();
        obj.insertFront("1");
        obj.insertFront("2");
        obj.insertFront("3");
        obj.insertFront("4");
        obj.insertFront("5");
        obj.insertFront("6");
        SListNode temp = obj.getHead();
//		while(temp!=null){
//			System.out.println(temp.getItem().toString());
//			temp = temp.getNext();
//		}

        iterateLL(temp);
    }

    public static void main(String[] args) {
        new Problem2();
    }

    public void iterateLL(SListNode head) {
        if (head == null)
            return;
        else
            iterateLL(head.getNext());
        if (count > 0) {
            count--;
            System.out.println(head.getItem());
        }
    }
}
