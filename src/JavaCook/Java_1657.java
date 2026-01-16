package JavaCook;

import java.util.Arrays;

/**
 * @author ArtistS
 * @tag HashTable String Sorting Counting LC75
 * @prb <a href="https://leetcode.com/problems/determine-if-two-strings-are-close/description/?envType=study-plan-v2&envId=leetcode-75">...</a>
 * @TimeComplexity: O(n) n is the max length of word1 and word2
 * @SpaceComplexity: O(n)
 */
public class Java_1657 {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(i);
            count1[ch1 - 'a'] += 1;
            count2[ch2 - 'a'] += 1;
        }

        for (int i = 0; i < 26; i++) {
            if ((count1[i] == 0 && count2[i] != 0) || (count1[i] != 0 && count2[i] == 0)) {
                return false;
            }
        }

        Arrays.sort(count1);
        Arrays.sort(count2);

        for (int i = 0; i < count1.length; i++) {
            if (count1[i] != count2[i]) return false;
        }
        return true;
    }
}