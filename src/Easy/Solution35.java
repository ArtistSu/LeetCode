

/**
 * @author SuJiexi
 * @version V1.0
 * @Package Easy
 * @date 2019-05-13 14:42
 * @Description Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 */
public class Solution35 {
    //TimeComplexity:O(n)
    //SpaceComplexity:O(1)
    public int searchInsert(int[] nums, int target) {
        if (nums == null && nums.length <= 1) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (target < nums[i] || target == nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    }


