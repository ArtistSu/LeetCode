package JavaCook;

/**
 * @author ArtistS
 * @tag Array Matrix
 * @prb https://leetcode.com/problems/count-servers-that-communicate/description/
 * Time complexity: O(m * n)
 * Space complexity: O(m * n)
 */
public class Java_1267 {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;

        int[] rows = new int[m];
        int[] columns = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rows[i] += 1;
                    columns[j] += 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (rows[i] >= 2 || columns[j] >= 2)) {
                    res++;
                }
            }
        }
        return res;
    }
}