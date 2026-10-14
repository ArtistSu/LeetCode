package JavaCook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ArtistS
 * @tag HashTable String
 * @prb https://leetcode.com/problems/valid-anagram/description/
 * Time complexity:O(n)
 * Space complexity:O(m) m is the number of distinct letters of string s
 */
public class Java_242 {
    /**
     * Time complexity:O(N) N is the length of s
     * Space complexity:O(N)
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character,Integer> dic = new HashMap<>();

        for(char ch : s.toCharArray()){
            dic.put(ch,dic.getOrDefault(ch,0) + 1);
        }

        for(char ch : t.toCharArray()){
            int count = dic.getOrDefault(ch, 0);
            if (count == 0) {
                return false; // t 中字符多于 s，或 s 中根本没有
            }
            if (count == 1) {
                dic.remove(ch);
            } else {
                dic.put(ch, count - 1);
            }
        }
        return dic.isEmpty();
    }

    /**
     * Time complexity:O(N) N is the length of s
     * Space complexity:O(1)
     */
    public boolean isAnagram_google_l4(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] count = new int[26];

        for(int i = 0; i < s.length();i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for(int num : count){
            if(num != 0) return false;
        }

        return true;
    }
}