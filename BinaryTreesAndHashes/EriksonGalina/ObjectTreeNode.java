/**
 * ObjecTreeNode class
 * ObjectTreeNode.java
 * Properties: list, last
 * @author Galina Erikson (Palomar ID 009280295)
 * @version 1.1 - May 7th, 2014
 *
 */
public class ObjectTreeNode implements ObjectTreeNodeInterface{
    private Object info;
    private ObjectTreeNode left;
    private ObjectTreeNode right;
    
    /**
     * Class constructor
     */
    public ObjectTreeNode() {
        info = null;
        left = null;
        right = null;
    }
    
    /**
     * Class constuctor
     * @param o
     */
    public ObjectTreeNode (Object o) {
        info = o;
        left = null;
        right = null;
    }
    
    /**
     * Sets info
     * @param o
     */
    public void setInfo(Object o) {
        info = o;
    }
    
    /**
     * Gets info
     * @return
     */
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
