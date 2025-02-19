package JavaCook;

import java.util.Stack;

/**
 * @author ArtistS
 * @tag Stack
 * @prb https://leetcode.com/problems/construct-smallest-number-from-di-string/description/
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_2375_3 {
    public String smallestNumber(String pattern) {
        StringBuilder result = new StringBuilder();
        Stack<Integer> numStack = new Stack<>();

        // Iterate through the pattern
        for (int index = 0; index <= pattern.length(); index++) {
            // Push the next number onto the stack
            numStack.push(index + 1);

            // If 'I' is encountered or we reach the end, pop all stack elements
            if (index == pattern.length() || pattern.charAt(index) == 'I') {
                while (!numStack.isEmpty()) {
                    result.append(numStack.pop());
                }
            }
        }
        return result.toString();
    }


    public static void main(String[] args) {
        new Java_2375_3().smallestNumber("IIIDIDDD");
    }
}