package JavaCode;

import java.util.HashMap;
import java.util.Map;

public class Java387 {
    /**
     * Time Complexity: O(n) {@param n} is the length of {@param s}
     * Space Complexity: O(n)
     * @topic  First Unique Character in a String
     * @author ArtistS
     * @method Array
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i)-'a']++ ;
        }
        for (int i = 0; i < n; i++) {
            if (arr[s.charAt(i)-'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
