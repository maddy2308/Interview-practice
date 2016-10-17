import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by maddy on 8/7/16.
 */
public class Amazon {

    private static class Node {
        private int value, frequency;
        private Node left;
        private Node right;

        Node(int value, int frequency) {
            this.value = value;
            this.frequency = frequency;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getFrequency() {
            return frequency;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return value + ":" + frequency;
        }
    }

    static String gatherScores(int[] scores) {
        if (scores.length == 0) {
            return "";
        } else {
            Node root = new Node(scores[0], 1);
            createBST(root, scores);
            return bfs(root);
        }
    }

    static Node createBST(Node parent, int[] scores) {
        for (int i = 1; i < scores.length; i++) {
            createTree(parent, scores[i]);
        }
        return parent;
    }

    static Node createTree(Node parent, int element) {
        if (parent == null) {
            return null;
        } else if (parent.getValue() == element) {
            parent.setFrequency(parent.getFrequency() + 1);
        } else if (parent.getValue() > element) {
            if (createTree(parent.getLeft(), element) == null) {
                parent.setLeft(new Node(element, 1));
            }
        } else if (parent.getValue() < element) {
            if (createTree(parent.getRight(), element) == null) {
                parent.setRight(new Node(element, 1));
            }
        }
        return parent;
    }

    static String bfs(Node parent) {
        StringBuilder sb = new StringBuilder();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(parent);
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            if (temp == null) {
                sb.append(",");
            } else {
                sb.append(",").append(temp.toString());
                if (temp.getLeft() != null || temp.getRight() != null) {
                    queue.add(temp.getLeft());
                    queue.add(temp.getRight());
                }
            }
        }
        return sb.toString().substring(1);
    }

    public static void main(String[] args) {
        System.out.println(gatherScores(new int[]{4, 2, 5, 5, 6, 1, 4}));
        System.out.println(gatherScores(new int[]{7, 4, 2, 5, 5, 6, 1, 4}));
    }
}
