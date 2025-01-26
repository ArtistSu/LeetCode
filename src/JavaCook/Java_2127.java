package JavaCook;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ArtistS
 * @tag DFS Graph TopologicalSort
 * @prb https://leetcode.com/problems/maximum-employees-to-be-invited-to-a-meeting/description/
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_2127{
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] inDegree = new int[n];

        for(int person = 0; person < n; person++){
            inDegree[favorite[person]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int person = 0; person < n; person++){
            if(inDegree[person] == 0){
                queue.offer(person);
            }
        }

        int[] depth = new int[n];
        Arrays.fill(depth,1);

        while(!queue.isEmpty()){
            int currNode = queue.poll();
            int nextNode = favorite[currNode];
            depth[nextNode] = Math.max(depth[nextNode],depth[currNode] + 1);
            if(--inDegree[nextNode] == 0){
                queue.offer(nextNode);
            }
        }

        int longestCycle = 0;
        int twoCycleInvitations = 0;

        for(int person = 0; person < n; person++){
            if(inDegree[person] == 0) continue;

            int cycleLen = 0;
            int current = person;
            while(inDegree[current] != 0){
                inDegree[current] = 0;
                cycleLen++;
                current = favorite[current];
            }

            if(cycleLen == 2){
                twoCycleInvitations += depth[person] + depth[favorite[person]];
            }else{
                longestCycle = Math.max(longestCycle, cycleLen);
            }
        }
        return Math.max(longestCycle, twoCycleInvitations);
    }
}