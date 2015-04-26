package linkedListImplementation_Better;


public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SLinkedList obj = new SLinkedList();
        obj.insertFront("test");
        obj.insertFront("continued");
        SListNode temp = obj.getHead();
        while (temp != null) {
            System.out.println(temp.getItem().toString());
            temp = temp.getNext();
        }
    }

}
