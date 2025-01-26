package JavaCook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ArtistS
 * @tag String
 * @prb https://leetcode.com/problems/zigzag-conversion/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_6 {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        // 1 -> top to bottom -1 -> bottom to top
        int idx = 0, direction = 1;
        List<Character>[] rows = new ArrayList[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new ArrayList<>();
        }

        for (char c : s.toCharArray()) {
            rows[idx].add(c);
            if (idx == 0) {
                direction = 1;
            } else if (idx == numRows - 1) {
                direction = -1;
            }
            idx += direction;
        }

        StringBuilder sb = new StringBuilder();
        for (List<Character> row : rows) {
            for (char ch : row) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}