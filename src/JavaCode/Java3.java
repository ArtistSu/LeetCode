package JavaCode;

import java.util.HashSet;
import java.util.Set;

public class Java3 {
    /**
     * Time Complexity: O(n) {@code n} is the length of {@param s}
     * Space Complexity: O(n)
     * @topic Longest Substring Without Repeating Characters
     * @author ArtistS
     * @method two pointers
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        Set<Character> set = new HashSet<>();
        char[] chars = s.toCharArray();

        int res = 0, start = 0, end = 0;
        while (end < chars.length) {
            if (set.contains(chars[end]) && start < end) {
                set.remove(chars[start]);
                start++;
            } else {
                set.add(chars[end]);
                res = Math.max(res, end - start + 1);
                end++;
            }
        }
        return res;
    }
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
