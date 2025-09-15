package JavaCook;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ArtistS
 * @tag HashTable Array
 * @prb https://leetcode.com/problems/maximum-number-of-words-you-can-type/description/
 * Time complexity: O(n * m) n is the length of text, m is the length of brokenLetters
 * Space complexity: O(n * m)
 */
public class Java_1935_2 {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < brokenLetters.length(); i++) {
            set.add(brokenLetters.charAt(i));
        }

        int count = 0;

        String[] words = text.split(" ");

        for(String word : words) {
            for(char c : word.toCharArray()) {
                if(set.contains(c)){
                    count++;
                    break;
                }
            }
        }

        return words.length - count;
    }

}
