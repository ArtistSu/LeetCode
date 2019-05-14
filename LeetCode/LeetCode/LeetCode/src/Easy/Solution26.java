package Easy;

import java.util.Stack;

/**
 * @author SuJiexi
 * @version V1.0
 * @Package Easy
 * @date 2019-05-13 11:23
 * @Description Given a sorted array nums, remove the duplicates in-place such that each
 * element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input
 * array in-place with O(1) extra memory.
 */
public class Solution26 {

    //TimeComplexity:O(n)
    //SpaceComplexity:O(1)
    public int removeDuplicates(int[] nums) {
        int key = 1;
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                stack.push(nums[i]);
                continue;
            }
            if (stack.peek() == nums[i]) {
                continue;
            } else {
                stack.push(nums[i]);
                nums[key] = nums[i];
                key++;
            }
        }
        return stack.size();
    }

    //TimeComplexity:O(n)
    //SpaceComplexity:O(1)
    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int counter = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[j - 1]) {
                counter++;
                nums[counter] = nums[j];
            }
        }
        return counter + 1;
    }
}

