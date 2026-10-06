package JavaCook;

/**
 * @author ArtistS
 * @tag
 * @prb
 * @TimeComplexity
 * @SpaceComplexity
 */
public class Java_746{
    /**
     * @TimeComplexity O(2^N)
     * @SpaceComplexity O(N)
     * But this will report TLE
     */
    public int minCostClimbingStairs(int[] cost) {
        int res = Integer.MAX_VALUE;
        dfs(cost,0,0,res);
        dfs(cost,0,1,res);

        return res;
    }

    public void dfs(int[] cost, int sum, int index, int res){
        if(index >= cost.length){
            res = Math.min(res,sum);
            return;
        }
        dfs(cost,sum+cost[index],index+1,res);
        dfs(cost,sum+cost[index],index+2,res);
    }

    /**
     * @TimeComplexity O(N)
     * @SpaceComplexity O(N)
     */
    public int minCostClimbingStairs_google_l4_hire(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 0;

        for(int i = 2; i <= n;i++){
            dp[i] = Math.min(dp[i-1] + cost[i-1],dp[i-2]+cost[i-2]);
        }

        return dp[n];
    }

    /**
     * @TimeComplexity O(N)
     * @SpaceComplexity O(1)
     * Clear the state transition equation
     * Using rolling variable to do space optimization
     */
    public int minCostClimbingStairs_google_l4(int[] cost) {
        int n = cost.length;
        int prev1 = 0, prev2 = 0;

        for(int i = 2; i <= n;i++){
            int curr = Math.min(prev1+cost[i-1],prev2+cost[i-2]);
            prev2=prev1;
            prev1=curr;
        }

        return prev1;
    }
}