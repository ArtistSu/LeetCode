package JavaCode;

import java.util.*;

public class Java1631 {
    final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    /**
     * Time Complexity:O(row*col*logC) C is the maximum height of the heights[][]
     * Space Complexity: O(row*col)
     * @method Binary Search
     * @param heights
     * @return
     * @method Binary Search
     * @topic Path With Minimum Effort
     * @author ArtistS
     */
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        int left = 0, right = Integer.MAX_VALUE, ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0, 0});
            boolean[] seen = new boolean[row * col];
            seen[0] = true;
            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];
                for (int i = 0; i < 4; i++) {
                    int newX = x + dirs[i][0];
                    int newY = y + dirs[i][1];
                    if (newX >= 0 && newX < row && newY >= 0 && newY < col && !seen[newX * col + newY] && Math.abs(heights[x][y] - heights[newX][newY]) <= mid) {
                        queue.offer(new int[]{newX, newY});
                        seen[newX * col + newY] = true;
                    }
                }
            }
            if (seen[row * col - 1]) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /**
     * Time Complexity:O(row*col*logC) C is the maximum height of the heights[][]
     * Space Complexity: O(row*col)
     * @method Dijkstra Algorithm
     * @param heights
     * @return
     * @method Binary Search
     * @topic Path With Minimum Effort
     * @author ArtistS
     */
    public int minimumEffortPath2(int[][] heights) {
        int row = heights.length;
        int col = heights[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] edge1, int[] edge2) {
                return edge1[2] - edge2[2];
            }
        });
        pq.offer(new int[]{0, 0, 0});
        int[] dist = new int[row * col];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        boolean[] seen = new boolean[row * col];

        while (!pq.isEmpty()) {
            int[] details = pq.poll();
            int x = details[0], y = details[1], difference = details[2];
            int id = col * x + y;
            if (seen[id] == true) {
                continue;
            }
            if (x == row - 1 && y == col - 1) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                int newX = x + dirs[i][0];
                int newY = y + dirs[i][1];
                if (newX >= 0 && newX < row && newY >= 0 && newY < col && Math.max(difference, Math.abs(heights[x][y] - heights[newX][newY])) < dist[newX * col + newY]) {
                    dist[newX * col + newY] = Math.max(difference, Math.abs(heights[x][y] - heights[newX][newY]));
                    pq.offer(new int[]{newX, newY, dist[newX * col + newY]});
                }
            }
        }
        return dist[row * col - 1];
    }
}
