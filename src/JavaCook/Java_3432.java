package JavaCook;

/**
 * @author ArtistS
 * @tag Array
 * @prb https://leetcode.com/problems/count-partitions-with-even-sum-difference/description/
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_3432{
    public int countPartitions(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;
        int res = 0;

        // total sum
        for(int i = 0; i < nums.length; i++){
            rightSum += nums[i];
        }

        for(int i = 0; i < nums.length - 1; i++){
            leftSum += nums[i];
            rightSum -= nums[i];
            if((rightSum - leftSum) % 2 == 0){
                res++;
            }
        }

        return res;
    }
}