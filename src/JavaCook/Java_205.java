package JavaCook;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ArtistS
 * @tag HashTable
 * @prb https://leetcode.com/problems/isomorphic-strings/description/
 * Time complexity:O(n)
 * Space complexity: O(n)
 */
public class Java_205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> dic = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char chs = s.charAt(i);
            char cht = t.charAt(i);
            if (dic.containsKey(chs)) {
                if (dic.get(chs) != cht) {
                    return false;
                }
            } else if (dic.containsValue(cht)) {
                return false;
            }
            dic.put(chs, cht);
        }
        return true;
    }
}