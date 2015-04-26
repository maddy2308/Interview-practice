package linkedListImplementation_Better;

/**
 * The following Linked list implements LIFO method of reading and writing data
 *
 * @author Madhur
 */

public class SLinkedList {

    private SListNode head;
    private int length;

    /**
     * The constructor initializes the object and makes the head point to null
     * and total number of nodes i.e. length = 0
     */
    public SLinkedList() {
        this.head = null;
        this.length = 0;
    }

    /**
     * The following method updates the list head with the reference of the
     * new node inserted in the list.
     *
     * @param temp
     */
    public void insertFront(Object temp) {
        head = new SListNode(temp, head);
        length++;
    }

    public SListNode getHead() {
        return head;
    }

    public void setHead(SListNode head) {
        this.head = head;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    // getters and setters

}
