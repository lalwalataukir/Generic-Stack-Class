public class MyStack implements StackInterface 
{
	// initializing Object array with size 1
	public Object[] stack = new Object[1];

	// stack_size = stack_top_index + 1
	public int stack_top_index = -1; 
	
	// if stack_top_index==-1, stack_size=0, therefore empty
	public boolean isEmpty() 
	{
		return (stack_top_index == -1);
	}

	// returns stack from top element to bottom element as a string
	public String toString() 
	{
		String retString = "[";
		// tranverse from top element to bottom element
		for (int i = stack_top_index; i >= 0; i--) 
		{
			if (i != 0) {
				retString = retString + stack[i] + ", ";
			} else

			{
				retString = retString + stack[i];
			}
		}
		retString = retString + "]";
		return retString;
	}

	public void push(Object element) 
	{
		// null is not supposed to be pushed
		if (element == null) 
		{
			return;
		} 
		else 
		{
			// if array full, double array size and copy old array elements to new double sized array
			if (stack_top_index == stack.length - 1) 
			{
				// store old array size
				int old_stack_length = stack_top_index + 1;

				// store old array
				Object[] old_stack = new Object[old_stack_length]; 
				for (int i = 0; i < old_stack_length; i++) {
					old_stack[i] = stack[i];
				}

				// initialize new array of double the size of old array
				stack = new Object[2 * old_stack_length];

				// copying elements of old array
				for (int i = 0; i < old_stack_length; i++) 
				{
					stack[i] = old_stack[i];
				}

				// normal push operation
				stack_top_index++;
				stack[stack_top_index] = element;
			} 
			else // array not full, normal push operation
			{
				stack_top_index++;
				stack[stack_top_index] = element;
			}
		}
	}

	public Object pop() throws EmptyStackException {
		Object stack_top_element;
		if (this.isEmpty()) // throw exception for empty stack
		{
			throw new EmptyStackException();
		} 
		else // normal pop operation
		{
			stack_top_element = stack[stack_top_index];
			stack_top_index--;
		}
		return stack_top_element;
	}

	public Object top() throws EmptyStackException {
		Object stack_top_element;
		if (this.isEmpty()) // throw exception for empty stack
		{
			throw new EmptyStackException();
		} 
		else // normal top operation
		{
			stack_top_element = stack[stack_top_index];
		}
		return stack_top_element;
	}
}