package JavaCook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ArtistS
 * @tag Array HashTable LC75
 * @prb <a href="https://leetcode.com/problems/unique-number-of-occurrences/?envType=study-plan-v2&envId=leetcode-75">...</a>
 * @TimeComplexity: O(n)
 * @SpaceComplexity: O(n)
 */
public class Java_1207 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int num : arr){
            map.put(num, map.getOrDefault(num,0) + 1);
        }

        Set<Integer> set = new HashSet<>();
        for(int num : map.values()){
            if(set.contains(num)) return false;
            set.add(num);
        }
        return true;
    }
}