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
    /**
     * Time complexity:O(N)
     * Space complexity: O(1)
     */
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        char[] s2t = new char[256];
        char[] t2s = new char[256];

        for (int i = 0; i < n; i++) {
            char chs = s.charAt(i);
            char cht = t.charAt(i);

            if(s2t[chs] != 0 && s2t[chs] != cht) return false;
            if(t2s[cht] != 0 && t2s[cht] != chs) return false;

            s2t[chs] = cht;
            t2s[cht] = chs;
        }

        return true;
    }
}