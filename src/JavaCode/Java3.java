package JavaCode;

import java.util.HashSet;
import java.util.Set;

public class Java3 {
    /**
     * Time Complexity: O(n) {@code n} is the length of {@param s} * 2
     * Space Complexity: O(n)
     * @method two pointers
     * @topic Longest Substring Without Repeating Characters
     * @author ArtistS
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int right = -1, res = 0;
        Set<Character> set  = new HashSet<>();
        for(int left = 0; left < len; left++){
            if(left != 0){
                set.remove(s.charAt(left-1));
            }
            while(right +1 < len && !set.contains(s.charAt(right+1))){
                set.add(s.charAt(right+1));
                ++right;
            }
            res = Math.max(res, right-left+1);
        }
        return res;
    }
}
