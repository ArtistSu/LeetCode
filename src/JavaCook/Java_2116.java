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
    public boolean canBeValid(String parentheses, String status) {
        if (parentheses.length() % 2 == 1) {
            return false;
        }
        Stack<Integer> open = new Stack<>();
        Stack<Integer> close = new Stack<>();

        for (int i = 0; i < parentheses.length(); i++) {
            char ch = parentheses.charAt(i);
            char ch_sta = status.charAt(i);
            if (ch_sta == '0') {
                close.push(i);
            } else if (ch == '(') {
                open.push(i);
            } else if (ch == ')') {
                if (!open.isEmpty()) {
                    open.pop();
                } else if (!close.isEmpty()) {
                    close.pop();
                } else {
                    return false;
                }
            }
        }
        while (!open.isEmpty() && !close.isEmpty() && open.peek() < close.peek()) {
            open.pop();
            close.pop();
        }
        return open.isEmpty() ? true : false;

    }
}