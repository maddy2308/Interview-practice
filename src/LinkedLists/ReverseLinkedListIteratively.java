package LinkedLists;

import linkedListImplementation_Better.SLinkedList;
import linkedListImplementation_Better.SListNode;

import java.util.Stack;

public class ReverseLinkedListIteratively {

    private SListNode start = null;
    public static void main(String[] args) {
        ReverseLinkedListIteratively obj = new ReverseLinkedListIteratively();
        obj.reverseLinkedList(obj.start);
    }

    public ReverseLinkedListIteratively(){
        SLinkedList obj = new SLinkedList();
        obj.insertFront("1");
        obj.insertFront("2");
        obj.insertFront("3");
        obj.insertFront("4");
        obj.insertFront("5");
        start = obj.getHead();
        print(start);
    }

    public void reverseLinkedList(SListNode start){
        SListNode node = start;
        int count = 0;
        while (node != null) {
            node = node.getNext();
            count++;
        }
        int halfWay = count/2;
        Stack<SListNode> st = new Stack<SListNode>();
        node = start;
        while (halfWay > 0){
            st.push(node);
            node = node.getNext();
            halfWay--;
        }
        node = (count % 2 == 0)? node: node.getNext();
        while(!st.isEmpty()) {
            swap(node, st.pop());
            node = node.getNext();
        }
        print(start);
    }

    private void swap(SListNode node, SListNode popNode) {
        Object item = popNode.getItem();
        popNode.setItem(node.getItem());
        node.setItem(item);
    }

    public void print(SListNode start){
        while (start != null){
            System.out.print(start.getItem());
            start = start.getNext();
        }
        System.out.println();
    }
}
