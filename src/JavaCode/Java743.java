package JavaCode;

import java.util.Arrays;

public class Java743 {
    /**
     * Time Complexity: O(n^2 + m) {@code n} is the value of {@param n}, {@code m} is the length of {@param times}
     * Space Complexity: O(n^2)
     * @method Dijkstra
     * @topic Network Delay Time
     * @author ArtistS
     * @param times
     * @param n
     * @param k
     * @return
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        final int max = 0x3f3f3f3f;
        int[][] weight = new int[n][n];
        int res = 0;

        // transform times
        for (int i = 0; i < n; ++i) {
            Arrays.fill(weight[i], max);
        }

        for (int[] arr : times) {
            int x = arr[0] - 1, y = arr[1] - 1;
            weight[x][y] = arr[2];
        }

        // the distance between start vertex and current vertex
        int[] dis = new int[n];
        Arrays.fill(dis, max);
        // start from k
        dis[k - 1] = 0;

        // dijkstra
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            int x = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (x == -1 || dis[j] < dis[x])) {
                    x = j;
                }
            }
            visited[x] = true;

            for (int j = 0; j < n; j++) {
                dis[j] = Math.min(dis[j], dis[x] + weight[x][j]);
            }
        }
        res = Arrays.stream(dis).max().getAsInt();
        return res == max ? -1 : res;
    }


}
