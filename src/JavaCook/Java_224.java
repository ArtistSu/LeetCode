package JavaCook;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_224 {
    /**
     * @TimeComplexity O(N) N is the length of String s
     * @SpaceComplexity O(N)
     */
    public int calculate_google_l4(String s) {
        if (s == null || s.isEmpty()) return 0;

        Deque<Integer> stack = new ArrayDeque<>();

        int res = 0; // current result
        int sign = 1; // Current number is positive or negative
        int num = 0; // Use for combining complete number

        // Split the numbers and operators
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '+') {
                res += sign * num;
                sign = 1;
                num = 0;
            } else if (c == '-') {
                res += sign * num;
                sign = -1;
                num = 0;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
                num = 0;
            } else if (c == ')') {
                res += sign * num;
                num = 0;

                res *= stack.pop();
                res += stack.pop();
            }
        }

        res += sign * num;
        return res;
    }
}