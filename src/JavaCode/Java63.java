package JavaCode;

public class Java63 {
    /**
     * Time Complexity: O(n * m) {@code n} is the length of {@param obstacleGrid}, {@code m} is the length of {@param obstacleGrid[0]}
     * Space Complexity: O(m)
     * @method DP
     * @topic  Unique Paths II
     * @author ArtistS
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] res = new int[m];

        res[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    res[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    res[j] += res[j - 1];
                }
            }
        }

        return res[m - 1];
    }
}
