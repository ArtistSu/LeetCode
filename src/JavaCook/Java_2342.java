package JavaCook;

import java.util.*;

/**
 * @author ArtistS
 * @tag Array HashTable Sorting Heap
 * @prb https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/description/
 * Time complexity: O(nlogn)
 * Space complexity: O(n)
 */
public class Java_2342{
    public int maximumSum(int[] nums) {
        Map<Integer, Integer> dic = new HashMap<>();
        int res = -1;
        Arrays.sort(nums);

        for(int i = nums.length-1; i >= 0; i--){
            int digitSum = calculateDigitSum(nums[i]);

            if(dic.containsKey(digitSum)){
                res = Math.max(res,dic.get(digitSum) + nums[i]);
            }else{
                dic.put(digitSum, nums[i]);
            }
        }
        return res;
    }

    public int calculateDigitSum(int num) {
        int digitSum = 0;
        while (num > 0) {
            digitSum += num % 10;
            num /= 10;
        }
        return digitSum;
    }

}