// BinaryTree.java

public class BinaryTree {
    private TreeNode root;
    
    public BinaryTree() {
        root = null;
    }
    
    public TreeNode getRoot() {
        return root;
    }
    
    public void setLeftChild(TreeNode parent, TreeNode r) {
        if (parent == null || parent.getLeft() != null) {
            System.out.println("Runtime Error: setLeftChild()");
            System.exit(1);
        }
        parent.setLeft(r);
    }
    
    public void setRightChild(TreeNode parent, TreeNode r) {
        if (parent == null || parent.getRight() != null) {
            System.out.println("Runtime Error: setRightChild()");
            System.exit(1);
        }
        parent.setRight(r);
    }
                                       
    public void insertBST(int i) {
        TreeNode p, q;
        TreeNode r = new TreeNode(i);
        if (root == null)
            root = r;
        else {
            p = root;
            q = root;
            while (q != null) {
                p = q;
                if (r.getInfo() < p.getInfo())
                    q = p.getLeft();
                else
                    q = p.getRight();
            }
            if (r.getInfo() < p.getInfo())
                setLeftChild(p, r);
            else
                setRightChild(p, r);
        }
    }
    
    public TreeNode searchBST(int i) {
        TreeNode p;
                
        if(root != null) {
            p = root;
            while (p != null) {
                if (i < p.getInfo())
                    p = p.getLeft();
                else if (i > p.getInfo())
                    p = p.getRight();
                else
                    return p;
            }
        }
        return null;
    }
    
    public void preTrav(TreeNode tree) {
        if (tree != null) {
            System.out.println(tree.getInfo());
            preTrav(tree.getLeft());
            preTrav(tree.getRight());
        }
    }
        
    public void inTrav(TreeNode tree) {
        if (tree != null) {
            inTrav(tree.getLeft());
            System.out.println(tree.getInfo());
            inTrav(tree.getRight());
        }
    }
                               
    public void postTrav(TreeNode tree) {
        if (tree != null) {
            postTrav(tree.getLeft());
            postTrav(tree.getRight());
            System.out.println(tree.getInfo());
        }
    }
 }
                               
