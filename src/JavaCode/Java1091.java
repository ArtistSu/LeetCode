package JavaCode;

import java.util.Arrays;
import java.util.LinkedList;

public class Java1091 {
    /**
     * Time Complexity: O(n^2) {@code n} is the length of grid[0]
     * Space Complexity: O(n)
     *
     * @topic
     * @author ArtistS
     * @param grid
     * @return
     */
    int res = Integer.MAX_VALUE;
    int[][] directions = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    int m;
    int n;

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid[0][0] != 0) {
            return -1;
        }
        m = grid.length;
        n = grid[0].length;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.addLast(new int[]{0, 0});
        grid[0][0] = 1;

        int res = 1;
        while (!queue.isEmpty()) {

            int size = queue.size();
            while (size-- > 0) {
                int[] currCoordinate = queue.poll();
                int x = currCoordinate[0];
                int y = currCoordinate[1];

                if (x == m - 1 && y == n - 1) {
                    return res;
                }

                for (int i = 0; i < 8; i++) {
                    int newX = x + directions[i][0];
                    int newY = y + directions[i][1];
                    if (newX >= m || newY >= n || newX < 0 || newY < 0 || grid[newX][newY] == 1) {
                        continue;
                    }
                    queue.addLast(new int[]{newX, newY});
                    grid[newX][newY] = 1;
                }
            }
            res++;
        }
        return -1;
    }
}
