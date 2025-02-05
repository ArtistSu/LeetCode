package JavaCook;

/**
 * @author ArtistS
 * @tag TwoPointers
 * @prb https://leetcode.com/problems/is-subsequence/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_392 {
    public boolean isSubsequence(String s, String t) {
        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < s.length() && idx2 < t.length()) {
            if (s.charAt(idx1) == t.charAt(idx2)) {
                idx1++;
            }
            idx2++;
        }
        return idx1 == s.length();
    }
}