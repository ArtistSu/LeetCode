package JavaCook;

import java.util.*;

/**
 * @author ArtistS
 * @tag stack
 * @prb https://leetcode.com/problems/valid-parentheses/description/
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_20 {
    /**
     * Time complexity: O(N) N is the length of String s
     * Space complexity: O(N)
     */
    public boolean isValid_google_l4(String s) {
        if(s == null) return false;

        Deque<Character> stack = new ArrayDeque<>();

        for(char ch : s.toCharArray()){
            if(ch == '('){
                stack.push(')');
            }else if (ch == '['){
                stack.push(']');
            }else if(ch == '{'){
                stack.push('}');
            }else{
                if(stack.isEmpty() || stack.pop() != ch){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}