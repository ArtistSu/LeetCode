package JavaCook;

import java.util.Arrays;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_62 {
    /**
     * @TimeComplexity O(m * n)
     * @SpaceComplexity O(m * n)
     */
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            grid[i][1] = 1;
        }
        for (int j = 1; j <= n; j++) {
            grid[1][j] = 1;
        }

        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
            }
        }

        return grid[m][n];
    }

    /**
     * @TimeComplexity O(m * n)
     * @SpaceComplexity O(n)
     */
    public int uniquePaths_google_l4(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }

        return dp[n - 1];
    }


}