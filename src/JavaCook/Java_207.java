package JavaCook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_207{
    /**
     * @TimeComplexity
     * @SpaceComplexity
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> courses = new HashSet<>();

        for(int[] prerequisite : prerequisites){
            map.computeIfAbsent(prerequisite[0], v -> new HashSet<>()).add(prerequisite[1]);
            courses.add(prerequisite[0]);
            courses.add(prerequisite[1]);
        }

        for(int course : courses){
            int finish = dfs(course,map, new HashSet<Integer>());
            numCourses -= finish;

            if(numCourses <= 0) return true;
        }

        return false;
    }

    private int dfs(int course, Map<Integer,Set<Integer>> map, Set<Integer> visited){
        if(visited.contains(course)){
            visited.clear();
            return 0;
        }

        visited.add(course);

        for(int dependent: map.get(course)){
            if(dfs(dependent, map, visited) == 0){
                visited.clear();
                break;
            }
        }

        return visited.size();
    }
}