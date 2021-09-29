package Easy;

/**
 * Title: Maximum Subarray
 * Knowledge: Greedy algorithm, Dynamic programming
 *
 * @author SuJiexi
 * @version V1.0
 * @Package Easy
 * @date 2019-05-14 11:34
 * Description:
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 */
class Solution53 {

    //greedy algorithm
    //Time complexity: O(n) Space complexity:O(1)
    public int maxSubArray(int[] nums) {
        int arrLength = nums.length;
        if (arrLength == 1) {
            return nums[0];
        }
        if (arrLength == 0) {
            return 0;
        }
        int currentSum = nums[0];
        int result = nums[0];
        for (int i = 1; i < arrLength; i++) {
            if (currentSum < 0) {
                currentSum = nums[i];
                result = Math.max(result, nums[i]);
            } else {
                currentSum += nums[i];
                result = Math.max(currentSum, result);

            }
        }
        return result;
    }

    //Dynamic Programming
    //Time complexity:O(n) Space complexity:O(1)
    public int maxSubArray2(int[] nums) {
        // judge the particular array
        int arrLength = nums.length;
        if (arrLength == 1) {
            return nums[0];
        }
        if (arrLength == 0) {
            return 0;
        }

        // If the previous element more than 0, change the value of the current element in the sum of current element and previous element.
        for (int i = 1; i < arrLength; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
        }

        //Iterate over the new array and find the max value
        int result = nums[0];
        for (int i = 0; i < arrLength; i++) {
            result = Math.max(result, nums[i]);
        }
        return result;
    }

    public int maxSubArray2_Add(int[] nums) {
        // judge the particular array
        int arrLength = nums.length;
        if (arrLength == 1) {
            return nums[0];
        }
        if (arrLength == 0) {
            return 0;
        }

        // If the previous element more than 0, change the value of the current element in the sum of current element and previous element.
        int pre = 0;
        int maxValue = nums[0];
        for (int x : nums) {
            if (pre > 0) {
                maxValue = Math.max(pre + x, maxValue);
                pre += x;
            } else {
                pre = x;
                maxValue = Math.max(x, maxValue);
            }
        }

        return maxValue;
    }

    public int maxSubArray2_Add_2(int[] nums) {
        // judge the particular array
        int arrLength = nums.length;
        if (arrLength == 1) {
            return nums[0];
        }
        if (arrLength == 0) {
            return 0;
        }

        // If the previous element more than 0, change the value of the current element in the sum of current element and previous element.
        int pre = 0;
        int maxValue = nums[0];
        for (int x : nums) {
            pre = Math.max(x, pre + x);
            maxValue = Math.max(pre, maxValue);
        }

        return maxValue;
    }

    //Divide and Conquer
    public class Status {
        public int lSum, rSum, mSum, iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }

        public int maxSubArray(int[] nums) {
            return getInfo(nums, 0, nums.length - 1).mSum;
        }

        public Status getInfo(int[] a, int l, int r) {
            if (l == r) {
                return new Status(a[1], a[1], a[1], a[1]);
            }
            int m = (1 + r) >> 1;
            Status lSub = getInfo(a, 1, m);
            Status rSub = getInfo(a, m + 1, r);
            return pushUp(lSub, rSub);
        }

        public Status pushUp(Status l, Status r) {
            int iSum = l.iSum + r.iSum;
            int lsum = Math.max(l.lSum, l.iSum + r.lSum);
            int rsum = Math.max(r.rSum, r.iSum + l.rSum);
            int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
            return new Status(lSum, rSum, mSum, iSum);
        }
    }


}
