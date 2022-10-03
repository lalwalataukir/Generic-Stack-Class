class Input_array_of_strings_of_string_for_postfix_evaluation {
    private int num_ops(String s) { // calculate number of operators and operands 
        int string_length = s.length();
        String temp_string = ""; // temporary string to store the operands with more than 1 digits or operator
        int number_of_operators_and_operands = 0;
        for (int i = 0; i < string_length; i++) {
            if (s.charAt(i) != ' ') {
                temp_string = temp_string + s.substring(i, i + 1);
            } else {
                if (temp_string.equals("")) {
                    continue;
                } else {
                    number_of_operators_and_operands++; // increment for operator/operand
                    temp_string = "";
                }
            }
        }
        
        if (temp_string.equals("")==false) // case when the input string has integer at the last index and temp_string still has the last operand
        {
            number_of_operators_and_operands++; // increment for operator/operand
        }
        
        return number_of_operators_and_operands;
    }

    private String[] s_to_arr(String s, int number_of_operators_and_operands) {
        String[] array_of_strings = new String[number_of_operators_and_operands]; // array to be returned
        int string_length = s.length();
        String temp_string = ""; 
        int c = 0;
        for (int i = 0; i < string_length; i++) {
            if (s.charAt(i) != ' ') {
                temp_string = temp_string + s.substring(i, i + 1);
            } else {
                if (temp_string.equals("")) {
                    continue;
                } else {
                    array_of_strings[c] = temp_string; // insert the temp_string that is a string form of operator or operand
                    c++;
                    temp_string = "";
                }
            }
        }

        if (temp_string.equals("")==false) // case when the input string has integer at the last index and temp_string still has the last operand
        {
            array_of_strings[c] = temp_string; // insert the temp_string that is a string form of operator or operand
        }

        return array_of_strings;
    }

    public String[] convert(String s) {
        int number_of_operators_and_operands = num_ops(s);
        String[] array_of_strings = s_to_arr(s, number_of_operators_and_operands);
        return array_of_strings;
    }

}

/****************************************************************************************************/

class String_to_integer {

    public int convert(String str) { // convert str to integer
        int temp_int = 0;
        int power_of_ten = 1;
        for (int i = str.length() - 1; i >= 0; i--) { // start from last index and keep appending the integers to temp_int by multiplying with appropriate power of ten
            temp_int = temp_int + ((int) str.charAt(i) - (int) '0') * power_of_ten;
            power_of_ten = power_of_ten * 10;
        }
        return temp_int;

    }
}

/****************************************************************************************************/

class Input_array_of_strings_of_string_for_expression_conversion {
    private int num_ops(String s) { // calculate number of operators and operands 
        int number_of_operators_and_operands = 0;
        int string_length = s.length();
        int c = 0;
        String temp_string = ""; // temporary string to store the operands with more than 1 digits
        for (int i = 0; i < string_length; i++)
        {
            if (s.charAt(i) != ' ' && s.charAt(i) != '+' && s.charAt(i) != '-' && s.charAt(i) != '*'
                    && s.charAt(i) != '(' && s.charAt(i) != ')') 
            {
                temp_string = temp_string + s.substring(i, i + 1); // appending the digits of operand
            } 
            else if (s.charAt(i) == ' ') {
                if (temp_string.equals("")) {
                    continue;
                } else {
                    number_of_operators_and_operands++; // increcent for operand
                    c++;
                    temp_string = "";
                }
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '('
                    || s.charAt(i) == ')') {
                if (temp_string.equals("")) {
                    number_of_operators_and_operands++; // increment for operator
                    c++;
                } else {
                    number_of_operators_and_operands++; // increment for operand
                    c++;
                    temp_string = "";
                    number_of_operators_and_operands++; // increment for operator
                    c++;
                }
            }

        }
        if (temp_string.equals("")==false) // case when the input string has integer at the last index and temp_string still has the last operand
        {
            number_of_operators_and_operands++; // increment for operator
        }
        return number_of_operators_and_operands;
    }

