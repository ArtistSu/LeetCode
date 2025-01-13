package JavaCook;

/**
 * @author ArtistS
 * @tag Tabulation
 * @prb https://leetcode.com/problems/climbing-stairs/description/
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_70 {
    public int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}