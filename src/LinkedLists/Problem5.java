package LinkedLists;

import linkedListImplementation_Better.SLinkedList;
import linkedListImplementation_Better.SListNode;

public class Problem5 {
    private SLinkedList addedNumbers = new SLinkedList();

    public Problem5() {
        SLinkedList firstNumberList = new SLinkedList();
        firstNumberList.insertFront("3");
        firstNumberList.insertFront("2");
        firstNumberList.insertFront("1");

        SLinkedList secondNumberList = new SLinkedList();
        secondNumberList.insertFront("7");
        secondNumberList.insertFront("8");
        secondNumberList.insertFront("2");
        secondNumberList.insertFront("9");

        addRecurssive(secondNumberList.getHead(), firstNumberList.getHead(), 0);
        SListNode temp = addedNumbers.getHead();
        //SListNode temp = add(secondNumberList.getHead(), firstNumberList.getHead());
        while (temp != null) {
            System.out.println(temp.getItem().toString());
            temp = temp.getNext();
        }
    }

    public static void main(String[] args) {
        new Problem5();
    }

    SListNode add(SListNode secondListNode, SListNode firstListNode) {
        SLinkedList addedNumbers = new SLinkedList();
        int carry = 0;
        // to maintain the type we could use a stack to first store the o/p and the after
        // addition create a linked list popping out the stack.
        while (secondListNode != null || firstListNode != null) {
            int firstNumber = firstListNode != null ? Integer.parseInt(firstListNode.getItem().toString()) : 0;
            int secondNumber = secondListNode != null ? Integer.parseInt(secondListNode.getItem().toString()) : 0;
            int sum = firstNumber + secondNumber + carry;
            if (sum > 9) {
                carry = 1;
                sum -= 10;
            } else
                carry = 0;
            addedNumbers.insertFront(sum);
            secondListNode = getNextNode(secondListNode);
            firstListNode = getNextNode(firstListNode);
        }
        return addedNumbers.getHead();
    }


    void addRecurssive(SListNode secondListNode, SListNode firstListNode, int carry) {
        int sum;
        if (secondListNode == null && firstListNode == null) {
            return;
        } else {
            int firstNumber = firstListNode != null ? Integer.parseInt(firstListNode.getItem().toString()) : 0;
            int secondNumber = secondListNode != null ? Integer.parseInt(secondListNode.getItem().toString()) : 0;
            sum = firstNumber + secondNumber + carry;
            if (sum > 9) {
                carry = 1;
                sum -= 10;
            } else
                carry = 0;
            secondListNode = getNextNode(secondListNode);
            firstListNode = getNextNode(firstListNode);
            addRecurssive(secondListNode, firstListNode, carry);
        }
        addedNumbers.insertFront(sum);
    }


    SListNode getNextNode(SListNode node) {
        if (node != null)
            return node.getNext();
        return null;
    }
}
