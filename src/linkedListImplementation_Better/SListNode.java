package linkedListImplementation_Better;

public class SListNode {

    private Object item;
    private SListNode next;

    /**
     * The following constructor is used to initialize an object of type SLNode
     *
     * @param item
     * @param next
     */

    public SListNode(Object item, SListNode next) {
        this.item = item;
        this.next = next;
    }

    /**
     * The following method inserts the object, after the node at which pointer
     * currently points at.
     *
     * @param item
     */
    public void insertAfter(Object item) {
        this.next = new SListNode(item, next);
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    public SListNode getNext() {
        return next;
    }

    public void setNext(SListNode next) {
        this.next = next;
    }

}
