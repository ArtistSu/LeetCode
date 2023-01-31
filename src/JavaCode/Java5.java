package JavaCode;

import java.util.Stack;

public class Java5 {

    /**
     * Time Complexity: O(n^2) {@code n} is the length of {@param s}
     * Space Complexity: O(1)
     * @method Center Diffusion
     * @topic Longest Palindromic Substring
     * @author ArtistS
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if (s == null || len < 1) {
            return "";
        }

        int start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            int len_odd = diffusion(s, i, i);
            int len_even = diffusion(s, i, i + 1);
            int maxLen = Math.max(len_odd, len_even);
            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
                System.out.println(start + " " + end);
            }
        }
        return s.substring(start, end + 1);
    }

    public int diffusion(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }
}
