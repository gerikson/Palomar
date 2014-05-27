// ObjectTreeNode.java

public class ObjectTreeNode implements ObjectTreeNodeInterface {
    private Object info;
    private ObjectTreeNode left;
    private ObjectTreeNode right;
    
    public ObjectTreeNode() {
        info = null;
        left = null;
        right = null;
    }
    
    public ObjectTreeNode (Object o) {
        info = o;
        left = null;
        right = null;
    }
    
    public void setInfo(Object o) {
        info = o;
    }
    
    public Object getInfo() {
        return info;
    }
    
    public void setLeft(ObjectTreeNode p) {
        left = p;
    }
    
    public ObjectTreeNode getLeft() {
        return left;
    }
    
    public void setRight(ObjectTreeNode p) {
        right = p;
    }
    
    public ObjectTreeNode getRight() {
        return right;
    }
}
