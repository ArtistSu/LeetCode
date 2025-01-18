package JavaCook;

/**
 * @author ArtistS
 * @tag Math
 * @prb https://leetcode.com/problems/excel-sheet-column-number/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_171 {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char ch = columnTitle.charAt(i);
            res = (ch - 'A' + 1) + res * 26;
        }
        return res;
    }
}