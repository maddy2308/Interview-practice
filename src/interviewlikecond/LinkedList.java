package interviewlikecond;

/*
Write a singly linked list AND a dynamic array data structure, with methods to
add elements O(1),
remove all the elements that match a given value O(n),
return the length of the list O(1) ,

--> get method for array is constant time

type of element to be stored --> Integer

 */
public class LinkedList {

    class Node {
        int element;
        Node next;

        Node(int element) {
            this.element = element;
            this.next = null;
        }
    }

    private Node head, current;

    private int length = 0;

    public Node add(int element) {
        if (head == null) {
            head = new Node(element);
            current = head;
            length++;
        } else {
            Node temp = new Node(element);
            current.next = temp;
            current = temp;
            length++;
        }
        return current;
    }

    public int getLength() {
        return length;
    }

    public Node removeNodes(int element) {
        Node previous = null, current = head;
        while (current != null) {
            if (current.element == element) {
                if (previous == null) {
                    head = current.next;
                    current = head;
                    length--;
                    continue;
                } else {
                    previous.next = current.next;
                    length--;
                }
            } else {
                previous = current;
            }
            current = current.next;
        }
        return head;
    }

    public Node reverseList(Node current, Node backCurrent) {
        if (current == null) {
            return backCurrent;
        } else {
            Node temp = reverseList(current.next, backCurrent);
            if (temp == current) {
                return null;
            } else if (temp != null && temp.next == current) {
                int data = temp.element;
                temp.element = current.element;
                current.element = data;
                return null;
            }
            if (temp != null) {
                int data = temp.element;
                temp.element = current.element;
                current.element = data;
                return temp.next;
            } else
                return null;
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);

        ll.reverseList(ll.head, ll.head);
    }
}
