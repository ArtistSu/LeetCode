package JavaCook;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ArtistS
 * @tag HashTable Matrix
 * @prb https://leetcode.com/problems/first-completely-painted-row-or-column/description/
 * Time complexity: O(n) n is the length of arr
 * Space complexity: O(n)
 */
public class Java_2661{
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int rows = mat.length;
        int columns = mat[0].length;

        Map<Integer,int[]> position = new HashMap<>();
        int[] rowCount = new int[rows];
        int[] columnCount = new int[columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                position.put(mat[i][j],new int[]{i,j});
            }
        }

        for (int idx = 0; idx < arr.length; idx++) {
            int[] pos = position.get(arr[idx]);
            if(++rowCount[pos[0]] == columns || ++columnCount[pos[1]] == rows) {
                return idx;
            }
        }
        return -1;
    }
}