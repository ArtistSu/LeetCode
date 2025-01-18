package JavaCook;

/**
 * @author ArtistS
 * @tag Math
 * @prb https://leetcode.com/problems/excel-sheet-column-title/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder res = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            res.insert(0, (char) ((columnNumber % 26) + 'A'));
            columnNumber = columnNumber / 26;
        }
        return res.toString();
    }
}