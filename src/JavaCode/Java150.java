package JavaCode;

import java.util.Stack;


public class Java150 {
    /**
     * Time Complexity: O(n) {@param n} is the length of {@param tokens}
     * Space Complexity: O(n)
     * @param tokens
     * @return
     * @topic Evaluate Reverse Polish Notation
     * @author ArtistS
     * @method stack
     */
    public int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.valueOf(tokens[0]);
        }
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens) {
            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                int x = Integer.valueOf(stack.pop());
                int y = Integer.valueOf(stack.pop());
                switch (str) {
                    case "+":
                        stack.push(x + y);
                        break;
                    case "-":
                        stack.push(y - x);
                        break;
                    case "*":
                        stack.push(x * y);
                        break;
                    case "/":
                        stack.push(y / x);
                        break;
                    default:
                }
            } else {
                stack.push(Integer.valueOf(str));
            }
        }
        return stack.pop();
    }
}
