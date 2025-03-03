package JavaCook;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ArtistS
 * @tag Array TwoPointers Simulation
 * @prb https://leetcode.com/problems/partition-array-according-to-given-pivot/description
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class Java_2161_2 {
    public int[] pivotArray(int[] nums, int pivot) {
        int answer[] = new int[nums.length];
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                answer[l++] = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == pivot) {
                answer[l++] = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > pivot) {
                answer[l++] = nums[i];
            }
        }
        return answer;
    }
}