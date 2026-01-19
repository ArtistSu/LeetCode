package JavaCook;

/**
 * @author ArtistS
 * @tag Array BinarySearch Matrix PrefixSum
 * @prb <a href="https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/editorial/?envType=daily-question&envId=2026-01-19">...</a>
 * @TimeComplexity: O(mn * Log ( Min ( m, n)))
 * @SpaceComplexity: O(mn)
 */
public class Java_1292 {
    // TimeComplexity: O(mn * Min(m,n)) SpaceComplexity: O(mn)
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;

        int[][] colsum = new int[m][n];
        for (int j = 0; j < n; j++) {
            colsum[0][j] = mat[0][j];
            for (int i = 1; i < m; i++) {
                colsum[i][j] = colsum[i - 1][j] + mat[i][j];
            }
        }

        for (int edge = Math.min(m, n); edge >= 1; edge--) {
            for (int i = 0; i + edge <= m; i++) {
                int currsum = 0;
                for (int k = 0; k < edge; k++) {
                    currsum += colsum[i + edge - 1][k] - (i > 0 ? colsum[i - 1][k] : 0);
                }
                if (currsum <= threshold) return edge;

                for (int j = 1; j + edge <= n; j++) {
                    int add = colsum[i + edge - 1][j + edge - 1] - (i > 0 ? colsum[i - 1][j + edge - 1] : 0);
                    int remove = colsum[i + edge - 1][j - 1] - (i > 0 ? colsum[i - 1][j - 1] : 0);
                    currsum += add - remove;

                    if (currsum <= threshold) return edge;
                }

            }
        }
        return 0;
    }
    // TimeComplexity: O(mn * Log(Min(m,n))) SpaceComplexity: O(mn)
    public int maxSideLengthV2(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
        int[][] P = new int[m+1][n+1];

        // two-dimensional prefix sums
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                P[i][j] = P[i - 1][j] + P[i][j - 1] - P[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }

        int minedge = 1, maxedge = Math.min(m, n), res = 0;
        while (minedge <= maxedge) {
            int mid = (minedge + maxedge) / 2;
            boolean find = false;
            // Due to P is [m+1][n+1]
            for (int i = 1; i + mid - 1 <= m; i++) {
                for (int j = 1; j + mid - 1 <= n; j++) {
                    int sum = P[i + mid - 1][j + mid - 1] - P[i - 1][j + mid - 1] - P[i + mid - 1][j - 1] + P[i - 1][j - 1];
                    if (sum <= threshold) {
                        find = true;
                        break;
                    }
                }
                if (find) break;
            }
            if (find) {
                res = mid;
                minedge = mid + 1;
            } else {
                maxedge = mid - 1;
            }
        }
        return res;
    }
}