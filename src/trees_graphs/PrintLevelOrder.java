package trees_graphs;

import java.util.*;

   /*
Given a tree as below.

       a
    /  |  \
    b   d  f
  / |   \  |
 k  m   o  n
    \   /
    p  q

 print the tree in the order as output

 a
 f, d, b
 n, o, m, k
 q, p


 a
 b, d, f
 k, m, o, n
 p, q


 */

public class PrintLevelOrder {

    TreeNode root;

    class TreeNode {
        char value;
        List<TreeNode> childNodes = new ArrayList<TreeNode>();

        public TreeNode(char value) {
            this.value = value;
        }
    }

    void bfs(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<StringBuilder> list = new ArrayList<StringBuilder>();
        q.add(root);
        int currentLevel = 0, previousLevel = 1;
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            TreeNode nodePopped = q.poll();
            sb.append(nodePopped.value);
            previousLevel--;
            for (TreeNode child : nodePopped.childNodes) {
                q.add(child);
                currentLevel++;
            }
            if (previousLevel == 0) {
                System.out.println(sb.reverse().toString());
                sb = new StringBuilder();
                previousLevel = currentLevel;
                currentLevel = 0;
            }
        }
    }

    public PrintLevelOrder() {
        root = new TreeNode('a');
        TreeNode b = new TreeNode('b');
        TreeNode d = new TreeNode('d');
        TreeNode f = new TreeNode('f');
        root.childNodes = Arrays.asList(b, d, f);
        b.childNodes = Arrays.asList(new TreeNode('k'), new TreeNode('m'));
        d.childNodes = Arrays.asList(new TreeNode('o'));
        f.childNodes = Arrays.asList(new TreeNode('n'));
    }

    public static void main(String[] args) {
        PrintLevelOrder obj = new PrintLevelOrder();
        obj.bfs(obj.root);
    }

}
