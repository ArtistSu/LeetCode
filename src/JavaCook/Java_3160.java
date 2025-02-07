package JavaCook;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ArtistS
 * @tag Array HashTable Simulation
 * @prb https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/description/
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_3160 {
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        int[] res = new int[n];
        int distinct = 0;
        Map<Integer, Integer> ballColor = new HashMap<>();
        Map<Integer, Integer> setColors = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int[] query = queries[i];
            int pos = queries[i][0];
            int color = queries[i][1];
            // 1. List set of balls with each color
            if (ballColor.containsKey(pos)) {
                int cnt = setColors.get(ballColor.get(pos)) - 1;
                if (cnt == 0) {
                    setColors.remove(ballColor.get(pos));
                    distinct--;
                } else {
                    setColors.put(ballColor.get(pos), cnt);
                }

            }
            // 2. Update the ball color
            ballColor.put(query[0], query[1]);

            int cnt = setColors.getOrDefault(color, 0) + 1;
            setColors.put(color, cnt);
            if (cnt == 1) {
                distinct++;
            }
            res[i] = distinct;
        }
        return res;
    }

    public static void main(String[] args) {
        new Java_3160().queryResults(4, new int[][]{{1, 4}, {2, 5}, {1, 3}, {3, 4}});
    }
}