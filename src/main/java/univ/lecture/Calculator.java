package univ.lecture;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Calculator application
 */
public class Calculator{
	Deque<Object> deque;

	public Calculator() {
		deque = new ArrayDeque<Object>();
	}

	public String[] evalPrefix(String[] tokens) {
		int tokenSize = 0;
		String[] returnTokens = new String[tokens.length];
		
		for (int i = 0; (i < tokens.length) && (tokens[i] != null); i++) {
			if ("(".equals(tokens[i])) {
				
			} else if ("*".equals(tokens[i]) || "-".equals(tokens[i]) || "+".equals(tokens[i])
					|| "/".equals(tokens[i])) {
				this.deque.push(tokens[i]);
			} else if (")".equals(tokens[i])) {
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
		String[] calTokens = evalPrefix(tokens);
		double firstOperand;
		double secondOperand;
		
		for (int i = 0; i < calTokens.length && (calTokens[i] != null); i++) {
			if ("*".equals(calTokens[i])) {
				firstOperand = Double.parseDouble(this.deque.pop().toString());
				secondOperand = Double.parseDouble(this.deque.pop().toString());
				this.deque.push(firstOperand * secondOperand);
			} else if ("+".equals(calTokens[i])) {
				firstOperand = Double.parseDouble(this.deque.pop().toString());
				secondOperand = Double.parseDouble(this.deque.pop().toString());
				this.deque.push(firstOperand + secondOperand);
			} else if ("/".equals(calTokens[i])) {
				firstOperand = Double.parseDouble(this.deque.pop().toString());
				secondOperand = Double.parseDouble(this.deque.pop().toString());
				this.deque.push(secondOperand / firstOperand);
			} else if ("-".equals(calTokens[i])) {
				firstOperand = Double.parseDouble(this.deque.pop().toString());
				secondOperand = Double.parseDouble(this.deque.pop().toString());
				this.deque.push(secondOperand - firstOperand);
			} else {
				this.deque.push((Object) calTokens[i]);
			}
		}
		return Double.parseDouble(this.deque.pop().toString());
	}
}
