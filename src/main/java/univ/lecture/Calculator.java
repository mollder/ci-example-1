package univ.lecture;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Calculator application
 */
public class Calculator{
	Deque<Object> deque;

	public Calculator() {
		deque = new ArrayDeque<Object>(10);
	}

	public String[] evalPrefix(String[] tokens) {
		int tokenSize = 0;
		String[] returnTokens = new String[tokens.length];
		
		for (int i = 0; (i < tokens.length) && (tokens[i] != null); i++) {
			if (tokens[i].equals("(")) {
				
			} else if (tokens[i].equals("*") || tokens[i].equals("-") || tokens[i].equals("+")
					|| tokens[i].equals("/")) {
				this.deque.push(tokens[i]);
			} else if (tokens[i].equals(")")) {
				returnTokens[tokenSize++] = (String) this.deque.pop();
			} else {
				returnTokens[tokenSize++] = tokens[i];
			}
		}
		while(!deque.isEmpty()) {
			returnTokens[tokenSize++] = (String) this.deque.pop();
		}
		return returnTokens;
	}

	public double calculate(String[] tokens) {
		tokens = evalPrefix(tokens);
		double firstOperand;
		double secondOperand;
		
		for (int i = 0; i < tokens.length && (tokens[i] != null); i++) {
			if (tokens[i].equals("*")) {
				firstOperand = Double.parseDouble(this.deque.pop().toString());
				secondOperand = Double.parseDouble(this.deque.pop().toString());
				this.deque.push(firstOperand * secondOperand);
			} else if (tokens[i].equals("+")) {
				firstOperand = Double.parseDouble(this.deque.pop().toString());
				secondOperand = Double.parseDouble(this.deque.pop().toString());
				this.deque.push(firstOperand + secondOperand);
			} else if (tokens[i].equals("/")) {
				firstOperand = Double.parseDouble(this.deque.pop().toString());
				secondOperand = Double.parseDouble(this.deque.pop().toString());
				this.deque.push(secondOperand / firstOperand);
			} else if (tokens[i].equals("-")) {
				firstOperand = Double.parseDouble(this.deque.pop().toString());
				secondOperand = Double.parseDouble(this.deque.pop().toString());
				this.deque.push(secondOperand - firstOperand);
			} else {
				this.deque.push((Object) tokens[i]);
			}
		}
		return Double.parseDouble(this.deque.pop().toString());
	}
}