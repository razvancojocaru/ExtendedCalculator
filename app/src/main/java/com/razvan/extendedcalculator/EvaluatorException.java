package com.razvan.extendedcalculator;

public class EvaluatorException extends RuntimeException {

	private static final long serialVersionUID = 5729607299984502799L;

	public static String DIV_ZERO = "division by zero";
	public static String NEG_SQRT = "negative value passed to square root";
	public static String NEG_LOG = "negative value passed to logarithm";
	public static String ZERO_LOG = "expression under logarithm evaluates to zero";
	
	public EvaluatorException(String s) {
		super(s);
	}
}
