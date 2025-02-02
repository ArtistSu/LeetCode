package JavaCook;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ArtistS
 * @tag Sorting String
 * @prb https://leetcode.com/problems/valid-anagram/description/
 * Time complexity:O(n)
 * Space complexity:O(n)
 */
public class Java_242_2 {
    public boolean isAnagram(String s, String t) {
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();

        Arrays.sort(chs);
        Arrays.sort(cht);
        return Arrays.equals(chs,cht);
    }

    public static void main(String[] args) {
        new Java_242_2().isAnagram("anagram", "nagaram");
    }
}