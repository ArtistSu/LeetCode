package JavaCode;

import java.util.Stack;

public class Java1021 {
    /**
     * Time Complexity: O(n) {@code n} is the length of {@param s}
     * Space Complexity: O(1)
     * @method stack
     * @topic Remove Outermost Parentheses
     * @author ArtistS
     * @param s
     * @return
     */
    public String removeOuterParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int ptr = 0, start = 0;
        while(ptr < s.length()){
            char ch = s.charAt(ptr);
            if(ch == '('){
                stack.push(ptr);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    sb.append(s.substring(start+1,ptr));
                    start = ptr+1;
                }
            }
            ptr++;
        }
        return sb.toString();
    }
}
