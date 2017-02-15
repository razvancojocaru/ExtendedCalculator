package com.razvan.extendedcalculator;

/**
 * @author Razvan Cojocaru
 * Basic Node used in the Tree, parent of Operand/Operator specialized nodes.
 * Contains getter/setter methods for children, priority, ID and value
 */
public abstract class Node implements Visitable {
	protected Node left;
	protected Node right;
	
	protected int priority;
	protected String ID;
	private double value;
	
	/**
	 * Setter for the operator priority
	 * @param p		integer priority
	 */
	public void setPriority(int p) {
		this.priority = p;
	}
	
	/**
	 * Getter for the operator priority
	 * @return	integer priority
	 */
	public int getPriority() {
		return this.priority;
	}
	
	/**
	 * Setter for the operator ID ("+", "log", etc.)
	 * @param ID	String containing the ID
	 */
	public void setID(String ID) {
		this.ID = ID;
	}
	
	/**
	 * Getter for the operator ID
	 * @return	String containing the ID
	 */
	public String getID() {
		return this.ID;
	}
	
	/**
	 * Setter for the left child
	 * @param n
	 */
	public void setLeft(Node n) {
		this.left = n;
	}
	
	/**
	 * Setter for the right child
	 * @param n
	 */
	public void setRight(Node n) {
		this.right = n;
	}
	
	/**
	 * Getter for the left child
	 * @return
	 */
	public Node getLeft() {
		return left;
	}
	
	/**
	 * Getter for the left child
	 * @return
	 */
	public Node getRight() {
		return right;
	}
	
	/**
	 * Set the value of a constant
	 * Default for operators is 0
	 * @param value
	 */
	public void setValue(double value) {
		this.value = value;
	}
	
	/**
	 * @return	The value of an OperandNode
	 */
	public double getValue() {
		return this.value;
	}
	
}
