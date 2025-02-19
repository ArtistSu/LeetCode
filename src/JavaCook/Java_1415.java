package JavaCook;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ArtistS
 * @tag String Backtracking
 * @prb https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/description/
 * Time complexity: O(2^n)
 * Space complexity: O(2^n)
 */
public class Java_1415 {
    List<String> res = new LinkedList<>();

    public String getHappyString(int n, int k) {
        findAllHappyStr(n, new StringBuilder());
        return k <= res.size() ? res.get(k - 1) : "";
    }

    public void findAllHappyStr(int n, StringBuilder tempRes) {
        if (tempRes.length() == n) {
            res.add(tempRes.toString());
            return;
        }

        for (char currentChar = 'a'; currentChar <= 'c'; currentChar++) {
            if (tempRes.isEmpty() || tempRes.charAt(tempRes.length() - 1) != currentChar) {
                tempRes.append(currentChar);
                findAllHappyStr(n, tempRes);
                tempRes.deleteCharAt(tempRes.length() - 1);
            }
        }
    }
}