import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author SuJiexi
 * @version V1.0
 * @Package Easy
 * @date 2019-05-09 20:18
 * @Description Given a string containing just the characters'(', ')', '{', '}', '['
 * and ']', determine if the input string is valid.
 */
public class  Solution20 {
    public boolean isValid(String s) {
        Map<Character, Character> bracketMap = new HashMap<Character, Character>();
        bracketMap.put(')', '(');
        bracketMap.put('}', '{');
        bracketMap.put(']', '[');
        char[] bracketArr = s.toCharArray();
        int bracketLength = bracketArr.length;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < bracketLength; i++) {
            char c = s.charAt(i);
            if (bracketMap.containsKey(c)){
                if( stack.isEmpty() || stack.pop() != bracketMap.get(c)){
                    return false;
                }
            }else{
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
