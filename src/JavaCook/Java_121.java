package JavaCook;

/**
 * @author ArtistS
 * @tag BruteForce
 * @prb https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class Java_121{
    public int maxProfit(int[] prices) {
        int res = 0;
        int minPrice = prices[0];
        for(int price : prices){
            minPrice = Math.min(minPrice,price);
            res = Math.max(res,price-minPrice);
        }
        return res;
    }
}