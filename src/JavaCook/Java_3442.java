package JavaCook;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ArtistS
 * @tag HashTable
 * @prb https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/description/
 * Time complexity: O(n)
 * Space complexity: O(m) m is the number of distinct letter in string s
 */
public class Java_3442 {
    public int maxDifference(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        for (char ch : s.toCharArray()) {
            dic.put(ch, dic.getOrDefault(ch, 0) + 1);
        }

        int even_min = Integer.MAX_VALUE;
        int odd_max = Integer.MIN_VALUE;

        for (int val : dic.values()) {
            if (val % 2 == 0) {
                even_min = Math.min(even_min, val);
            }
            if (val % 2 != 0) {
                odd_max = Math.max(odd_max, val);
            }
        }
        return odd_max - even_min;
    }
}