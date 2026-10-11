package JavaCook;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_122{
    /**
     * @TimeComplexity O(N)
     * @SpaceComplexity O(N)
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] hold = new int[n];
        int[] sell = new int[n];
        hold[0] = -prices[0];


        for(int i = 1; i < n; i++){
            hold[i] = Math.max(hold[i-1],sell[i-1]-prices[i]);
            sell[i] = Math.max(prices[i]+hold[i-1],sell[i-1]);
        }

        return sell[n-1];
    }

    /**
     * @TimeComplexity O(N)
     * @SpaceComplexity O(1)
     */
    public int maxProfit_google_l4(int[] prices) {
        int n = prices.length;

        int hold = -prices[0];
        int sell = 0;

        for(int i = 1; i < n; i++){
            int nextHold = Math.max(hold,sell-prices[i]);
            int nextSell = Math.max(hold+prices[i],sell);
            hold = nextHold;
            sell = nextSell;
        }

        return sell;
    }

    /**
     * @TimeComplexity O(N)
     * @SpaceComplexity O(1)
     */
    public int maxProfit_google_l4_strong(int[] prices) {
        int n = prices.length;

        int profit = 0;

        for(int i = 1; i < n; i++){
            if(prices[i] > prices[i-1]){
                profit += prices[i] - prices[i-1];
            }
        }

        return profit;
    }
}