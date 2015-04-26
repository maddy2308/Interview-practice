package LinkedLists;

import linkedListImplementation_Better.SLinkedList;
import linkedListImplementation_Better.SListNode;

import java.util.Stack;

public class Problem7 {

    SLinkedList sLinkedList = new SLinkedList();

    public void createList(String input) {
        for (int index = 0; index < input.length(); index++) {
            sLinkedList.insertFront(input.charAt(index));
        }
    }

    public boolean isPalindrome() {

        Stack<Object> stack = new Stack<Object>();
        int length = sLinkedList.getLength();
        int mid = (length / 2);
        SListNode temp = sLinkedList.getHead();
        for (int index = 0; index < mid; index++) {
            stack.push(temp.getItem());
            temp = temp.getNext();
        }
        temp = length % 2 == 0 ? temp : temp.getNext();
        int index = length % 2 == 0 ? mid : mid + 1;
        for (; index < length; index++) {
            if (!(temp.getItem().equals(stack.pop()))) {
                return false;
            }
            temp = temp.getNext();
        }
        return true;
    }
}
