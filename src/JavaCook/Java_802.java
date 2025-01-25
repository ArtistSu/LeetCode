package JavaCook;

import java.util.*;

/**
 * @author ArtistS
 * @tag DFS Graph TopologicalSort
 * @prb https://leetcode.com/problems/find-eventual-safe-states/description/
 * Time complexity: O(n + e) n is graph.length, e is total edges
 * Space complexity: O(n)
 */
public class Java_802{
    // visit 0-> unvisit 1->process 2->finish
    boolean[] safeNodes;
    public boolean dfs(int[] visit, int[][] adjecent, int currNode){
        visit[currNode] = 1;
        boolean is_safe = true;

        for(int nbr : adjecent[currNode]){
            if(visit[nbr] == 0){
                is_safe &= dfs(visit,adjecent,nbr);
            }else if(visit[nbr] == 1){
                safeNodes[currNode]=false;
                return false;
            }else if(visit[nbr] == 2){
                is_safe &= safeNodes[nbr];
            }
        }
        visit[currNode] = 2;
        safeNodes[currNode] = is_safe;
        return is_safe;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        int[] visit = new int[n];
        safeNodes = new boolean[n];
        Arrays.fill(safeNodes,true);

        for(int i = 0; i < n; i++){
            if(visit[i] == 0){
                dfs(visit,graph,i);
            }
        }

        List<Integer> res = new LinkedList<>();
        for ( int i = 0; i < n; i++){
            if(safeNodes[i]){
                res.add(i);
            }
        }
        return res;
    }
}