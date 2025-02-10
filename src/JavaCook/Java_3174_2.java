package JavaCook;

import java.util.Stack;

/**
 * @author ArtistS
 * @tag String Stack Simulation
 * @prb https://leetcode.com/problems/clear-digits/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_3174_2 {
    public String clearDigits(String s) {
        int idx = 0;
        StringBuilder sb = new StringBuilder(s);

        while (idx < sb.length()) {
            if (Character.isDigit(sb.charAt(idx))) {
                sb.deleteCharAt(idx);
                if (idx > 0) {
                    sb.deleteCharAt(idx - 1);
                    idx--;
                }
            } else {
                idx++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new Java_3174_2().clearDigits("a1bc");
    }
}