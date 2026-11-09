package JavaCook;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_200 {
    /**
     * @TimeComplexity O(m * n)
     * @SpaceComplexity O(1)
     */
    public int numIslands_google_l4(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res += 1;
                    grid[i][j] = '0';

                    Deque<int[]> queue = new ArrayDeque<>();
                    queue.offer(new int[]{i, j});

                    while (!queue.isEmpty()) {
                        int[] site = queue.poll();
                        for (int[] direction : directions) {
                            int newX = site[0] + direction[0];
                            int newY = site[1] + direction[1];

                            if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == '1') {
                                queue.offer(new int[]{newX, newY});
                                grid[newX][newY] = '0';
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}