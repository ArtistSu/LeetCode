package JavaCook;

import java.util.*;

/**
 * @author ArtistS
 * @tag DFS BFS Graph TopologicalSort
 * @prb https://leetcode.com/problems/course-schedule-iv/description/
 * Time complexity: O(n^3)
 * Space complexity: O(n^2)
 */
public class Java_1462{
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        Map<Integer,List<Integer>> adjMap = new HashMap<Integer,List<Integer>>();
        int[] indegree = new int[numCourses];

        for(int[] edge : prerequisites){
            adjMap.computeIfAbsent(edge[0],k -> new ArrayList<>()).add(edge[1]);
            indegree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        Map<Integer, Set<Integer>> nodePrerequisites = new HashMap<>();
        while(!queue.isEmpty()){
            int node = queue.poll();
            // prereq -> node -> adjNode
            for (int adjNode :adjMap.getOrDefault(node,new ArrayList<>())){
                nodePrerequisites.computeIfAbsent(adjNode, k-> new HashSet<>()).add(node);
                for (int prereq: nodePrerequisites.getOrDefault(node,new HashSet<>())){
                    nodePrerequisites.get(adjNode).add(prereq);
                }
                indegree[adjNode]--;
                if(indegree[adjNode] == 0) queue.offer(adjNode);
            }
        }

        List<Boolean> res = new ArrayList<>();
        for(int[] query : queries){
            res.add(nodePrerequisites.getOrDefault(query[1],new HashSet<>()).contains(query[0]));
        }
        return res;
    }
}