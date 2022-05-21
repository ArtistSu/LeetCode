package JavaCode;

import java.util.Arrays;

public class Java322 {
    /**
     * Time Complexity: O(amount * n) {@code n } is the length of {@param coins}, {@param amount}
     * Space Complexity: O(amount+1)
     * @method DP
     * @topic Coin Change
     * @author ArtistS
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] rem = new int[amount + 1];
        Arrays.fill(rem, amount+1);
        rem[0] = 0;
        for(int i = 1; i <= amount; i++){
            for(int coin: coins){
                if(coin <= i){
                    rem[i] = Math.min(rem[i], rem[i - coin] + 1);
                }
            }
        }
        return rem[amount] > amount ? -1: rem[amount];
    }
}
