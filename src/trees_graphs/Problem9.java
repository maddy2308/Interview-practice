package trees_graphs;

import Utility.BinaryTree;
import Utility.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem9 {
    public static void main(String[] args) {
        Problem9 obj = new Problem9();
        obj.findPathsThatHaveSum(new BinaryTree(), 7);
    }

    private void findPathsThatHaveSum(BinaryTree t, int sum) {
        List<Integer> list = new ArrayList<Integer>();
        dfs(BinaryTree.root, list, sum, 0);
    }

    private void dfs(TreeNode node, List<Integer> list, int sum, int level) {
        if (node == null) {
            return;
        } else {
            list.add(level, (Integer) node.getData());
            checkIfPathPossible(list, sum);
            dfs(node.getLeftChildNode(), list, sum, level + 1);
            dfs(node.getRightChildNode(), list, sum, level + 1);
            list.remove(level);
        }
    }

    private void checkIfPathPossible(List<Integer> list, int sum) {
        for (int index = list.size() - 1; index >= 0; index--) {
            sum -= list.get(index);
            if (sum == 0) {
                for (int i = index; i <= list.size() - 1; i++) {
                    System.out.print(list.get(i) + " ");
                }
                System.out.println();
            }
        }
    }

}
