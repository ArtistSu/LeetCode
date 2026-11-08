package JavaCook;

/**
 * @author ArtistS
 * @tag Tabulation
 * @prb https://leetcode.com/problems/climbing-stairs/description/
 * Time complexity:
 * Space complexity:
 */
public class Java_70 {
    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public int climbStairs_google_l4(int n) {
        if (n <= 1) return n;

        int prev2 = 1;
        int prev1 = 1;
        int curr = 0;

        for (int i = 2; i <= n; i++) {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
}