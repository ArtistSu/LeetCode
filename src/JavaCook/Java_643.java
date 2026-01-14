package JavaCook;

/**
 * @author ArtistS
 * @tag Array SlidingWindow LC75
 * @prb <a href="https://leetcode.com/problems/maximum-average-subarray-i/description/?envType=study-plan-v2&envId=leetcode-75">...</a>
 * @TimeComplexity O(n)
 * @SpaceComplexity O(1)
 */
public class Java_643{
    // TimeComplexity:O(n * k) SpaceComplexity:O(1)
    public double findMaxAverage(int[] nums, int k) {
        // Be careful: Double.MIN_VALUE still > 0, so you must use -Double.MAX_VALUE
        double res = -Double.MAX_VALUE;
        int n = nums.length;
        // Edge case
        if (k== 0) return 0.0;

        int start = 0;
        while(start <= n - k){
            int sum = 0;
            for(int i = start; i < start + k; i++){
                sum += nums[i];
            }
            res = Math.max(res,(double)sum/k);
            start++;
        }
        return res;
    }

    public double findMaxAverageV2(int[] nums, int k) {
        int sum = 0;
        // Get the sum of first kth number
        for(int i = 0; i <k; i++){
            sum += nums[i];
        }

        double res = sum;
        for(int i = k; i < nums.length; i++){
            sum = sum - nums[i-k] + nums[i];
            res = Math.max(res,sum);
        }
        return res/k;
    }
}