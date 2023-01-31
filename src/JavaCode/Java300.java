package JavaCode;

public class Java300 {
    /**
     * Time Complexity: O(n^2) {@param n} is the length of {@param nums}
     * Space Complexity: O(n)
     * @topic Longest Increasing Subsequence
     * @author ArtistS
     * @method dp
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        int[] dp = new int[nums.length];
        int maxres = 1;
        dp[0]=1;
        for(int i = 1; i < nums.length; i++){
            dp[i]=1;
            for(int j = 0; j < i; j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            maxres = Math.max(maxres, dp[i]);
        }
        return maxres;
    }
}
