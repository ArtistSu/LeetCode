package JavaCode;

public class Java122 {
    /**
     * Time Complexity: O(n) {@param n} is the length of {@param prices}
     * Space Complexity: O(1)
     * @topic Best Time to Buy and Sell Stock II
     * @author ArtistS
     * @method Greedy
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }

    /**
     * Time Complexity: O(n) {@param n} is the length of {@param prices}
     * Space Complexity: O(1)
     * @topic Best Time to Buy and Sell Stock II
     * @author ArtistS
     * @method DP
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int[][] dp = new int[2][2];
        int dp0 = 0, dp1 = -prices[0];
        for(int i = 1; i < prices.length; i++){
            int newdp0 = Math.max(dp0, dp1+prices[i]);
            int newdp1 = Math.max(dp1, dp0-prices[i]);
            dp0 = newdp0;
            dp1 = newdp1;
        }
        return dp0;
    }

    /**
     * Time Complexity: O(n) {@param n} is the length of {@param prices}
     * Space Complexity: O(1)
     * @topic Best Time to Buy and Sell Stock II
     * @author ArtistS
     * @method DP
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
        }
        return dp[prices.length-1][0];
    }
}
