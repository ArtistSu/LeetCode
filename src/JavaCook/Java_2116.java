package JavaCook;

import java.util.Stack;

/**
 * @author ArtistS
 * @tag Stack
 * @prb https://leetcode.com/problems/check-if-a-parentheses-string-can-be-valid/description/
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_2116 {
    public boolean canBeValid(String s, String locked) {
        int len = s.length();
        if(len % 2 == 1){
            return false;
        }
        Stack<Integer> openBrackets = new Stack<>();
        Stack<Integer> unlocked = new Stack<>();
        for(int i =0; i < len;i++){
            if(locked.charAt(i) == '0'){
                unlocked.push(i);
            }else if(s.charAt(i) == '('){
                openBrackets.push(i);
            }else if(s.charAt(i) == ')'){
                if(!openBrackets.empty()){
                    openBrackets.pop();
                }else if(!unlocked.empty()){
                    unlocked.pop();
                }else{
                    return false;
                }
            }
        }

        while(!openBrackets.empty() && !unlocked.empty() && openBrackets.peek() < unlocked.peek()){
            openBrackets.pop();
            unlocked.pop();
        }
        return !openBrackets.empty() == false ? true : false;
    }
}