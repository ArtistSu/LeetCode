package JavaCode;

import java.util.Arrays;

public class Java567 {
    /**
     * Time Complexity: O(n) {@param n} is the length of {@param s2}
     * Space Complexity: O(1)
     * @topic Permutation in String
     * @author ArtistS
     * @method Sliding Window
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        // Edge Case
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] lettersA = new int[26];
        int[] lettersB = new int[26];
        for(int i = 0; i < s1.length(); i++){
            lettersA[s1.charAt(i) - 'a']++;
            lettersB[s2.charAt(i) - 'a']++;
        }
        if(Arrays.equals(lettersA, lettersB)){
            return true;
        }

        for(int i = s1.length(); i < s2.length(); i++){
            lettersB[s2.charAt(i) - 'a']++;
            lettersB[s2.charAt(i - s1.length()) - 'a']--;
            if(Arrays.equals(lettersA, lettersB)){
                return true;
            }
        }
        return false;
    }
}
