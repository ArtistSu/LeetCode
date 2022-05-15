package JavaCode;

import java.util.*;

public class Java785 {

    private final int unColor = 0;
    private final int red = 1;
    private final int green = 2;
    private int[] colors;
    private boolean flag;

    /**
     * Time Complexity : O(graph.length + graph[0].length)
     * Space Complexity: O(graph.length + graph[0].length)
     * @method DFS
     * @topic Is Graph Bipartite
     * @author ArtistS
     * @param graph
     * @return
     */
    public boolean isBipartite(int[][] graph) {

        int len = graph.length;
        colors = new int[len];
        flag = true;
        Arrays.fill(colors, unColor);
        for (int i = 0; i < len; i++) {
            if (colors[i] == unColor) {
                dfs(graph, i, red);
                if (!flag) {
                    return false;
                }
            }
        }
        return true;
    }

    public void dfs(int[][] graph, int currNode, int color) {
        colors[currNode] = color;
        int nextColor = color == red ? green : red;

        for (int adjacentNode : graph[currNode]) {
            if (colors[adjacentNode] == unColor) {
                dfs(graph, adjacentNode, nextColor);
                if (!flag) {
                    return;
                }
            } else if (colors[adjacentNode] != nextColor) {
                flag = false;
                return;
            }
        }
    }
}
