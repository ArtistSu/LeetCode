package JavaCode;

public class Java926 {
    /**
     * Time Complexity: O(n) {@code n} is the length of {@param s}
     * Space Complexity: O(1)
     * @method: DP
     * @topic: Flip String to Monotone Increasing
     * @author ArtistS
     * @param s
     * @return
     */
    public int minFlipsMonoIncr(String s) {
        int res0 = 0, res1 = 0;
        for (int i = 0; i < s.length(); i++) {
            int newRes0 = res0, newRes1 = Math.min(res0, res1);
            char cur = s.charAt(i);
            if (cur == '1') {
                newRes0++;
            } else {
                newRes1++;
            }
            res0 = newRes0;
            res1 = newRes1;
        }
        return Math.min(res0, res1);
    }
}
