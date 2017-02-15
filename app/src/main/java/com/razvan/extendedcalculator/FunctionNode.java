package com.razvan.extendedcalculator;

/**
 * @author Razvan Cojocaru
 * Node containing an unary operator
 */
public class FunctionNode extends Node {

	public FunctionNode(String ID) {
		this.ID = ID;
		this.priority = 10;
		this.setValue(0);
	}

	@Override
	public double accept(Visitor v) {
		return v.visit(this);
	}
}