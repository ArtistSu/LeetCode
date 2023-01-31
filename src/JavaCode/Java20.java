package JavaCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Java20 {
    /**
     * Time Complexity: O(n) {@param n} is the length of {@param s}
     * Space Complexity: O(1);
     * @param s
     * @return
     * @topic Valid Parentheses
     * @author ArtistS
     */
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        LinkedList<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (map.containsKey(ch)) {
                stack.addFirst(ch);
            } else {
                if (!stack.isEmpty() && map.get(stack.peek()) == ch) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }
}
