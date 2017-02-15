package com.razvan.extendedcalculator;

import java.util.Stack;


/**
 * @author Razvan Cojocaru
 * 
 * Is used to compute the value of a mathematical expression, given as a String,
 * with its elements separated by one or more spaces.
 * Supports: +, -, *, /, ^, log, sin, cos, sqrt
 * Contains several private functions used to create the AST
 *
 */
public class ExpressionParser { 
	
	/**
	 * Method that evaluates the mathematical expression given as argument.
	 * Main method, the one that "does the magic"
	 * 
	 * @param expression			String containing a mathematical expression
	 * @return						Value of the expression
	 * @throws SyntacticException	Invalid string (wrong brackets, invalid symbol)
	 * @throws EvaluatorException	Invalid expression ( mathematical error )
	 */
	public float eval(String expression) throws SyntacticException, EvaluatorException{

		String[] elements = expression.split(" +");
		
		// Syntactic check
		// checks the brackets
		// checks for invalid characters
		// transforms the unary "-" in a "#" (because it is treated as a
			// function, not as an operator)
		
		Stack<Integer> s = new Stack<Integer>();
		if ( elements[0].equals("-") )
			elements[0] = "#";
		else if ( elements[0].equals("(") )
			s.push(1);

		for (int i=1; i < elements.length; i++) {
			if ( elements[i].equals("(") ) {
				s.push(1);
				continue;
			}
			if ( elements[i].equals(")") ) {
				s.pop();
				continue;
			}
			if ( (elements[i].equals("-")) && (elements[i-1].equals("(")) ) {
				elements[i] = "#";
				continue;
			}
			if ( (!elements[i].equals("+")) && (!elements[i].equals("-")) && 
				(!elements[i].equals("*")) && (!elements[i].equals("/")) &&
				(!elements[i].equals("^")) && (!elements[i].equals("log")) && 
				(!elements[i].equals("sqrt")) && (!elements[i].equals("sin")) && 
					(!elements[i].equals("cos")))
				try { 
					Float.parseFloat(elements[i]); 
				} catch(NumberFormatException e) { 
					throw new SyntacticException(); 					
				}
		}
		if ( s.size() != 0 )
			throw new SyntacticException();
	
		// Parsing the String and constructing the Tree
		Node nod = parse(elements);
		
		// Visitor
		Calculator calc = new Calculator();
		
		return (float)nod.accept(calc);
	}
	
	/**
	 * Method used by eval to create the Tree.
	 * 
	 * @param elements	array containing the tokenised expression String.
	 * @return			root of the created Tree
	 */
	private static Node parse(String[] elements) {
		//Result stack
		Stack<Node> sr = new Stack<Node>();
		//Operator stack
		Stack<Node> so = new Stack<Node>();
		
		double operand;
		Node nod;
		
		// For each of the elements, check if it is a constant, operator or
		//function, and act accordingly
		for (int i=0; i < elements.length; i++) {
			try {
				operand = Double.parseDouble(elements[i]);
				sr.push(new OperandNode(operand));
			} catch (NumberFormatException e) {
				if ( (elements[i].equals("log")) || (elements[i].equals("sqrt")) ||
						(elements[i].equals("sin")) || (elements[i].equals("cos")) ||
						(elements[i].equals("#")) ) {
					nod = new FunctionNode(elements[i]);
					so.push(nod);
				}
				else if ( elements[i].equals("(") ) {
					// The brackets are treated as an operator with 0 priority
					so.push(new OperatorNode(elements[i], 0, true));
				}
				else if ( elements[i].equals(")") ) {
					while ( !( so.peek().getID().equals("(") ) ) {
						Node operator = so.pop();
						Node rez1 = sr.pop();
						if ( operator instanceof FunctionNode ) {
							operator.setLeft(rez1);
						} else {
							Node rez2 = sr.pop();
							operator.setRight(rez1);
							operator.setLeft(rez2);
						}
						sr.push(operator); 
					}
					so.pop();
					if (!( so.empty() )) {
						while ( so.peek() instanceof FunctionNode ) {
							Node operator = so.pop();
							Node rez1 = sr.pop();
							operator.setLeft(rez1);
							sr.push(operator);
							if (so.empty()) break;
						}					
					}
				}
				else if ( (elements[i].equals("+")) || (elements[i].equals("-")) || 
						(elements[i].equals("*")) || (elements[i].equals("/")) ||
						(elements[i].equals("^")) ) {
					if ( elements[i].equals("^") )
						nod = new OperatorNode(elements[i], calculatePriority(elements[i]), false);
					else
						nod= new OperatorNode(elements[i], calculatePriority(elements[i]), true);
						
					while ( !(so.empty()) && (( nod.getPriority() < so.peek().getPriority() ) || 
						(( nod.getPriority() == so.peek().getPriority() ) && 
								( ((OperatorNode)nod).getAsoc() )))) {
						
						Node operator = so.pop();
						Node rez1 = sr.pop();
						if ( operator instanceof FunctionNode ) {
							operator.setLeft(rez1);
						} else {
							Node rez2 = sr.pop();
							operator.setRight(rez1);
							operator.setLeft(rez2);
						}
						sr.push(operator); 
						if (so.empty()) break;
					}
					so.push(nod);

				}
				
			}
		}
		
		// If the operator stack still has elements after the last element has
		//been parsed
		while ( !so.empty() ) {
			Node operator = so.pop();
			Node rez1 = sr.pop();
			if ( operator instanceof FunctionNode ) {
				operator.setLeft(rez1);
			} else {
				Node rez2 = sr.pop();
				operator.setRight(rez1);
				operator.setLeft(rez2);
			}
			sr.push(operator); 		
		}
		
		
		return sr.pop();
	}
	
	/**
	 * Method used by parse to compute a binary operator's priority
	 * @param str	operator ID
	 * @return		priority of the operator
	 */
	private static int calculatePriority(String str) {
		if (( str.equals("+") ) || ( str.equals("-") )) return 1;
		if (( str.equals("*") ) || ( str.equals("/") )) return 2;
		return 3;
	}
	
	public static void main(String[] args) {
		ExpressionParser e = new ExpressionParser();
		try {
			System.out.println(e.eval("sin ( 3.1415 ) "));
		} catch (Exception ex) {}
	}
	
}
