package JavaCook;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ArtistS
 * @tag String Backtracking
 * @prb https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/description/
 * Time complexity: O(2^n)
 * Space complexity: O(n)
 */
public class Java_1415_2 {
    String[] res = new String[1];
    int currentCount = 0;

    public String getHappyString(int n, int k) {
        findAllHappyStr(n, k, new StringBuilder());
        return res[0] == null ? "" : res[0];
    }

    public void findAllHappyStr(int n, int k, StringBuilder tempRes) {
        if (tempRes.length() == n) {
            currentCount++;
            if (currentCount == k) {
                res[0] = tempRes.toString();
            }
            return;
        }

        for (char currentChar = 'a'; currentChar <= 'c'; currentChar++) {
            if (tempRes.isEmpty() || tempRes.charAt(tempRes.length() - 1) != currentChar) {
                tempRes.append(currentChar);
                findAllHappyStr(n, k, tempRes);
                if (res[0] != null) return;
                tempRes.deleteCharAt(tempRes.length() - 1);
            }
        }
    }
}