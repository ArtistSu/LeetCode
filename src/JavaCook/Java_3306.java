package JavaCook;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ArtistS
 * @tag HashTable String SlidingWindow
 * @prb https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii/description
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_3306 {
    public long countOfSubstrings(String word, int k) {
        long numValidSubStrings = 0;
        int start = 0, end = 0, consonantCount = 0;

        // The counts of vowels and consonants
        Map<Character, Integer> vowelCount = new HashMap<>();

        // Compute index of next consonant for all indicies
        int[] nextConsonant = new int[word.length()];
        int nextConsonantIndex = word.length();
        for (int i = word.length() - 1; i >= 0; i--) {
            nextConsonant[i] = nextConsonantIndex;
            if (!isVowel(word.charAt(i))) {
                nextConsonantIndex = i;
            }
        }

        // Start sliding window
        while (end < word.length()) {
            char newLetter = word.charAt(end);

            if (isVowel(newLetter)) {
                vowelCount.put(newLetter, vowelCount.getOrDefault(newLetter, 0) + 1);
            } else {
                consonantCount++;
            }

            // Shrink window if too many consonants in our window
            while (consonantCount > k) {
                char startLetter = word.charAt(start);
                if (isVowel(startLetter)) {
                    vowelCount.put(startLetter, vowelCount.get(startLetter) - 1);
                    if (vowelCount.get(startLetter) == 0) vowelCount.remove(startLetter);
                } else {
                    consonantCount--;
                }
                start++;
            }

            // While we have a valid window, try to shrink it
            while (start < word.length() && vowelCount.keySet().size() == 5 && consonantCount == k) {
                // count the current valid substring, as well as valid substrings produced by appending more vowels
                numValidSubStrings += nextConsonant[end] - end;
                System.out.println(end);
                System.out.println(nextConsonant[end] - end);
                System.out.println(numValidSubStrings);
                System.out.println(word.substring(start, end));
                char startLetter = word.charAt(start);
                if (isVowel(startLetter)) {
                    vowelCount.put(startLetter, vowelCount.get(startLetter) - 1);
                    if (vowelCount.get(startLetter) == 0) vowelCount.remove(startLetter);
                } else {
                    consonantCount--;
                }
                start++;
            }
            end++;
        }
        return numValidSubStrings;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        new Java_3306().countOfSubstrings("iqeaouqi",2);
    }
}