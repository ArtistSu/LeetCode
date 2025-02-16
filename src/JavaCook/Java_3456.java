package JavaCook;

/**
 * @author ArtistS
 * @tag String
 * @prb https://leetcode.com/problems/find-special-substring-of-length-k/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_3456 {
    public boolean hasSpecialSubstring(String s, int k) {
        if (s.length() == 1 && k == 1) return true;

        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1) && count == k) return true;
            if (s.charAt(i) != s.charAt(i - 1)) count = 0;
            count++;
        }
        return count == k;
    }
}