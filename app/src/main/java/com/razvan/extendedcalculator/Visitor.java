package com.razvan.extendedcalculator;

public interface Visitor {
	public double visit(OperatorNode e);
	public double visit(OperandNode e);
	public double visit(FunctionNode e);
}

/**
 * @author Razvan Cojocaru
 * Visitor of the Tree created by the ExpressionParser. 
 * Computes the value of the mathematical expression represented by the tree.
 * Uses an inorder traversal of the Tree.
 */
class Calculator implements Visitor {
	
	@Override
	public double visit(OperatorNode e) {
		
		if (e.getID().equals("+"))
			return e.getLeft().accept(this) + e.getRight().accept(this);
		else if (e.getID().equals("-"))
			return e.getLeft().accept(this) - e.getRight().accept(this);
		else if (e.getID().equals("*"))
			return e.getLeft().accept(this) * e.getRight().accept(this);
		else if (e.getID().equals("/")) {		
				double d = e.getRight().accept(this);
				if (d == 0) throw new EvaluatorException(EvaluatorException.DIV_ZERO);
				return e.getLeft().accept(this) / e.getRight().accept(this);
		}
		else if (e.getID().equals("^")) {
			return Math.pow(e.getLeft().accept(this), e.getRight().accept(this));
		}
		
		return 0;
	}

	@Override
	public double visit(OperandNode e) {
		return e.getValue();
	}

	@Override
	public double visit(FunctionNode e) {
		double argument = e.getLeft().accept(this);
		
		if (e.getID().equals("#"))
			e.setValue(-argument);
		else if (e.getID().equals("log")) {
			if ( argument < 0 ) throw new EvaluatorException(EvaluatorException.NEG_LOG);
			if ( argument == 0 ) throw new EvaluatorException(EvaluatorException.ZERO_LOG);
			e.setValue(Math.log10(argument));
		}
		else if (e.getID().equals("sqrt")){
			if ( argument < 0 ) throw new EvaluatorException(EvaluatorException.NEG_SQRT);
			e.setValue(Math.sqrt(argument));
		}
		else if (e.getID().equals("sin"))
			e.setValue(Math.sin(argument));
		else if (e.getID().equals("cos"))
			e.setValue(Math.cos(argument));
		
		return e.getValue();
	}
	
}
