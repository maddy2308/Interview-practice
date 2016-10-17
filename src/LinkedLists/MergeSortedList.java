package LinkedLists;

public class MergeSortedList {

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode currentNode = null, firstNode = null;

        while (l1 != null || l2 != null) {
            ListNode temp;
            if (l1 == null) {
                temp = new ListNode(l2.val);
                l2 = l2.next;
            } else if (l2 == null) {
                temp = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                if (l1.val <= l2.val) {
                    temp = new ListNode(l1.val);
                    l1 = l1.next;
                } else {
                    temp = new ListNode(l2.val);
                    l2 = l2.next;
                }
            }

            if (firstNode == null) {
                firstNode = new ListNode(temp.val);
                currentNode = firstNode;
            } else {
                currentNode.next = temp;
                currentNode = temp;
            }
        }
        if (firstNode == null) {
            return null;
        }
        return firstNode;
    }

    public static void main(String[] args) {
        new MergeSortedList().createTestCases();
    }

    private void createTestCases() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;

        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l3.next = l4;

        ListNode reult = mergeTwoLists(l1, l3);

    }

}
