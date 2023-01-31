package JavaCode;

public class Java121 {
    /**
     * Time Complexity: O(n) {@param n} is the length of {@param prices}
     * Space Complexity: O(1)
     * @topic
     * @author ArtistS
     * @method traverse
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int res = 0, min = Integer.MAX_VALUE;

        for(int i = 0; i< prices.length;i++){
            min = Math.min(min,prices[i]);
            res = Math.max(res, prices[i]-min);
        }
        return res;
    }
}
