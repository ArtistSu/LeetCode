package JavaCook;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author ArtistS
 * @tag stack
 * @prb https://leetcode.com/problems/valid-parentheses/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_20 {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList();
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');

        char[] chars = s.toCharArray();
        for(char ch : chars){
            if(map.containsKey(ch)){
                stack.addFirst(ch);
            }else if(!stack.isEmpty() && map.get(stack.peek())==ch){
                stack.pop();
            }else{
                return false;
            }
        }
        return stack.isEmpty()?true:false;
    }
}