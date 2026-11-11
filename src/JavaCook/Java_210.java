package JavaCook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_210{
    /**
     * @TimeComplexity O(V + E) where V = numCourses, E = prerequisites.length
     * @SpaceComplexity O(V + E) for the adjacency list and recursion stack
     */
    public int[] findOrder_google_l4(int numCourses, int[][] prerequisites) {
        // 1. Build an adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int[] prerequisite: prerequisites){
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }

        // 2. Ste status 0: Unvisited 1: In progress 2: Visited
        int[] status = new int[numCourses];
        List<Integer> res = new ArrayList<>(numCourses);

        // 3. Find if have cyclye for every node
        for(int i = 0; i < numCourses; i++){
            if(status[i] == 0){
                if(hasCycle(i,adj,status,res)){
                    return new int[]{};
                }
            }
        }

        // Convert List to primitive int array efficiently
        Collections.reverse(res);
        int[] order = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            order[i] = res.get(i);
        }

        return order;
    }

    public boolean hasCycle(int course, List<List<Integer>> adj, int[] status, List<Integer> res){
        if(status[course] == 1) return true;
        if(status[course] == 2) return false;

        status[course] = 1;

        for(int nextCourse : adj.get(course)){
            if(hasCycle(nextCourse,adj,status,res)){
                return true;
            }
        }
        status[course] = 2;
        res.add(course);

        return false;
    }
}