package JavaCook;

import java.util.*;

/**
 * @author ArtistS
 * @tag BruteForce CharArray
 * @prb https://leetcode.com/problems/word-subsets/description/
 * Time complexity: O(n*k + m*k), K is the average length of the words, n is the number of words in words1, m is the number of words in words2
 * Space complexity: O(1)
 */
public class Java_916 {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxChar = new int[26];
        int[] tempChar = new int[26];

        for (String word : words2) {
            Arrays.fill(tempChar, 0);
            for (char ch : word.toCharArray()) {
                tempChar[ch - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                maxChar[i] = Math.max(maxChar[i], tempChar[i]);
            }
        }

        List<String> res = new LinkedList<>();

        for (String word : words1) {
            Arrays.fill(tempChar, 0);
            for (char ch : word.toCharArray()) {
                tempChar[ch - 'a']++;
            }

            boolean isUniversal = true;

            for (int i = 0; i < 26; i++) {
                if (maxChar[i] > tempChar[i]) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal) {
                res.add(word);
            }
        }
        return res;
    }
}