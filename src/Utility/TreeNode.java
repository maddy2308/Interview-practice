package Utility;


public class TreeNode {
    private TreeNode parent;
    private TreeNode leftChildNode;
    private TreeNode rightChildNode;
    private Object data;

    public TreeNode(TreeNode parent, TreeNode leftChildNode, TreeNode rightChildNode, Object data) {
        super();
        this.parent = parent;
        this.leftChildNode = leftChildNode;
        this.rightChildNode = rightChildNode;
        this.data = data;
    }


    public TreeNode getParent() {
        return parent;
    }


    public void setParent(TreeNode parent) {
        this.parent = parent;
    }


    public TreeNode getLeftChildNode() {
        return leftChildNode;
    }

    public void setLeftChildNode(TreeNode leftChildNode) {
        this.leftChildNode = leftChildNode;
    }

    public TreeNode getRightChildNode() {
        return rightChildNode;
    }

    public void setRightChildNode(TreeNode rightChildNode) {
        this.rightChildNode = rightChildNode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}