    private String[] s_to_arr(String s, int number_of_operators_and_operands) {
        String[] array_of_strings = new String[number_of_operators_and_operands]; // array to be returned
        int string_length = s.length();
        int c = 0;
        String temp_string = ""; // temporary string to store the operands with more than 1 digits
        for (int i = 0; i < string_length; i++)
        {
            if (s.charAt(i) != ' ' && s.charAt(i) != '+' && s.charAt(i) != '-' && s.charAt(i) != '*'
                    && s.charAt(i) != '(' && s.charAt(i) != ')') {
                temp_string = temp_string + s.substring(i, i + 1);
            } else if (s.charAt(i) == ' ') {
                if (temp_string.equals("")) {
                    continue;
                } else {
                    array_of_strings[c] = temp_string; // insert the temp_string that is a string form of operand
                    c++;
                    temp_string = "";
                }
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*' || s.charAt(i) == '('
                    || s.charAt(i) == ')') {
                if (temp_string.equals("")) {
                    array_of_strings[c] = s.substring(i, i + 1); // insert the temp_string that is a string form of operand
                    c++;
                } else {
                    array_of_strings[c] = temp_string; // insert the temp_string that is a string form of operand
                    c++;
                    temp_string = "";
                    array_of_strings[c] = s.substring(i, i + 1); // insert the temp_string that is a string form of operand
                    c++;
                }
            }

        }

        if (temp_string.equals("")==false) // case when the input string has integer at the last index and temp_string still has the last operand
        {
            array_of_strings[c] = temp_string; // insert the temp_string that is a string form of operand
        }
        return array_of_strings;
    }

    public String[] convert(String s) {
        int number_of_operators_and_operands = num_ops(s);
        String[] array_of_strings = s_to_arr(s, number_of_operators_and_operands);
        return array_of_strings;
    }

}

/****************************************************************************************************/

class isInteger
{
    public Boolean check(String i) // to check if a given string represents an integer or not
    {
        Boolean ans = true;
        if(i.equals("+")==false && i.equals("-")==false && i.equals("*")==false && i.equals("(")==false && i.equals(")")==false)
        {
            ans = true;
        }
        else 
        {
            ans = false;
        }
        return ans;
    }
}

/*****************************************************************************************************/

public class Calculator {
    public int evaluatePostFix(String s) throws InvalidPostfixException {

        for (int i = 0; i < s.length() - 1; i++) // all the operators and operands should be separated by atleast 1 whitespace (given in problem statement)
        {
            if ((s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*') && s.charAt(i + 1) != ' ') {
                throw new InvalidPostfixException();
            }
        }

        // convert input string s to array of string with every operator and operand as different strings
        Input_array_of_strings_of_string_for_postfix_evaluation obj1 = new Input_array_of_strings_of_string_for_postfix_evaluation();
        String[] array_of_strings = obj1.convert(s);

        // create s2i object to convert string to integer
        String_to_integer s2i = new String_to_integer();

        MyStack S = new MyStack(); // instantiate the stack

        for (int i = 0; i < array_of_strings.length; i++) {
            String str = array_of_strings[i];
            if (str.equals("+") == false && str.equals("*") == false && str.equals("-") == false) // if str in operand then convert to integer and push in stack
            {
                int temp = s2i.convert(str);
                S.push(temp);
            } else // if str is operator
            {
                int top = 0, prevtop = 0; // take topmost and element just below the topmost element
                // top element and element below top element are required for operator to operate on them otherwise its invalid postfix expression
                try {
                    top = (int) S.pop();
                } catch (Exception e) {
                    throw new InvalidPostfixException(); // if top element in stack is not available on which the operator inhand should operate then its invalid postfix expression
                }
                try {
                    prevtop = (int) S.pop();
                } catch (Exception e) {
                    throw new InvalidPostfixException(); // if element below the top element in stack is not available on which the operator inhand should operate then its invalid postfix expression
                }

                // operator works on top and prevtop elements and push the result back in stack
                if (str.equals("+")) {
                    S.push(top + prevtop);
                } else if (str.equals("-")) {
                    S.push(prevtop - top);
                } else {
                    S.push(prevtop * top);
                }
            }
        }

        int stack_size = S.stack_top_index + 1;
        if (stack_size >= 2) //  case when there are more than or equal to 2 integers till left in stack, case like input "23 34" where there is no operator but only operands given in input string
        {
            throw new InvalidPostfixException();
        }
        // incase less than 2 elements left in stack
        int answer = 0;
        try {
            answer = (int) S.top();
        } catch (Exception e) // in case the input string is empty then the stack would be empty therefore there is not answer and invalid postfix expression
        {
            throw new InvalidPostfixException();
        }
        return answer;
    }

    public String convertExpression(String s) throws InvalidExprException {

        // convert input string s to array of string with every operator and operand as different strings
        Input_array_of_strings_of_string_for_expression_conversion obj1 = new Input_array_of_strings_of_string_for_expression_conversion();
        String[] array_of_strings = obj1.convert(s);

        // check for invalid expression

        for (int i=0 ; i<array_of_strings.length ; i++)
        {
            // check if +, -, * are present in beginning or end of the input string, if present then the string is invalid string
            // like in "-12" or "230-45+"
            if ((i==0 || i==array_of_strings.length-1) && (array_of_strings[i].equals("+") || array_of_strings[i].equals("-") || array_of_strings[i].equals("*"))) // "+" and "-" are not allowed to be used as sign and all the operators need an operand in left, which is not present in this case of i==0 and in right, which is not present in case of i==array_of_strings.length-1
            {
                throw new InvalidExprException();
            }

            // for all +, -, * between the first and last indices
            if ((i!=0 && i!=array_of_strings.length-1) && (array_of_strings[i].equals("+") || array_of_strings[i].equals("-") || array_of_strings[i].equals("*")))
            {
                // store characters in left and right of the operator
                String left = array_of_strings[i - 1];
                String right = array_of_strings[i + 1];

                // all the cases of consecutive operators are invalid like  "2+*7" or "3--8"
                // cases when operator is present after "("" and before ")" are invalid like "23(+6)" or "(-2)" or "(7-)"
                if ((left.equals("+") || left.equals("-") || left.equals("*") || left.equals("("))
                        || (right.equals("+") || right.equals("-") || right.equals("*") || right.equals(")"))) {
                    throw new InvalidExprException();
                }
            }
            
            
            if (array_of_strings[i].equals("("))
            {
                // "()" is invalid
                if (i != array_of_strings.length - 1) {
                    if (array_of_strings[i + 1].equals(")")) {
                        throw new InvalidExprException();
                    }

                }

                // ")(" is invalid
                if (i != 0) {
                    if (array_of_strings[i - 1].equals(")")) {
                        throw new InvalidExprException();
                    }

                }

            }
            
            if (array_of_strings[i].equals(")"))
            {
                // "()" is invalid
                if (i != 0) {
                    if (array_of_strings[i - 1].equals("(")) {
                        throw new InvalidExprException();
                    }

                }

                // ")(" is invalid
                if (i != array_of_strings.length - 1) {
                    if (array_of_strings[i + 1].equals("(")) {
                        throw new InvalidExprException();
                    }

                }

            }
            
            
            isInteger obj2 = new isInteger();
            if (obj2.check(array_of_strings[i])) // if the string represents an integer
            {
                // cases like "23 23", "23(", "23)" are invalid
                // when integer is at index 0
                if (i==0)
                {
                    if (obj2.check(array_of_strings[i + 1]) || array_of_strings[i + 1].equals("(")
                            || array_of_strings[i + 1].equals(")")) {
                        throw new InvalidExprException();
                    }
                }
                // cases like "23 23", "(23", ")23" are invalid
                // when integer is at last index
                else if (i==array_of_strings.length-1)
                {
                    if (obj2.check(array_of_strings[i - 1]) || array_of_strings[i - 1].equals("(")
                            || array_of_strings[i - 1].equals(")")) {
                        throw new InvalidExprException();
                    }
                }
                // cases like "23+32 24", "23 34+15", "23+)12" or "12+23(+12"
                else
                {
                    String left = array_of_strings[i - 1];
                    String right = array_of_strings[i + 1];

                    if (obj2.check(left) || obj2.check(right) || left.equals(")") || right.equals("("))
                    {
                        throw new InvalidExprException();
                    }
                } 
            }
        }

        String postfix_string = ""; // initialize final string to be returned

        MyStack S = new MyStack(); // instantiate the stack

        for (int i = 0; i < array_of_strings.length; i++) 
        {
            // (, ), +, -, *, other
            String str = array_of_strings[i];

            if (str.equals("(")) // "(" can be pushed anytime in the stack
            {
                S.push(str);
            } 
            else if (str.equals("*")) // in case the character is "*"
            {
                if (S.isEmpty()) // if stack is empty, it can be pushed
                {
                    S.push(str);
                } 
                else
                {
                    String top_element = ""; // stores top element of the stack
                    try 
                    {
                        top_element = (String) S.top();
                    } catch (Exception e) {
                        
                    }

                    while (top_element.equals("(") == false && top_element.equals("*") == true && S.isEmpty() == false) // pop all the "*" operators from stack and append in the final string as all the "*" should be executed before the "*" in hand, as they appear first in the expression (all * have equal prefrence so whichever appears first, should be executed first). pop untill we find "(" or the stack becomes empty or we find any low precedence operator like "+", "-"
                    {
                        try {
                            postfix_string = postfix_string + (String) S.pop() + " ";
                        } catch (Exception e) {
                            
                        }

                        if (S.isEmpty() == false) {
                            try {
                                top_element = (String) S.top();
                            } catch (Exception e) {
                                
                            }
                        }
                    }
                    S.push(str); // push in hand "*" operator

                }
            } 
            else if (str.equals(")")) // pop all the operators untill we find the nearest "(" parenthesis
            {
                String top_element="";
                try {
                    top_element = (String)S.top();
                } catch (Exception e) {
                    throw new InvalidExprException(); // means there is no operator/"(" parenthesis before ")", therefore invalid expression
                }

                while(top_element.equals("(")==false)
                {
                    try {
                        postfix_string = postfix_string + (String) S.pop() + " ";
                        top_element = (String) S.top();
                    } catch (Exception e) {
                        throw new InvalidExprException(); // this handles the S.top(), this is for the case when stack becomes empty but ")" does not find the matching "("
                    }
                }

                try {
                    S.pop(); // pop "(" paranthesis
                } catch (Exception e) {
                    
                }

            } 
            else if (str.equals("+") || str.equals("-")) // both "+" and "-" have same precedence
            {
                if (S.isEmpty())  // if stack is empty, it can be pushed 
                {
                    S.push(str);
                } 
                else 
                {
                    String top_element = ""; // stores top element of the stack
                    try {
                        top_element = (String) S.top();
                    } catch (Exception e) {
                        
                    }

                    while ( top_element.equals("(") == false && ( top_element.equals("+") || top_element.equals("-") || top_element.equals("*"))
                            && S.isEmpty() == false ) // pop the operators in stack untill we find "(" or stack is empty. "*" operator has higher precendce so should be executed first and "+" and "-" in the stack appear first in the expression so should be executed first
                    {
                        try {
                            postfix_string = postfix_string + (String) S.pop() + " ";
                        } catch (Exception e) {
                            
                        }

                        if (S.isEmpty() == false) {
                            try {
                                top_element = (String) S.top();
                            } catch (Exception e) {
                                
                            }
                        }
                    }
                    S.push(str); // push the "+" or "-" operator in hand

                }
            } 
            else // if str is integer append in the final string to be returned
            {
                postfix_string = postfix_string + str + " ";
            }
        }

        while (S.isEmpty() == false) // after the full iteration append all the operators left in the stack
        {
            String top_element = "";
            try {
                top_element = (String) S.pop();
            } catch (Exception e) {
                throw new InvalidExprException();
            }
            if (top_element.equals("(")) // in case there in "(" left in the stack after the iteration that means that none ")" parenthesis matched with this "(", therefore invalid expression
            {
                throw new InvalidExprException();
            } 
            else {
                postfix_string = postfix_string + top_element + " ";
            }
        }
        
        postfix_string = postfix_string.substring(0, postfix_string.length()-1); // remove the last space added after last append
        return postfix_string;
    }
}