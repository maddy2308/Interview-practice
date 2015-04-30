package trees_graphs;

import Utility.TreeNode;

import java.util.Arrays;
import java.util.Stack;

public class TernaryExpressionToBinaryTree {
    public static void main(String[] args) {
        TernaryExpressionToBinaryTree obj = new TernaryExpressionToBinaryTree();
        TreeNode parent = obj.parseExpression("a?b:c?d?e:f?h?l:m:i:g?j:k");
        //a?b:c?d:e
        //System.out.println("this is parent");
        //System.out.println(parent);
        //levelOrderPrint(parent);
        displayTree(parent);
    }

    private TreeNode parseExpression(String expression) {
        // It is assumed that the input has been checked for validity. No invalid input checks are implemented
        // The parsing is done considering the value left of question mark as statement right of question mark as values
        // check the existance of first question mark
        int questionIndex, colonIndex;
        questionIndex = expression.indexOf("?");
        if (questionIndex == -1) {
            System.out.println("value " + expression);
            return new TreeNode(null, null, null, expression);
        } else {
            String statement = expression.substring(0, questionIndex);
            String values = expression.substring(questionIndex + 1);
            colonIndex = getcorrectcolonindex(values, 0);
            String left = values.substring(0, colonIndex);
            String right = values.substring(colonIndex + 1);
            System.out.println("statement " + statement + " left " + left + " right " + right);
            return new TreeNode(parseExpression(statement), parseExpression(left), parseExpression(right), statement);
        }
    }

    private int getcorrectcolonindex(String expression, int colonnumber) {
        int questionIndex, colonIndex, questioncount;
        System.out.println(colonnumber + " " + expression);
        colonIndex = expression.indexOf(":");
        if (colonIndex > -1) {
            String substr = expression.substring(colonIndex + 1);
            System.out.println(substr);
            while (colonnumber > 0) {
                colonIndex = colonIndex + substr.indexOf(":") + 1;
                substr = expression.substring(colonIndex + 1);
                colonnumber = colonnumber - 1;
            }
            questioncount = 0;
            substr = expression.substring(0, colonIndex);
            questionIndex = substr.indexOf("?");
            while (questionIndex > -1) {
                questioncount = questioncount + 1;
                substr = substr.substring(questionIndex + 1);
                questionIndex = substr.indexOf("?");
            }
            System.out.println(questioncount + " " + colonIndex);
            if (questioncount == 0) {
                return colonIndex;
            } else {
                return colonIndex + getcorrectcolonindex(expression.substring(colonIndex + 1), questioncount - 1) + 1;
            }
        } else {
            return colonIndex;
        }
    }

    public static void displayTree(TreeNode root) {
        Stack<TreeNode> globalStack = new Stack<TreeNode>();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println(
                "......................................................");
        while (!isRowEmpty) {
            Stack<TreeNode> localStack = new Stack<TreeNode>();
            isRowEmpty = true;

            for (int j = 0; j < nBlanks; j++)
                System.out.print(' ');

            while (!globalStack.isEmpty()) {
                TreeNode temp = globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.getData());
                    localStack.push(temp.getLeftChildNode());
                    localStack.push(temp.getRightChildNode());

                    if (temp.getLeftChildNode() != null ||
                            temp.getRightChildNode() != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++)
                    System.out.print(' ');
            }  // end while globalStack not empty
            System.out.println();
            nBlanks /= 2;
            while (!localStack.isEmpty())
                globalStack.push(localStack.pop());
        }  // end while isRowEmpty is false
        System.out.println(
                "......................................................");
    }  // end displayTree()
    ////
}
