package practiceProblems;

public class LinkedList {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Node first = list.createLinkedList();
        list.printLinkedList(first);
        list.insertInSortedLinkedList(first, 3);
        list.printLinkedList(first);
        list.insertInSortedLinkedList(first, 5);
        list.printLinkedList(first);
    }

    private Node insertInSortedLinkedList(Node node, int value) {

        if (node == null) {
            return new Node(value, null);
        } else if (node.getItem() >= value) {
            return null;
        } else {
            Node newNode = insertInSortedLinkedList(node.getNext(), value);
            newNode = newNode == null ? new Node(value, node.getNext()) : newNode;
            node.setNext(newNode);
            return node;
        }
    }

    private Node createLinkedList() {
        // creating a queue based LinkedLIst
        Node n1 = new Node(4);
        Node n2 = new Node(2, n1);
        Node n3 = new Node(1, n2);

        return n3;
    }

    private void printLinkedList(Node front) {
        while (front != null) {
            System.out.print(front.getItem() + " ");
            front = front.getNext();
        }
        System.out.println();
    }

    private class Node {
        private int item;
        private Node next;

        public Node(int item, Node next) {
            this.item = item;
            this.next = next;
        }

        public Node(int item) {
            this(item, null);
        }

        public int getItem() {
            return item;
        }

        public void setItem(int item) {
            this.item = item;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
