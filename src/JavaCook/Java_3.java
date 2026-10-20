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
public class Java_3{
    /**
     * @TimeComplexity O(N) N is the length of String s.
     * @SpaceComplexity O(N)
     */
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;

        Set<Character> visited = new HashSet<>();
        int left = 0, res = Integer.MIN_VALUE;

        for(int right = 0; right < s.length();right++){
            char curr = s.charAt(right);

            while(visited.contains(curr)){
                visited.remove(s.charAt(left++));
            }

            visited.add(curr);
            res = Math.max(right - left + 1, res);
        }

        return res;
    }

    /**
     * @TimeComplexity O(N) N is the length of String s.
     * @SpaceComplexity O(N)
     */
    public int lengthOfLongestSubstring_google_l4(String s) {
        if(s == null || s.length() == 0) return 0;

        Map<Character,Integer> visited = new HashMap<>();
        int left = 0, res = Integer.MIN_VALUE;

        for(int right = 0; right < s.length();right++){
            char curr = s.charAt(right);

            if(visited.containsKey(curr)){
                left = Math.max(left, visited.get(curr) + 1);
            }

            visited.put(curr,right);
            res = Math.max(right - left + 1, res);
        }

        return res;
    }
}