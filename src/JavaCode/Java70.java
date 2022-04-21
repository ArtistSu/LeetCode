package JavaCode;

import java.util.HashMap;
import java.util.Map;

public class Java70 {
    Map<Integer, Integer> intermediateResult = new HashMap<>();
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(intermediateResult.containsKey(n)){
            return intermediateResult.get(n);
        }else{
            intermediateResult.put(n,climbStairs(n-1) + climbStairs(n-2));
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }


    /**
     * Bottom-up
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if(n==1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
