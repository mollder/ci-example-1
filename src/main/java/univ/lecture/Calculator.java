package univ.lecture;

import java.util.Stack;

/**
 * Calculator application
 */
public class Calculator{
	Stack<Object> stack;

	public Calculator() {
		stack = new Stack<Object>();
	}

	public String[] evalPrefix(String[] tokens) {
		int tokenSize = 0;
		String[] returnTokens = new String[tokens.length];
		
		for (int i = 0; (i < tokens.length) && (tokens[i] != null); i++) {
			if (tokens[i].equals("(")) {
				
			} else if (tokens[i].equals("*") || tokens[i].equals("-") || tokens[i].equals("+")
					|| tokens[i].equals("/")) {
				this.stack.push(tokens[i]);
			} else if (tokens[i].equals(")")) {
				returnTokens[tokenSize++] = (String) this.stack.pop();
			} else {
				returnTokens[tokenSize++] = tokens[i];
			}
		}
		while(!stack.isEmpty()) {
			returnTokens[tokenSize++] = (String) this.stack.pop();
		}
		return returnTokens;
	}

	public double calculate(String[] tokens) {
		String[] calTokens = evalPrefix(tokens);
		double firstOperand;
		double secondOperand;
		
		for (int i = 0; i < calTokens.length && (calTokens[i] != null); i++) {
			if (calTokens[i].equals("*")) {
				firstOperand = Double.parseDouble(this.stack.pop().toString());
				secondOperand = Double.parseDouble(this.stack.pop().toString());
				this.stack.push(firstOperand * secondOperand);
			} else if (calTokens[i].equals("+")) {
				firstOperand = Double.parseDouble(this.stack.pop().toString());
				secondOperand = Double.parseDouble(this.stack.pop().toString());
				this.stack.push(firstOperand + secondOperand);
			} else if (calTokens[i].equals("/")) {
				firstOperand = Double.parseDouble(this.stack.pop().toString());
				secondOperand = Double.parseDouble(this.stack.pop().toString());
				this.stack.push(secondOperand / firstOperand);
			} else if (calTokens[i].equals("-")) {
				firstOperand = Double.parseDouble(this.stack.pop().toString());
				secondOperand = Double.parseDouble(this.stack.pop().toString());
				this.stack.push(secondOperand - firstOperand);
			} else {
				this.stack.push((Object) calTokens[i]);
			}
		}
		return Double.parseDouble(this.stack.pop().toString());
	}
}