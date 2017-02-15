package com.razvan.extendedcalculator;

/**
 * @author Razvan Cojocaru
 * Node containing a constant.
 */
public class OperandNode extends Node {
	
	public OperandNode(double value) {
		this.setValue(value);
	}

	@Override
	public double accept(Visitor v) {
		return v.visit(this);		
	}
	
}
