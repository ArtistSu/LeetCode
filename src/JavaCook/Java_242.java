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
    public boolean isAnagram(String s, String t) {
        if (t.length() > s.length()) {
            return false;
        }

        Map<Character, Integer> dic = new HashMap<>();
        for (char ch : s.toCharArray()) {
            dic.put(ch, dic.getOrDefault(ch, 0) + 1);
        }

        for (char ch : t.toCharArray()) {
            dic.put(ch, dic.getOrDefault(ch, 0) - 1);
        }

        for (int times : dic.values()) {
            if (times != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Java_242().isAnagram("anagram", "nagaram");
    }
}