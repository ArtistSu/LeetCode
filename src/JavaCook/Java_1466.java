package JavaCook;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ArtistS
 * @tag DFS Graph
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_1466 {
    private static class Edge {
        final int to;
        final boolean isOriginal;

        Edge(int to, boolean isOriginal) {
            this.to = to;
            this.isOriginal = isOriginal;
        }
    }

    public int minReorder_google_l5(int n, int[][] connections) {

        // we can optimize it slightly by pre-setting the initial capacity for the outer ArrayList to n. This avoids unnecessary resizing and array copying overhead as we add elements.
        List<List<Edge>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            graph.get(from).add(new Edge(to, true));
            graph.get(to).add(new Edge(from, false));
        }

        boolean[] visited = new boolean[n];

        return dfs(0, graph, visited);
    }

    public int dfs(int city, List<List<Edge>> graph, boolean[] visited) {
        visited[city] = true;
        int res = 0;
        for (Edge edge : graph.get(city)) {
            if (!visited[edge.to]) {
                if (edge.isOriginal) {
                    res++;
                }
                res += dfs(edge.to, graph, visited);
            }
        }
        return res;
    }
}