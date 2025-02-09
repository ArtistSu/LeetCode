package JavaCook;

import java.util.*;

/**
 * @author ArtistS
 * @tag Array HashTable
 * @prb https://leetcode.com/problems/sort-matrix-by-diagonals/description/
 * Time complexity: O(n^2)
 * Space complexity: O(n^2)
 */
public class JaVa_3446 {
    public int[][] sortMatrix(int[][] matrix) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(matrix[i][j]);
            }
        }

        for (int key : map.keySet()) {
            List<Integer> values = map.get(key);
            if (key < 0) {
                Collections.sort(values);
            } else {
                values.sort(Collections.reverseOrder());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                matrix[i][j] = map.get(key).remove(0);
            }
        }
        return matrix;
    }
}