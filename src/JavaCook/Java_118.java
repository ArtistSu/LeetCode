package JavaCook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ArtistS
 * @tag Math
 * @prb https://leetcode.com/problems/pascals-triangle/description/
 * Time complexity: O(n^2)
 * Space complexity: O(n^2)
 */
public class Java_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        if (numRows == 0) {
            return res;
        }

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        res.add(firstRow);

        for (int i = 1; i < numRows; i++) {
            List<Integer> preRow = res.get(i - 1);
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1);

            for (int j = 1; j < i; j++) {
                currRow.add(preRow.get(j - 1) + preRow.get(j));
            }
            currRow.add(1);
            res.add(currRow);
        }
        return res;
    }
}