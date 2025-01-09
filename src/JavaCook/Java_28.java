package JavaCook;

/**
 * @author ArtistS
 * @tag BruteForce
 * @prb https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_28 {
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int needleLen = needle.length();

        for (int i = 0; i <= (haystack.length() - needleLen); i++) {
            if (needle.equals(haystack.substring(i, i + needleLen))) {
                return i;
            }
        }
        return -1;
    }
}