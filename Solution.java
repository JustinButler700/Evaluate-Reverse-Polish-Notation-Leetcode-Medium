class Solution {
    public int evalRPN(String[] tokens) {
        // Hold the current digits being operated on
        Stack<Integer> digits = new Stack<>();
        //For all tokens, we check if they are either an operator or digit.
        for(String s : tokens){
            if(s.equals("+") || s.equals("-") || s.equals("*") ||s.equals("/") ){
                //Pop the last 2 nums from the stack.
                int num2 = digits.pop();
                int num1 = digits.pop();
                int result = 0;
                //Operate based on the integer.
                switch(s.charAt(0)){
                    case '-':
                        result = num1-num2;
                        break;
                    case '+':
                        result = num1+num2;
                        break;
                    case '/':
                        result = num1/num2;
                        break;
                    case '*':
                        result = num1*num2;
                        break;
                }
                //push the result, incase more operations need to be done on it.
                digits.push(result);
            }
            else{
                //Char is a digit.
                digits.push(Integer.parseInt(s));
            }
        }
        //return the result
        return digits.pop();
        
    }
}
