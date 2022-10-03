// exception for top/pop operation on empty stack
class EmptyStackException extends Exception {
	public EmptyStackException() {

	}
}

// exception for invalid postfix expression
class InvalidPostfixException extends Exception {
	public InvalidPostfixException() {

	}
}

// exception for invalid infix expression
class InvalidExprException extends Exception {
	public InvalidExprException() {

	}
}

// stack interface provided
public interface StackInterface {
	public void push(Object o);
	public Object pop() throws EmptyStackException;
	public Object top() throws EmptyStackException;
	public boolean isEmpty();
	public String toString();
}


