package com.razvan.extendedcalculator;

public interface Visitable {
	public double accept(Visitor v);
}
