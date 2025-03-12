package JavaCook;

/**
 * @author ArtistS
 * @tag Hashtable String SlidingWindow
 * @prb https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_1358 {
    public int numberOfSubstrings(String s) {
        int len = s.length();
        int start = 0, end = 0;

        // Frequency of a,b,c
        int[] freq = new int[3];
        int total = 0;

        while (end < len) {
            char curr = s.charAt(end);
            freq[curr - 'a']++;

            while (hasAllChars(freq)) {
                total += len - end;

                char startChar = s.charAt(start);
                freq[startChar - 'a']--;
                start++;
            }
            end++;
        }

        return total;
    }

    private boolean hasAllChars(int[] freq) {
        // Check if we have at least one of each character
        return freq[0] > 0 && freq[1] > 0 && freq[2] > 0;
    }
}