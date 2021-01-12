package Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Title:
 *
 * @author suyuelai
 * @version V1.0
 * @date 2021/1/10 5:34 下午
 * Description:
 */
public class Solution121 {
    public static void main(String[] args) {
        Solution121 s = new Solution121();
        s.maxProfit(new int[]{2, 4, 1});
    }

    public int maxProfit(int[] prices) {
        //1. If the prices is empty, return 0
        if (prices.length == 0) {
            return 0;
        }
        //2. Define the max and min price variable.
        int minPrice = prices[0];
        int maxPrice = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                maxPrice = prices[i];
            }
            if (prices[i] > minPrice && prices[i] > maxPrice) {
                maxPrice = prices[i];
            }
            result = Math.max(result, maxPrice - minPrice);
        }
        return result;
    }

    public int maxProfit2(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

}
