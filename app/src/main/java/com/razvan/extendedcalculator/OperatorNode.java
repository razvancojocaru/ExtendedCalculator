package com.razvan.extendedcalculator;

/**
 * @author Razvan Cojocaru
 * Node containing a binary operator
 */
public class OperatorNode extends Node {
	// left-asociative = true
	// right-asociative = false
	private boolean asoc;
	
	public OperatorNode(String ID, int priority, boolean asoc) {
		this.ID = ID;
		this.priority = priority;
		this.setValue(0);
		this.asoc = asoc;
	}

	/**
	 * @return	Asociativity of an operator (true - left, false - right)
	 */
	public boolean getAsoc() {
		return asoc;
	}
	
	@Override
	public double accept(Visitor v) {
		return v.visit(this);
	}	

}
