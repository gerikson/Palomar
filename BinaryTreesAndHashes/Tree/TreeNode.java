// TreeNode.java

public class TreeNode {
    private int info;
    private TreeNode left;
    private TreeNode right;
    
    public TreeNode() {
        info = 0;
        left = null;
        right = null;
    }
    
    public TreeNode (int i) {
        info = i;
        left = null;
        right = null;
    }
    
    public void setInfo(int i) {
        info = i;
    }
    
    public int getInfo() {
        return info;
    }
    
    public void setLeft(TreeNode p) {
        left = p;
    }
    
    public TreeNode getLeft() {
        return left;
    }
    
    public void setRight(TreeNode p) {
        right = p;
    }
    
    public TreeNode getRight() {
        return right;
    }
}
