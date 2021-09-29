package Easy;

/**
 * Title:
 *
 * @author suyuelai
 * @version V1.0
 * @date 2021/1/10 6:37 下午
 * Description:
 */
public class Solution122 {
    public int maxProfit(int[] prices) {
        //1. If prices is empty, return 0
        if (prices.length == 0) {
            return 0;
        }
        //2. Init the basic variables
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        //3. The second way to get the maxProfit
        int temp = 0;
        int currentPrice = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (i + 1 < prices.length) {
                if(currentPrice > prices[i]){
                    currentPrice = prices[i];
                }
                if(prices[i+1]>prices[i]){
                    temp = temp + prices[i+1] -prices[i];
                    currentPrice = prices[i+1];
                }
            }
        }
        return Math.max(temp,maxProfit);
    }
}
