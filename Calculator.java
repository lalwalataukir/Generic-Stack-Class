class Utili 
{
    // Extract the number from the string s, starting with index ind
    public int grab_number(String s, int ind) 
    {
        int j = ind;
        while (j < s.length() && s.charAt(j) - '0' >= 0 && s.charAt(j) - '0' <= 9) {
            j++;
        }
        j--;
        int retInt = 0;
        int pow = 1;
        for (int i = j; i >= ind; i--) {
            retInt = retInt + (s.charAt(i) - '0') * pow;
            pow = pow * 10;
        }
        return retInt;
    }

    // Find number of digits in an integer
    public int numOfDigits(int operand)
    {
        int retInt = 0;
        while(operand>0)
        {
            retInt++;
            operand = operand / 10;
        }
        return retInt;
    }
}

public class Calculator 
{
    // function to evaluate postfix expresssion
    public int evaluatePostFix(String s) throws InvalidPostfixException 
    {
        // check for any negative integer
        for(int i=0; i<s.length(); i++)
        {
            if (i<s.length()-1 && s.charAt(i)=='-' && s.charAt(i+1)-'0'>=0 && s.charAt(i+1)-'0'<=9)
                throw new InvalidPostfixException();
        }

        MyStack stack = new MyStack();
        Utili uti = new Utili();
        for (int i = 0; i < s.length();) 
        {
            if (s.charAt(i) == ' ') // skip spaces
            {
                i++;
            } 
            else if (i < s.length() && s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) // push integer into the stack
            {
                int operand = uti.grab_number(s, i);
                stack.push(operand);
                i = i + uti.numOfDigits(operand);
            } 
            else if (s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '*')
            {
                if ((stack.stack_top_index + 1) < 2) 
                {
                    throw new InvalidPostfixException();
                } 
                else 
                {
                    // take out 2 elements and operate on them
                    int ele1 = 0, ele2 = 0;
                    try  
                    {
                        ele1 = (int) stack.pop();
                        ele2 = (int) stack.pop();
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    if (s.charAt(i) == '+')
                        stack.push(ele1 + ele2);
                    else if (s.charAt(i) == '*')
                        stack.push(ele1 * ele2);
                    else if (s.charAt(i) == '-')
                        stack.push(ele2 - ele1);

                    i++;
                }
            } 
            else 
            {
                throw new InvalidPostfixException();
            }
        }
        int answer = 0;
        if (stack.stack_top_index + 1 == 1) 
        {
            try 
            {
                answer = (int) stack.top();
            } 
            catch (Exception e) 
            {
                // TODO: handle exception
            }
        } 
        else 
        {
            throw new InvalidPostfixException();
        }
        return answer;
    }
}