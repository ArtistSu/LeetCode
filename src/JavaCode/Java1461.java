package JavaCode;

import java.util.HashSet;
import java.util.Set;

public class Java1461 {

    /**
     * Time Complexity: O(n-k) {@param n} {@param k}
     * Space Complexity: O(2^k)
     * @topic Check If a String Contains All Binary Codes of Size K
     * @author ArtistS
     * @param s
     * @param k
     * @return
     */
    public boolean hasAllCodes(String s, int k) {
        int left = 0, right = k;
        int len = s.length();
        Set<String> set = new HashSet<>();
        while (right <= len) {
            set.add(s.substring(left, right));
            left++;
            right++;
        }
        if (set.size() == Math.pow(2, k))
            return true;
        return false;
    }

}
