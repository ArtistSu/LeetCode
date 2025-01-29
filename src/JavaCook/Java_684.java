package JavaCook;

import java.util.*;

/**
 * @author ArtistS
 * @tag
 * @prb
 * Time complexity:
 * Space complexity:
 */
public class Java_684{
    int cycleStart = -1;
    public void DFS(int src, boolean[] visited,List<Integer>[] adjList, int[] parent){
        visited[src] = true;
        for(int adj : adjList[src]){
            if(!visited[adj]){
                parent[adj] = src;
                DFS(adj, visited, adjList,parent);
            }else if (adj != parent[src] && cycleStart == -1){
                cycleStart = adj;
                parent[adj] = src;
            }
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        Arrays.fill(parent,-1);;

        List<Integer>[] adjList = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adjList[i] = new ArrayList<>();
        }

        for(int[] edge: edges){
            adjList[edge[0] - 1].add(edge[1] - 1);
            adjList[edge[1] - 1].add(edge[0] - 1);
        }

        DFS(0,visited,adjList,parent);

        Map<Integer,Integer> cycleNodes = new HashMap<>();
        int node = cycleStart;

        do{
            cycleNodes.put(node,1);
            node = parent[node];
        }while(node != cycleStart);

        for (int i = edges.length - 1; i >= 0; i--) {
            if (
                    cycleNodes.containsKey(edges[i][0] - 1) &&
                            cycleNodes.containsKey(edges[i][1] - 1)
            ) {
                return edges[i];
            }
        }

        return new int[] {};
    }
}