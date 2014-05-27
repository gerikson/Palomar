/**
 * ObjectListNode class
 * ObjectListNode.java
 * Properties: info, next
 * @author Galina Erikson (Palomar ID 009280295)
 * @version 1.1 - April 9th, 2014
 *
 */


public class ObjectListNode {
    private Object info;
    private ObjectListNode next;
    
    /**
     *  Default ctor    
     */
    public ObjectListNode() {
        info = null;
        next = null;
    }

    /**
     *  One-arg ctor
     * @param object
     */
    public ObjectListNode (Object o) {
        info = o;
        next = null;
    }    
    
    /**
     *  Two-arg ctor
     * @param object
     * @param ObjectListNode
     */
    public ObjectListNode (Object o, ObjectListNode p) {
        info = o;
        next = p;
    }       

    /**
     * Sets info field
     * @param object
     */
    public void setInfo(Object o) {
        info = o;
    }    

    /**
     *  Returns object in info field
     * @return Object
     */
    public Object getInfo() {
        return info;
    }

    /**
     * Sets next field
     * @param ObjectListNode
     */
    public void setNext(ObjectListNode p) {
        next = p;
    }

    /**
     *  Returns object in info field
     * @return ObjectListNode
     */
    public ObjectListNode getNext() {
        return next;
    }
}
