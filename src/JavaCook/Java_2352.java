package JavaCook;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ArtistS
 * @tag Array HashTable Matrix Simulation LC75
 * @prb <a href="https://leetcode.com/problems/equal-row-and-column-pairs/description/?envType=study-plan-v2&envId=leetcode-75">...</a>
 * @TimeComplexity: O()
 * @SpaceComplexity: O()
 */
public class Java_2352 {
    public int equalPairs(int[][] grid) {
        Map<String,Integer> map1 = new HashMap<>();
        Map<String,Integer> map2 = new HashMap<>();
        int m = grid.length, n = grid[0].length;

        for(int i = 0; i < m; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j < n; j++){
                sb.append(String.valueOf(grid[i][j]));
                sb.append("-");
            }
            map1.put(sb.toString(),map1.getOrDefault(sb.toString(),0)+1);
        }

        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j < m; j++){
                sb.append(String.valueOf(grid[j][i]));
                sb.append("-");
            }
            map2.put(sb.toString(),map2.getOrDefault(sb.toString(),0)+1);
        }

        int count = 0;
        for (String key : map1.keySet()){
            if(map2.containsKey(key)){
                count += map1.get(key) * map2.get(key);
            }
        }

        return count;
    }
}