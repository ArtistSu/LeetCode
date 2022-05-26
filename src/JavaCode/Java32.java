package JavaCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Java32 {
    /**
     * Time Complexity: O(n) {@code n} is the length of {@param s}
     * Space Complexity: O(n)
     * @method Stack
     * @topic Longest Valid Parentheses
     * @author ArtistS
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int res = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.addFirst(-1);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.addFirst(i);
            }else{
                stack.pollFirst();
                if(stack.isEmpty()){
                    stack.addFirst(i);
                }else{
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }
}
