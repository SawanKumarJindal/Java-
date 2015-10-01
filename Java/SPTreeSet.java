/*
 * SpTreeSet.java
 *
 * Version: 1.0
 *     $Id$
 *
 * Revisions:
 *     $Log$
 */

import java.util.Iterator;
import java.util.TreeSet;

/*
 * This Program is to implement our own TreeSet.
 * 
 * @author      Sawan
 * @author      Prateek
 *
 /*
 
 /*
 * This class is the primary class which will create node and store value.
 */

class Node {
    Node left =  null;
    Node right = null;
    int evalue;
    Node(String value){
	this.evalue = Integer.parseInt(value);
    }  
}

/*
 * The class is the main TreeSet class which will override all the functions of 
 * the TreeSet and also will implement the functions of Iterator interface and override them. 
 */

public class SPTreeSet extends TreeSet implements Iterator {
    Node root;                           
    boolean trueOrFlase ;               
    private static int size=0;             
    int[] a;                               
    int position=0;
    int iteratorIndex=0;                   
    
    /**
     * This add function adds each element to the TreeSet in the form of a binary tree.
     * 
     */	
    
    public  boolean add(Object e) {
	String evalue = (String)e;                                      
	Node newNode = new Node(evalue);                                
	// This condition will check if the value of root is null. If yes then it will assign the value to the RootNode.                                                              
	if (root == null) {
	    root = newNode;
	    size++;
	} else {
	    Node addingNode = root;                                 
	    Node parent;
	    while (true) {
		parent = addingNode;
		// This condition checks the value of node to be added with the parent node and will assign the value as its right child or left child. 
		if (Integer.parseInt(evalue) < addingNode.evalue) {    
		    addingNode = addingNode.left;                      
		    if (addingNode == null) {                          
			parent.left = newNode;                         
			size++;                                        
			return true; 
		    }
		} else { 
		    if(Integer.parseInt(evalue)!= addingNode.evalue){  
			addingNode = addingNode.right;                   
			if (addingNode == null) {					    
			    parent.right = newNode; 					    
			    size++;                                   
			    return true; 
			}
		    }
		    else{                                          
			return false;                              
		    }
		}
	    }
	}
	return true;
    }
    
    /**
     * This function will check if the TreeSet is empty or not
     */	
    
    public boolean isEmpty(){
	if( size ==0){                    
	    return true;
	}
        return false;
    }
    
    /**
     * This function will find the size of TreeSet
     * 
     */	
    
    public int size(){
	return size;
    }
    
    /**
     * This function will clear the TreeSet
     */	
    
    public void clear(){
	size = 0;                          
	root= null;                        
    }
    
    /**
     * This function will check whether a particular element is in the TreeSet or Not.
     */
    
    public boolean contains(Object o){                                
	String contain = (String)o;
	trueOrFlase = false;
	isConatinValue( root, contain );                               
	return trueOrFlase;
    }
    
    /**
     * This function will process that checking-node with the present node and compare the values.
     * If yes then it will return true or it will compare other values.
     *
     */
    
    public void isConatinValue( Node root, String contain){
	// This condition will check whether the root value is null or not.
	if( root == null){                
	    trueOrFlase =false;
	}
	else{
	    // This condition will determine whether the value of root matches with the root.
	    if( root.evalue == Integer.parseInt(contain)){
		trueOrFlase =true;	  
	    }
	    else{
		// This condition will evaluate the value value of checking node with the root node 
		// and determine whether it should proceed with left side or right side.
		if (root.evalue < Integer.parseInt(contain )){
		    isConatinValue(root.right, contain);                
		}
		else{
		    isConatinValue(root.left, contain);                 
		}
	    }
	}
    }
    
    /**
     * This function  will iterate to the elements of TreeSet.
     */
    
    public Iterator  iterator(){
	a = new int[size];
	iteratorIndex = 0;
	Iterator iterator = this;
	if(size != 0){
	    a = traverseTree(root);                             
	}
	return iterator;
    }
    
    /**
     * This function will store the binary tree values in the array so as to iterate it.
     * IN-ORDER-TRAVERSING
     */
    
    public int[] traverseTree(Node addingNode) {
	if (addingNode != null) {
	    traverseTree(addingNode.left);                       
	    a[position]=addingNode.evalue;			             
	    position++;
	    traverseTree(addingNode.right);			             
	}
	return a;	                                             
    }
    
    /*
     * This is the overridden function hasNext of iterator interface which will check 
     * whether there are more elements after the checking node or not.
     */
    @Override
	public boolean hasNext() {
	if(iteratorIndex < a.length){                            
	    return true;
	}
	else {
	    return false;
	}
    }
    /*
     * This is the overridden function Next of iterator interface which will return 
     * the array containing the elements after it.
     */
    @Override
	public Object next() {	
	return a[iteratorIndex++];                            
    }
    
    @Override
	public void remove() {
	
    }
}


