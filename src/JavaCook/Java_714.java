package JavaCook;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity O(N)
 * @SpaceComplexity O(1)
 */
public class Java_714{
    public int maxProfit_google_l4(int[] prices, int fee) {
        // Defensive check for null or insufficient data to execute a trade
        if (prices == null || prices.length < 2) {
            return 0;
        }

        // DP States for Day 0:
        // 'hold': Max profit on day 'i' if we HOLD a stock.
        // 'cash': Max profit on day 'i' if we DO NOT HOLD (in cash) a stock.
        int hold = -prices[0];
        int cash = 0;

        for (int i = 1; i < prices.length; i++) {
            // Transition: Keep previous holding state OR buy at current price
            int newHold = Math.max(hold, cash - prices[i]);
            // Transition: Keep previous cash state OR sell current holding with transaction fee
            int newCash = Math.max(cash, hold + prices[i] - fee);

            hold = newHold;
            cash = newCash;
        }

        // On the final day, selling off any stock will strictly yield higher or equal profit than holding.
        return cash;
    }
}