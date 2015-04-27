package Utility;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Heap<T> {

    private int lastElementIndex = 0;
    private List<Node> heap;
    private Comparator<T> comparator;

    private class Node {
        public T element;

        public Node(T element) {
            this.element = element;
        }
    }

    public Heap(int size, Comparator<T> comparator) {
        this.comparator = comparator;
        heap = new ArrayList<Node>(size);
    }

    public void insertElement(T element) {
        Node node = new Node(element);
        heap.add(lastElementIndex, node);
        siftUp(lastElementIndex++);
    }

    public T topElement() {
        lastElementIndex = heap.size() - 1;
        Node top = null;
        if (heap.size() > 0) {
            top = heap.remove(0);
        }
        if (top != null && heap.size() > 1) {
            Node toRemoveWith = heap.remove(heap.size() - 1);
            heap.add(0, toRemoveWith);
            siftDown();

        }
        return top == null ? null : top.element;

    }

    private void siftUp(int index) {
        while (index != 0) {
            int parentIndex = (index - 1) / 2;
            Node child = heap.get(index);
            Node parent = heap.get(parentIndex);
            if (comparator.compare(child.element, parent.element) < 0) {
                swap(index, child, parentIndex, parent);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void siftDown() {
        int index = 0;
        while (true) {
            Node parent = heap.get(index);
            Node c1 = (heap.size() <= (2 * index + 1)) ? null : heap.get(2 * index + 1);
            Node c2 = (heap.size() <= (2 * index + 2)) ? null : heap.get(2 * index + 2);
            Node toCompareWith;
            int compareIndex;
            if (c1 != null && c2 != null) {
                if (comparator.compare(c1.element, c2.element) > 0) {
                    toCompareWith = c2;
                    compareIndex = 2 * index + 2;
                } else {
                    toCompareWith = c1;
                    compareIndex = 2 * index + 1;
                }
            } else {
                if (c1 == null) {
                    toCompareWith = c2;
                    compareIndex = 2 * index + 2;
                } else {
                    toCompareWith = c1;
                    compareIndex = 2 * index + 1;
                }
            }

            if (toCompareWith != null && comparator.compare(parent.element, toCompareWith.element) > 0) {
                swap(compareIndex, toCompareWith, index, parent);
                index = compareIndex;
            } else {
                break;
            }
        }
    }

    private void swap(int n1Index, Node n1, int n2Index, Node n2) {
        heap.set(n1Index, n2);
        heap.set(n2Index, n1);
    }
}
