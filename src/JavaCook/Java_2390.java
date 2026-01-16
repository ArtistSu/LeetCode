package JavaCook;

import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author ArtistS
 * @tag String Stack Simulation LC75
 * @prb <a href="https://leetcode.com/problems/removing-stars-from-a-string/description/?envType=study-plan-v2&envId=leetcode-75">...</a>
 * @TimeComplexity: O(n)
 * @SpaceComplexity: O(1)
 */
public class Java_2390 {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '*' && !stack.isEmpty()){
                stack.pop();
            }
            if(ch != '*'){
                stack.push(ch);
            }
        }

        return stack.stream().map(Object::toString).collect(Collectors.joining(""));
    }

    public String removeStarsV2(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                if (sb.length() > 0) {
                    sb.setLength(sb.length() - 1);
                }
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

}