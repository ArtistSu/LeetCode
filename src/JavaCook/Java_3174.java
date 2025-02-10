package JavaCook;

import java.util.Stack;

/**
 * @author ArtistS
 * @tag String Stack Simulation
 * @prb https://leetcode.com/problems/clear-digits/description/
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_3174 {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.add(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        new Java_3174().clearDigits("a1bc");
    }
}